package com.nioos.leanspool.printjobs;



import java.io.File;
import java.util.List;

import javax.sql.DataSource;

import org.dbunit.database.DatabaseDataSourceConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.Assert;

import org.junit.Test;

import com.nioos.leanspool.dao.DataSourceUtils;
import com.nioos.leanspool.dao.PaginationParameters;
import com.nioos.leanspool.dao.SortAndPaginationParameters;
import com.nioos.leanspool.dao.SortParameters;
import com.nioos.leanspool.gxt.client.container.GridContentPanel;
import com.nioos.leanspool.gxt.shared.PrintJobModel;



/**
 * Tests the print job DAO.
 * @author Hipolito Jiménez.
 */
public class PrintJobsDaoTest {
	
	
	/**
	 * Data file used to fill the database.
	 */
	private static final String DB_DATA_FILE =
		"./src/test/resources/dbunit/PrintJobsTest.xml";
	
	
	/**
	 * JDBC properties file.
	 */
	private static final String JDBC_PROPERTIES = "/jdbc.properties";
	
	
	/**
	 * Number of print jobs for "Printer01".
	 */
	private static final int NUMBEROFPRINTJOBSFORPRINTER01 = 99;
	
	
	/**
	 * Number of print jobs with status "New".
	 */
	private static final int NUMBEROFPRINTJOBSFORSTATUSNEW = 97;
	
	
	/**
	 * Get Print Jobs For Printer Test.
	 * @throws Exception on error.
	 */
	@Test
	public final void testGetPrintJobsForPrinter() throws Exception { // NOPMD
		final DataSource dataSource =
			DataSourceUtils.buildDataSource(JDBC_PROPERTIES);
		//
		final IDatabaseConnection dbConnection =
			new DatabaseDataSourceConnection(dataSource);
		final FlatXmlDataSetBuilder flatXmlDataSetBuilder =
			new FlatXmlDataSetBuilder();
		final IDataSet dataSet =
			flatXmlDataSetBuilder.build(new File(DB_DATA_FILE));
		DatabaseOperation.CLEAN_INSERT.execute(dbConnection, dataSet);
		dbConnection.getConnection().commit();
		dbConnection.close();
		//
		final PrintJobsDao printJobsDao = new PrintJobsDao();
		final SortParameters sortParameters =
			new SortParameters("JobId", "ASC");
		final PaginationParameters pagParameters =
			new PaginationParameters(50, 0);
		final SortAndPaginationParameters sapp =
			new SortAndPaginationParameters(sortParameters, pagParameters);
		final List<PrintJobModel> printJobList =
			printJobsDao.getPrintJobsForPrinter("Printer01", sapp); // NOPMD
		Assert.assertEquals("Invalid print jobs list size",
			GridContentPanel.PAGESIZE, printJobList.size());
		final PrintJobModel printJob = printJobList.get(0);
		final String printerName = printJob.getPrinterName();
		Assert.assertEquals("Invalid print name", "Printer01", printerName);
		final String jobId = printJob.getJobId();
		Assert.assertEquals("Invalid print job ID", "jobId01", jobId);
	}
	
	
	/**
	 * Get Print Jobs Test.
	 * @throws Exception on error.
	 */
	@Test
	public final void testGetPrintJobs() throws Exception { // NOPMD
		final DataSource dataSource =
			DataSourceUtils.buildDataSource(JDBC_PROPERTIES);
		//
		final IDatabaseConnection dbConnection =
			new DatabaseDataSourceConnection(dataSource);
		final FlatXmlDataSetBuilder flatXmlDataSetBuilder =
			new FlatXmlDataSetBuilder();
		final IDataSet dataSet =
			flatXmlDataSetBuilder.build(new File(DB_DATA_FILE));
		DatabaseOperation.CLEAN_INSERT.execute(dbConnection, dataSet);
		dbConnection.getConnection().commit();
		dbConnection.close();
		//
		final PrintJobsDao printJobsDao = new PrintJobsDao();
		final SortParameters sortParameters =
			new SortParameters("JobId", "ASC");
		final PaginationParameters pagParameters =
			new PaginationParameters(50, 0);
		final SortAndPaginationParameters sapp =
			new SortAndPaginationParameters(sortParameters, pagParameters);
		final List<PrintJobModel> printJobList =
			printJobsDao.getPrintJobs(sapp);
		Assert.assertEquals("Invalid print jobs list size",
			GridContentPanel.PAGESIZE, printJobList.size());
		final PrintJobModel printJob = printJobList.get(0);
		final String printerName = printJob.getPrinterName();
		Assert.assertEquals("Invalid print name", "Printer01", printerName);
		final String jobId = printJob.getJobId();
		Assert.assertEquals("Invalid print job ID", "jobId01", jobId);
	}
	
	
	/**
	 * Get Print Jobs For Status Test.
	 * @throws Exception on error.
	 */
	@Test
	public final void testGetPrintJobsForStatus() throws Exception { // NOPMD
		final DataSource dataSource =
			DataSourceUtils.buildDataSource(JDBC_PROPERTIES);
		//
		final IDatabaseConnection dbConnection =
			new DatabaseDataSourceConnection(dataSource);
		final FlatXmlDataSetBuilder flatXmlDataSetBuilder =
			new FlatXmlDataSetBuilder();
		final IDataSet dataSet =
			flatXmlDataSetBuilder.build(new File(DB_DATA_FILE));
		DatabaseOperation.CLEAN_INSERT.execute(dbConnection, dataSet);
		dbConnection.getConnection().commit();
		dbConnection.close();
		//
		final PrintJobsDao printJobsDao = new PrintJobsDao();
		final SortParameters sortParameters =
			new SortParameters("JobId", "ASC");
		final PaginationParameters pagParameters =
			new PaginationParameters(50, 0);
		final SortAndPaginationParameters sapp =
			new SortAndPaginationParameters(sortParameters, pagParameters);
		final List<PrintJobModel> printJobList =
			printJobsDao.getPrintJobsForStatus("New", sapp);
		Assert.assertEquals("Invalid print jobs list size",
			GridContentPanel.PAGESIZE, printJobList.size());
		final PrintJobModel printJob = printJobList.get(0);
		final String printerName = printJob.getPrinterName();
		Assert.assertEquals("Invalid print name", "Printer01", printerName);
		final String jobId = printJob.getJobId();
		Assert.assertEquals("Invalid print job ID", "jobId01", jobId);
	}
	
	
	/**
	 * Gets the number of Print Jobs For Printer Test.
	 * @throws Exception on error.
	 */
	@Test
	public final void testGetNumberOfPrintJobsForPrinter()
			throws Exception { // NOPMD
		final DataSource dataSource =
			DataSourceUtils.buildDataSource(JDBC_PROPERTIES);
		//
		final IDatabaseConnection dbConnection =
			new DatabaseDataSourceConnection(dataSource);
		final FlatXmlDataSetBuilder flatXmlDataSetBuilder =
			new FlatXmlDataSetBuilder();
		final IDataSet dataSet =
			flatXmlDataSetBuilder.build(new File(DB_DATA_FILE));
		DatabaseOperation.CLEAN_INSERT.execute(dbConnection, dataSet);
		dbConnection.getConnection().commit();
		dbConnection.close();
		//
		final PrintJobsDao printJobsDao = new PrintJobsDao();
		final int countOfResults =
			printJobsDao.getNumberOfPrintJobsForPrinter("Printer01");
		Assert.assertEquals("Invalid count of print jobs",
			NUMBEROFPRINTJOBSFORPRINTER01, countOfResults);
	}
	
	
	/**
	 * Gets the number of Print Jobs test.
	 * @throws Exception on error.
	 */
	@Test
	public final void testGetNumberOfPrintJobs() throws Exception { // NOPMD
		final DataSource dataSource =
			DataSourceUtils.buildDataSource(JDBC_PROPERTIES);
		//
		final IDatabaseConnection dbConnection =
			new DatabaseDataSourceConnection(dataSource);
		final FlatXmlDataSetBuilder flatXmlDataSetBuilder =
			new FlatXmlDataSetBuilder();
		final IDataSet dataSet =
			flatXmlDataSetBuilder.build(new File(DB_DATA_FILE));
		DatabaseOperation.CLEAN_INSERT.execute(dbConnection, dataSet);
		dbConnection.getConnection().commit();
		dbConnection.close();
		//
		final PrintJobsDao printJobsDao = new PrintJobsDao();
		final int countOfResults = printJobsDao.getNumberOfPrintJobs();
		Assert.assertEquals("Invalid count of print jobs",
			dataSet.getTable("PrintJob").getRowCount() , countOfResults);
	}
	
	
	/**
	 * Gets the number of Print Jobs For Status Test.
	 * @throws Exception on error.
	 */
	@Test
	public final void testGetNumberOfPrintJobsForStatus()
			throws Exception { // NOPMD
		final DataSource dataSource =
			DataSourceUtils.buildDataSource(JDBC_PROPERTIES);
		//
		final IDatabaseConnection dbConnection =
			new DatabaseDataSourceConnection(dataSource);
		final FlatXmlDataSetBuilder flatXmlDataSetBuilder =
			new FlatXmlDataSetBuilder();
		final IDataSet dataSet =
			flatXmlDataSetBuilder.build(new File(DB_DATA_FILE));
		DatabaseOperation.CLEAN_INSERT.execute(dbConnection, dataSet);
		dbConnection.getConnection().commit();
		dbConnection.close();
		//
		final PrintJobsDao printJobsDao = new PrintJobsDao();
		final int countOfResults =
			printJobsDao.getNumberOfPrintJobsForStatus("New");
		Assert.assertEquals("Invalid count of print jobs",
			NUMBEROFPRINTJOBSFORSTATUSNEW, countOfResults);
	}
	
	
}
