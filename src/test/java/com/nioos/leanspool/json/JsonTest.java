package com.nioos.leanspool.json;



import org.junit.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.junit.Test;

import com.nioos.leanspool.gxt.shared.PrinterModel;
import com.nioos.leanspool.printer.PrinterModelImpl;



/**
 * Json test.
 * @author Hipolito Jimenez.
 *
 */
public class JsonTest {
	
	
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
	
	
}
