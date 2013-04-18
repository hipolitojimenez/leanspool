package com.nioos.leanspool.gxt.client.tree;



import com.sencha.gxt.core.client.ValueProvider;



public class LeanSpoolerTreeValueProvider implements
		ValueProvider<String, String> {
	
	
	@Override
	public String getValue(String object) {
		return object;
	}
	
	
	@Override
	public void setValue(String object, String value) {
		object = value;
	}
	
	
	@Override
	public String getPath() {
		return null;
	}
	
	
}
