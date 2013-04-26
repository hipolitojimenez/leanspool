package com.nioos.leanspool.gxt.client.grid;



import com.sencha.gxt.core.client.ValueProvider;



public class JobIdValueProvider implements
		ValueProvider<PrintJobModel, String> {
	
	
	@Override
	public String getValue(PrintJobModel object) {
		return object.getJobId();
	}
	
	
	@Override
	public void setValue(PrintJobModel object, String value) {
		object.setJobId(value);
	}
	
	
	@Override
	public String getPath() {
		return null;
	}
	
	
}
