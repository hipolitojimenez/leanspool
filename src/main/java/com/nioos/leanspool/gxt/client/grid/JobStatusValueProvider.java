package com.nioos.leanspool.gxt.client.grid;



import com.nioos.leanspool.gxt.shared.PrintJobModel;
import com.sencha.gxt.core.client.ValueProvider;



/**
 * Job Status grid value provider.
 * 
 * @author Hipolito Jimenez.
 *
 */
public class JobStatusValueProvider implements
		ValueProvider<PrintJobModel, String> {
	
	
	@Override
	public final String getValue(final PrintJobModel object) {
		return object.getJobStatus();
	}
	
	
	@Override
	public final void setValue(final PrintJobModel object, final String value) {
		object.setJobStatus(value);
	}
	
	
	@Override
	public final String getPath() {
		return "JobStatus";
	}
	
	
}
