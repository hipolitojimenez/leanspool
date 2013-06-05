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



public class Printers {
	
	
	private static final Log LOG = LogFactory.getLog(Printers.class);
	
	
	private DataSource printersDataSource;
	
	
	public Printers() throws PrintersException {
		try {
			printersDataSource =
				DataSourceUtils.buildDataSource("/jdbc.properties");
		} catch (Exception exc) {
			LOG.fatal("Cannot create datasource '/jdbc.properties'", exc);
			throw new PrintersException(
				"Cannot create datasource '/jdbc.properties'", exc);
		}
	}
	
	
	public Printers(DataSource dataSource) {
		printersDataSource = dataSource;
	}
	
	
	public List<PrinterModel> getPrinters() throws PrintersException {
		Connection connection = getSelectConnection();
		Statement statement = getSelectStatement(connection);
		try {
			List<PrinterModel> printerModelList = new ArrayList<PrinterModel>();
			ResultSet resultSet = statement.executeQuery("SELECT PrinterName FROM Printer ORDER BY PrinterName");
			while (resultSet.next()) {
				String printerKey = resultSet.getString(1);
				PrinterModel printerModel = new PrinterModelImpl(printerKey);
				printerModelList.add(printerModel);
			}
			return printerModelList;
		} catch (SQLException sqle) {
			LOG.error("Cannot get printers", sqle);
			throw new PrintersException("Cannot get printers", sqle);
		} finally {
			silentCloseStatement(statement);
			silentCloseConnection(connection);
		}
	}
	
	
	private void silentCloseConnection(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException sqle) {
				LOG.error("Cannot silently close connection", sqle);
			}
		}
	}
	
	
	private void silentCloseStatement(Statement statement) {
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException sqle) {
				LOG.error("Cannot silently close statement", sqle);
			}
		}
	}
	
	
	private Statement getSelectStatement(Connection connection)
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
