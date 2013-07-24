package com.nioos.leanspool.printjobs;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.nioos.leanspool.dao.BaseDao;
import com.nioos.leanspool.dao.DaoException;
import com.nioos.leanspool.gxt.shared.PrintJobModel;



/**
 * The print jobs DAO.
 * @author Hipolito Jimenez.
 *
 */
public class PrintJobsDao extends BaseDao {
	
	
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
	 * Constructor.
	 * @throws DaoException on error.
	 */
	public PrintJobsDao() throws DaoException {
		super();
	}
	
	
	/**
	 * Gets the print job list for the given printer.
	 * @param printer the printer name.
	 * @return the print job list for the given printer.
	 * @throws PrintJobsException on error.
	 * @throws DaoException on error.
	 */
	public final List<PrintJobModel> getPrintJobsForPrinter(
			final String printer) throws PrintJobsException, DaoException {
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
	 * @throws DaoException on error.
	 */
	public final List<PrintJobModel> getPrintJobs()
			throws PrintJobsException, DaoException {
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
	 * Gets the print job list with the given status.
	 * @param status the print job status.
	 * @return the print job list with the given status.
	 * @throws PrintJobsException on error.
	 * @throws DaoException  on error.
	 */
	public final List<PrintJobModel> getPrintJobsForStatus(final String status)
			throws PrintJobsException, DaoException {
		final Connection connection = getSelectConnection(); // NOPMD
		final PreparedStatement preparedStatement =
			getSelectPreparedStatement(connection,
			"SELECT JobId, PrinterName FROM PrintJob"
			+ " WHERE JobStatus = ? ORDER BY JobId");
		try {
			final List<PrintJobModel> printJobModelList =
				new ArrayList<PrintJobModel>();
			preparedStatement.setString(1, status);
			final ResultSet resultSet = // NOPMD
				preparedStatement.executeQuery();
			while (resultSet.next()) {
				final String jobId = resultSet.getString(1);
				final String printerName = resultSet.getString(2);
				final PrintJobModel printJobModel =
					new PrintJobModelImpl(); // NOPMD
				printJobModel.setJobId(jobId);
				printJobModel.setPrinterName(printerName);
				printJobModel.setJobStatus(status);
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
	
	
}
