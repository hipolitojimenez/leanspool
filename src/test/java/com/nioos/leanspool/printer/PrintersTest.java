package com.nioos.leanspool.printer;



import static org.junit.Assert.*;

import java.io.File;
import java.util.List;

import javax.sql.DataSource;

import org.dbunit.database.DatabaseDataSourceConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.Test;

import com.nioos.leanspool.gxt.shared.PrinterModel;



public class PrintersTest {
	
	
	@Test
	public void testGetPrinters() throws Exception {
		DataSource dataSource =
			DataSourceUtils.buildDataSource("/jdbc.properties");
		//
		IDatabaseConnection dbConnection =
			new DatabaseDataSourceConnection(dataSource);
		FlatXmlDataSetBuilder flatXmlDataSetBuilder =
			new FlatXmlDataSetBuilder();
		IDataSet dataSet =
			flatXmlDataSetBuilder.build(new File("./src/test/resources/dbunit/PrintersTest.xml"));
		DatabaseOperation.CLEAN_INSERT.execute(dbConnection, dataSet);
		dbConnection.getConnection().commit();
		dbConnection.close();
		//
		Printers printers = new Printers();
		List<PrinterModel> printerModelList = printers.getPrinters();
		assertEquals("invalid size", 3, printerModelList.size());
		PrinterModel printerModel = printerModelList.get(0);
		assertEquals("invalid key", "Printer01", printerModel.getKey());
	}
	
	
}
