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

import com.nioos.leanspool.gxt.shared.PrintJobModel;
import com.nioos.leanspool.printer.DataSourceUtils;



/**
 * /**
 * Tests the print job DAO.
 * @author Hipolito Jiménez.
 *
 */
public class PrintJobsDaoTest {
	
	
	/**
	 * Get Print Jobs For Printer Test.
	 * @throws Exception on error.
	 */
	@Test
	public final void testGetPrintJobsForPrinter() throws Exception { // NOPMD
		final DataSource dataSource =
			DataSourceUtils.buildDataSource("/jdbc.properties");
		//
		final IDatabaseConnection dbConnection =
			new DatabaseDataSourceConnection(dataSource);
		final FlatXmlDataSetBuilder flatXmlDataSetBuilder =
			new FlatXmlDataSetBuilder();
		final IDataSet dataSet =
			flatXmlDataSetBuilder.build(
				new File("./src/test/resources/dbunit/PrintJobsTest.xml"));
		DatabaseOperation.CLEAN_INSERT.execute(dbConnection, dataSet);
		dbConnection.getConnection().commit();
		dbConnection.close();
		//
		final PrintJobsDao printJobsDao = new PrintJobsDao();
		final List<PrintJobModel> printJobList =
			printJobsDao.getPrintJobsForPrinter("Printer01");
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
			DataSourceUtils.buildDataSource("/jdbc.properties");
		//
		final IDatabaseConnection dbConnection =
			new DatabaseDataSourceConnection(dataSource);
		final FlatXmlDataSetBuilder flatXmlDataSetBuilder =
			new FlatXmlDataSetBuilder();
		final IDataSet dataSet =
			flatXmlDataSetBuilder.build(
				new File("./src/test/resources/dbunit/PrintJobsTest.xml"));
		DatabaseOperation.CLEAN_INSERT.execute(dbConnection, dataSet);
		dbConnection.getConnection().commit();
		dbConnection.close();
		//
		final PrintJobsDao printJobsDao = new PrintJobsDao();
		final List<PrintJobModel> printJobList = printJobsDao.getPrintJobs();
		final PrintJobModel printJob = printJobList.get(0);
		final String printerName = printJob.getPrinterName();
		Assert.assertEquals("Invalid print name", "Printer01", printerName);
		final String jobId = printJob.getJobId();
		Assert.assertEquals("Invalid print job ID", "jobId01", jobId);
	}
	
	
}