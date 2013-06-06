package com.nioos.leanspool.printer;



import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.nioos.leanspool.gxt.shared.PrinterModel;



/**
 * The printer DAO.
 * @author Hipolito Jimenez.
 *
 */
public class PrinterDao {
	
	
	/**
	 * The logger.
	 */
	private static final Log LOG = LogFactory.getLog(PrinterDao.class);
	
	
	/**
	 * The datasource.
	 */
	private DataSource printersDataSource;
	
	
	/**
	 * Constructor.
	 * @throws PrintersException on error.
	 */
	public PrinterDao() throws PrintersException {
		try {
			printersDataSource =
				DataSourceUtils.buildDataSource("/jdbc.properties");
		} catch (Exception exc) {
			LOG.fatal("Cannot create datasource '/jdbc.properties'", exc);
			throw new PrintersException(
				"Cannot create datasource '/jdbc.properties'", exc);
		}
	}
	
	
	/**
	 * Constructor.
	 * @param dataSource the data source to be used.
	 */
	public PrinterDao(final DataSource dataSource) {
		printersDataSource = dataSource;
	}
	
	
	/**
	 * Retrieves the printer list.
	 * @return the printer list.
	 * @throws PrintersException on error.
	 */
	public final List<PrinterModel> getPrinters() throws PrintersException {
		Connection connection = getSelectConnection();
		Statement statement = getSelectStatement(connection);
		try {
			List<PrinterModel> printerModelList = new ArrayList<PrinterModel>();
			ResultSet resultSet =
				statement.executeQuery(
					"SELECT PrinterName FROM Printer ORDER BY PrinterName");
			while (resultSet.next()) {
				String printerKey = resultSet.getString(1);
				PrinterModel printerModel = new PrinterModelImpl(printerKey);
				printerModelList.add(printerModel);
			}
			resultSet.close();
			return printerModelList;
		} catch (SQLException sqle) {
			LOG.error("Cannot get printers", sqle);
			throw new PrintersException("Cannot get printers", sqle);
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
	 * @throws PrintersException on error.
	 */
	private Statement getSelectStatement(final Connection connection)
			throws PrintersException {
		try {
			Statement statement =
				connection.createStatement(ResultSet.TYPE_FORWARD_ONLY,
					ResultSet.CONCUR_READ_ONLY);
			return statement;
		} catch (SQLException sqle) {
			LOG.fatal("Cannot get sql statement", sqle);
			throw new PrintersException("Cannot get sql statement", sqle);
		}
	}
	
	
	/**
	 * Gets and prepare a select jdbc connection.
	 * @return the jdbc connection.
	 * @throws PrintersException on error.
	 */
	private Connection getSelectConnection() throws PrintersException {
		try {
			Connection connection = printersDataSource.getConnection();
			connection.setAutoCommit(false);
			//
			connection.setReadOnly(true);
			//
			return connection;
		} catch (SQLException sqle) {
			LOG.fatal("Cannot get sql connection", sqle);
			throw new PrintersException("Cannot get sql connection", sqle);
		}
	}
	
	
}
