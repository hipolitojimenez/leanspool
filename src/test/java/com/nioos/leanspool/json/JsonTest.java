package com.nioos.leanspool.json;



import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.junit.Test;

import com.nioos.leanspool.gxt.shared.PrinterModel;
import com.nioos.leanspool.printer.PrinterModelImpl;



public class JsonTest {
	
	
	@Test
	public void printerModelToJsonObjectTest() {
		String expected = "{\"key\":\"Key 01\"}";
		//
		PrinterModel printer01 = new PrinterModelImpl("Key 01");
		JSONObject jsonObject = JSONObject.fromObject(printer01);
		String actual = jsonObject.toString();
		//
		assertEquals("Json PrinterModel failed", expected, actual);
	}
	
	
	@Test
	public void printerModelListToJsonArrayTest() {
		String expected = "[{\"key\":\"Key 01\"},{\"key\":\"Key 02\"}]";
		//
		List<PrinterModel> printerModelList = new ArrayList<PrinterModel>();
		PrinterModel printer01 = new PrinterModelImpl("Key 01");
		printerModelList.add(printer01);
		PrinterModel printer02 = new PrinterModelImpl("Key 02");
		printerModelList.add(printer02);
		JSONArray jsonArray = JSONArray.fromObject(printerModelList);
		String actual = jsonArray.toString();
		//
		assertEquals("Json PrinterModel list failed", expected, actual);
	}
	
	
	@Test
	public void printerModelMapToJsonArrayTest() {
		String expected =
			"{\"printers\":[{\"key\":\"Key 01\"},{\"key\":\"Key 02\"}]}";
		//
		List<PrinterModel> printerModelList = new ArrayList<PrinterModel>();
		PrinterModel printer01 = new PrinterModelImpl("Key 01");
		printerModelList.add(printer01);
		PrinterModel printer02 = new PrinterModelImpl("Key 02");
		printerModelList.add(printer02);
		Map<String, List<PrinterModel>> printerModelMap =
				Collections.singletonMap("printers", printerModelList);
		JSONObject jsonObject = JSONObject.fromObject(printerModelMap);
		String actual = jsonObject.toString();
		//
		assertEquals("Json PrinterModel list failed", expected, actual);
	}
	
	
}
