package com.nioos.leanspool.dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;



/**
 * Abstract base DAO.
 * @author Hipolito Jimenez.
 */
public class BaseDao {
	
	
	/**
	 * The logger.
	 */
	private static final Log LOG = LogFactory.getLog(BaseDao.class);
	
	
	/**
	 * The datasource.
	 */
	private transient DataSource dataSource;
	
	
	/**
	 * Constructor.
	 * @throws DaoException on error.
	 */
	protected BaseDao() throws DaoException {
		try {
			dataSource =
				DataSourceUtils.buildDataSource("/jdbc.properties");
		} catch (Exception exc) {
			LOG.fatal("Cannot create datasource '/jdbc.properties'", exc);
			throw new DaoException(
				"Cannot create datasource '/jdbc.properties'", exc);
		}
	}
	
	
	/**
	 * Constructor.
	 * @param theDataSource the data source to be used.
	 */
	protected BaseDao(final DataSource theDataSource) {
		dataSource = theDataSource;
	}
	
	
	/**
	 * Silently close the jdbc connection.
	 * @param connection the jdbc connection.
	 */
	public final void silentCloseConnection(final Connection connection) {
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
	public final void silentCloseStatement(final Statement statement) {
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
	 * @throws DaoException on error.
	 */
	public final Statement getSelectStatement(final Connection connection)
			throws DaoException {
		try {
			final Statement statement = // NOPMD
				connection.createStatement(ResultSet.TYPE_FORWARD_ONLY,
					ResultSet.CONCUR_READ_ONLY);
			return statement;
		} catch (SQLException sqle) {
			LOG.fatal("Cannot get sql statement", sqle);
			throw new DaoException("Cannot get sql statement", sqle);
		}
	}

	/**
	 * Gets and prepare a select jdbc connection.
	 * @return the jdbc connection.
	 * @throws DaoException on error.
	 */
	public final Connection getSelectConnection() throws DaoException {
		try {
			final Connection connection = // NOPMD
				dataSource.getConnection();
			connection.setAutoCommit(false);
			//
			connection.setReadOnly(true);
			//
			return connection;
		} catch (SQLException sqle) {
			LOG.fatal("Cannot get sql connection", sqle);
			throw new DaoException("Cannot get sql connection", sqle);
		}
	}
	
	
	/**
	 * Gets and prepare a select jdbc preparedstatement from a jdbc connection.
	 * @param connection the jdbc connection.
	 * @param sqlStatement the sql statement.
	 * @return the jdbc prepared statement.
	 * @throws DaoException on error.
	 */
	public final PreparedStatement getSelectPreparedStatement(
				final Connection connection, final String sqlStatement)
			throws DaoException {
		try {
			final PreparedStatement preparedStatement = // NOPMD
				connection.prepareStatement(sqlStatement,
					ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			return preparedStatement;
		} catch (SQLException sqle) {
			LOG.fatal("Cannot get sql prepared statement", sqle);
			throw new DaoException("Cannot get sql prepared statement",
				sqle);
		}
	}
	
	
}