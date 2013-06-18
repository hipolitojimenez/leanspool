package com.nioos.leanspool.gxt.client.grid;



import com.nioos.leanspool.gxt.shared.PrintJobModel;
import com.sencha.gxt.core.client.ValueProvider;



/**
 * Job Id grid value provider.
 * 
 * @author Administrador
 *
 */
public class JobIdValueProvider implements
		ValueProvider<PrintJobModel, String> {
	
	
	@Override
	public final String getValue(final PrintJobModel object) {
		return object.getJobId();
	}
	
	
	@Override
	public final void setValue(final PrintJobModel object, final String value) {
		object.setJobId(value);
	}
	
	
	@Override
	public final String getPath() {
		return "Job ID";
	}
	
	
}
