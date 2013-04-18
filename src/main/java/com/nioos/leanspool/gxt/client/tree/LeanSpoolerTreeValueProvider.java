package com.nioos.leanspool.gxt.client.tree;



import com.sencha.gxt.core.client.ValueProvider;



public class LeanSpoolerTreeValueProvider implements
		ValueProvider<PrinterModel, String> {
	
	
	@Override
	public String getValue(PrinterModel object) {
		return object.getKey();
	}
	
	
	@Override
	public void setValue(PrinterModel object, String value) {
		object.setKey(value);
	}
	
	
	@Override
	public String getPath() {
		return null;
	}
	
	
}
