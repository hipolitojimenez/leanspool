package com.nioos.leanspool.printjobs;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.nioos.leanspool.gxt.shared.PrintJobModel;
import com.nioos.leanspool.printer.DataSourceUtils;



/**
 * The print jobs DAO.
 * @author Hipolito Jimenez.
 *
 */
public class PrintJobsDao {
	
	
	/**
	 * Cannot get print jobs literal.
	 */
	private static final String CANNOT_GET_PRINT_JOBS =
		"Cannot get print jobs";
	
	
	/**
	 * The logger.
	 */
	private static final Log LOG = LogFactory.getLog(PrintJobsDao.class);
	
	
	/**
	 * The datasource.
	 */
	private transient DataSource printJobsDataSource;
	
	
	/**
	 * Constructor.
	 * @throws PrintJobsException on error.
	 */
	public PrintJobsDao() throws PrintJobsException {
		try {
			printJobsDataSource =
				DataSourceUtils.buildDataSource("/jdbc.properties");
		} catch (Exception exc) {
			LOG.fatal("Cannot create datasource '/jdbc.properties'", exc);
			throw new PrintJobsException(
				"Cannot create datasource '/jdbc.properties'", exc);
		}
	}
	
	
	/**
	 * Constructor.
	 * @param dataSource the data source to be used.
	 */
	public PrintJobsDao(final DataSource dataSource) {
		printJobsDataSource = dataSource;
	}
	
	
	/**
	 * Gets the print job list for the given printer.
	 * @param printer the printer name.
	 * @return the print job list for the given printer.
	 * @throws PrintJobsException on error.
	 */
	public final List<PrintJobModel> getPrintJobsForPrinter(
			final String printer) throws PrintJobsException {
		final Connection connection = getSelectConnection(); // NOPMD
		final PreparedStatement preparedStatement =
			getSelectPreparedStatement(connection,
			"SELECT JobId, JobStatus FROM PrintJob"
			+ " WHERE PrinterName = ? ORDER BY JobId");
		try {
			final List<PrintJobModel> printJobModelList =
				new ArrayList<PrintJobModel>();
			preparedStatement.setString(1, printer);
			final ResultSet resultSet = // NOPMD
				preparedStatement.executeQuery();
			while (resultSet.next()) {
				final String jobId = resultSet.getString(1);
				final String jobStatus = resultSet.getString(2);
				final PrintJobModel printJobModel =
					new PrintJobModelImpl(); // NOPMD
				printJobModel.setJobId(jobId);
				printJobModel.setPrinterName(printer);
				printJobModel.setJobStatus(jobStatus);
				printJobModelList.add(printJobModel);
			}
			resultSet.close();
			return printJobModelList;
		} catch (SQLException sqle) {
			LOG.error(CANNOT_GET_PRINT_JOBS, sqle);
			throw new PrintJobsException(CANNOT_GET_PRINT_JOBS, sqle);
		} finally {
			silentCloseStatement(preparedStatement);
			silentCloseConnection(connection);
		}
	}
	
	
	/**
	 * Gets the print job list.
	 * @return the print job list.
	 * @throws PrintJobsException on error.
	 */
	public final List<PrintJobModel> getPrintJobs() throws PrintJobsException {
		final Connection connection = getSelectConnection(); // NOPMD
		final Statement statement = getSelectStatement(connection); // NOPMD
		try {
			final List<PrintJobModel> printJobModelList =
				new ArrayList<PrintJobModel>();
			final ResultSet resultSet = // NOPMD
				statement.executeQuery(
					"SELECT JobId, PrinterName, JobStatus"
					+ " FROM PrintJob ORDER BY JobId");
			while (resultSet.next()) {
				final String jobId = resultSet.getString(1);
				final String printerName = resultSet.getString(2);
				final String jobStatus = resultSet.getString(3);
				final PrintJobModel printJobModel =
					new PrintJobModelImpl(); // NOPMD
				printJobModel.setJobId(jobId);
				printJobModel.setPrinterName(printerName);
				printJobModel.setJobStatus(jobStatus);
				printJobModelList.add(printJobModel);
			}
			resultSet.close();
			return printJobModelList;
		} catch (SQLException sqle) {
			LOG.error(CANNOT_GET_PRINT_JOBS, sqle);
			throw new PrintJobsException(CANNOT_GET_PRINT_JOBS, sqle);
		} finally {
			silentCloseStatement(statement);
			silentCloseConnection(connection);
		}
	}
	
	
	/**
	 * Silently close the jdbc connection.
	 * @param connection the jdbc connection.
	 */
	private void silentCloseConnection(final Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException sqle) {
				LOG.error("Cannot silently close connection", sqle);
			}
		}
	}
	
	
	/**
	 * Silently close the jdbc statement.
	 * @param statement the jdbc statement.
	 */
	private void silentCloseStatement(final Statement statement) {
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException sqle) {
				LOG.error("Cannot silently close statement", sqle);
			}
		}
	}
	
	
	/**
	 * Gets and prepare a select jdbc statement from a jdbc connection.
	 * @param connection the jdbc connection.
	 * @return the jdbc statement.
	 * @throws PrintJobsException on error.
	 */
	private Statement getSelectStatement(final Connection connection)
			throws PrintJobsException {
		try {
			final Statement statement = // NOPMD
				connection.createStatement(ResultSet.TYPE_FORWARD_ONLY,
					ResultSet.CONCUR_READ_ONLY);
			return statement;
		} catch (SQLException sqle) {
			LOG.fatal("Cannot get sql statement", sqle);
			throw new PrintJobsException("Cannot get sql statement", sqle);
		}
	}
	
	
	/**
	 * Gets and prepare a select jdbc preparedstatement from a jdbc connection.
	 * @param connection the jdbc connection.
	 * @param sqlStatement the sql statement.
	 * @return the jdbc prepared statement.
	 * @throws PrintJobsException on error.
	 */
	private PreparedStatement getSelectPreparedStatement(
				final Connection connection, final String sqlStatement)
			throws PrintJobsException {
		try {
			final PreparedStatement preparedStatement = // NOPMD
				connection.prepareStatement(sqlStatement,
					ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			return preparedStatement;
		} catch (SQLException sqle) {
			LOG.fatal("Cannot get sql prepared statement", sqle);
			throw new PrintJobsException("Cannot get sql prepared statement",
				sqle);
		}
	}
	
	
	/**
	 * Gets and prepare a select jdbc connection.
	 * @return the jdbc connection.
	 * @throws PrintJobsException on error.
	 */
	private Connection getSelectConnection() throws PrintJobsException {
		try {
			final Connection connection = // NOPMD
					printJobsDataSource.getConnection();
			connection.setAutoCommit(false);
			//
			connection.setReadOnly(true);
			//
			return connection;
		} catch (SQLException sqle) {
			LOG.fatal("Cannot get sql connection", sqle);
			throw new PrintJobsException("Cannot get sql connection", sqle);
		}
	}
	
	
}
