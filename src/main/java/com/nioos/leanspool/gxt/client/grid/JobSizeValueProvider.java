package com.nioos.leanspool.gxt.client.grid;



import com.nioos.leanspool.gwt.shared.PrintJobModel;
import com.sencha.gxt.core.client.ValueProvider;



/**
 * Job Size grid value provider.
 * 
 * @author Hipolito Jimenez.
 *
 */
public class JobSizeValueProvider implements
		ValueProvider<PrintJobModel, Integer> {
	
	
	@Override
	public final Integer getValue(final PrintJobModel object) {
		return object.getJobSize();
	}
	
	
	@Override
	public final void setValue(final PrintJobModel object, 
			final Integer value) {
		object.setJobSize(value);
	}
	
	
	@Override
	public final String getPath() {
		return "JobSize";
	}
	
	
}
