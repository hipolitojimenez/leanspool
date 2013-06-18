package com.nioos.leanspool.json;



import org.junit.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.junit.Test;

import com.nioos.leanspool.gxt.shared.PrintJobModel;
import com.nioos.leanspool.gxt.shared.PrinterModel;
import com.nioos.leanspool.printer.PrinterModelImpl;
import com.nioos.leanspool.printjobs.PrintJobModelImpl;



/**
 * Json test.
 * @author Hipolito Jimenez.
 *
 */
public class JsonTest {
	
	
	/**
	 * Expected result of the print job model to Json object test.
	 */
	private static final String EXPECTED_PJMTJO =
		"{\"jobId\":\"JobId 01\",\"printerName\":\"\"}";
	
	
	/**
	 * Printer model to Json object test.
	 */
	@Test
	public final void printerModelToJsonObjectTest() {
		final String expected = "{\"key\":\"Key 01\"}"; // NOPMD
		//
		final PrinterModel printer01 = new PrinterModelImpl("Key 01");
		final JSONObject jsonObject = JSONObject.fromObject(printer01);
		final String actual = jsonObject.toString();
		//
		Assert.assertEquals("Json PrinterModel failed", expected, actual);
	}
	
	
	/**
	 * Printer model list to Json array test.
	 */
	@Test
	public final void printerModelListToJsonArrayTest() {
		final String expected = // NOPMD
			"[{\"key\":\"Key 01\"},{\"key\":\"Key 02\"}]";
		//
		final List<PrinterModel> printerModelList =
			new ArrayList<PrinterModel>();
		final PrinterModel printer01 = new PrinterModelImpl("Key 01");
		printerModelList.add(printer01);
		final PrinterModel printer02 = new PrinterModelImpl("Key 02");
		printerModelList.add(printer02);
		final JSONArray jsonArray = JSONArray.fromObject(printerModelList);
		final String actual = jsonArray.toString();
		//
		Assert.assertEquals("Json PrinterModel list failed", expected, actual);
	}
	
	
	/**
	 * Printer model map to Json rrray test.
	 */
	@Test
	public final void printerModelMapToJsonArrayTest() {
		final String expected = // NOPMD
			"{\"printers\":[{\"key\":\"Key 01\"},{\"key\":\"Key 02\"}]}";
		//
		final List<PrinterModel> printerModelList = new ArrayList<PrinterModel>();
		final PrinterModel printer01 = new PrinterModelImpl("Key 01");
		printerModelList.add(printer01);
		final PrinterModel printer02 = new PrinterModelImpl("Key 02");
		printerModelList.add(printer02);
		final Map<String, List<PrinterModel>> printerModelMap =
				Collections.singletonMap("printers", printerModelList);
		final JSONObject jsonObject = JSONObject.fromObject(printerModelMap);
		final String actual = jsonObject.toString();
		//
		Assert.assertEquals("Json PrinterModel list failed", expected, actual);
	}
	
	
	/**
	 * Print job model to Json object test.
	 */
	@Test
	public final void printJobModelToJsonObjectTest() {
		final PrintJobModel printJob01 = new PrintJobModelImpl();
		printJob01.setJobId("JobId 01");
		final JSONObject jsonObject = JSONObject.fromObject(printJob01);
		final String actual = jsonObject.toString();
		//
		Assert.assertEquals("Json PrintJobModel failed", EXPECTED_PJMTJO, actual);
	}
	
	
	/**
	 * Print job model list to Json array test.
	 */
	@Test
	public final void printJobModelListToJsonArrayTest() {
		final String expected = // NOPMD
			"[{\"jobId\":\"Job 01\",\"printerName\":\"\"},{\"jobId\":\"Job 02\",\"printerName\":\"\"}]";
		//
		final List<PrintJobModel> printJobModelList =
			new ArrayList<PrintJobModel>();
		final PrintJobModel printJob01 = new PrintJobModelImpl();
		printJob01.setJobId("Job 01");
		printJobModelList.add(printJob01);
		final PrintJobModel printJob02 = new PrintJobModelImpl();
		printJob02.setJobId("Job 02");
		printJobModelList.add(printJob02);
		final JSONArray jsonArray = JSONArray.fromObject(printJobModelList);
		final String actual = jsonArray.toString();
		//
		Assert.assertEquals("Json PrinterJobModel list failed", expected,
			actual);
	}
	
	
	/**
	 * Print job model map to Json rrray test.
	 */
	@Test
	public final void printJobModelMapToJsonArrayTest() {
		final String expected = // NOPMD
			"{\"jobs\":[{\"jobId\":\"Job 01\",\"printerName\":\"\"},{\"jobId\":\"Job 02\",\"printerName\":\"\"}]}";
		//
		final List<PrintJobModel> printJobModelList =
			new ArrayList<PrintJobModel>();
		final PrintJobModel printJob01 = new PrintJobModelImpl();
		printJob01.setJobId("Job 01");
		printJobModelList.add(printJob01);
		final PrintJobModel printJob02 = new PrintJobModelImpl();
		printJob02.setJobId("Job 02");
		printJobModelList.add(printJob02);
		final Map<String, List<PrintJobModel>> printJobModelMap =
			Collections.singletonMap("jobs", printJobModelList);
		final JSONObject jsonObject = JSONObject.fromObject(printJobModelMap);
		final String actual = jsonObject.toString();
		//
		Assert.assertEquals("Json PrintJobModel list failed", expected,
			actual);
	}
	
	
}
