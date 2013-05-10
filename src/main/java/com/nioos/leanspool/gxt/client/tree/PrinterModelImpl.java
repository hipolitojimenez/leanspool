package com.nioos.leanspool.gxt.client.tree;



public class PrinterModelImpl implements PrinterModel {
	
	
	private String key;
	
	
	//private String printerName;
	
	
	public PrinterModelImpl(String thepPrinterName) {
		//printerName = thepPrinterName;
		key = thepPrinterName;
	}
	
	
	@Override
	public String getKey() {
		return key;
	}
	
	
	@Override
	public void setKey(String value) {
		key = value;
	}
	
	
}
