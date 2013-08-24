package com.nioos.leanspool.gxt.client.grid;



import com.nioos.leanspool.gwt.shared.PrintJobModel;
import com.sencha.gxt.data.shared.ModelKeyProvider;



/**
 * Print jobs model key provider.
 * 
 * @author Hipolito Jimenez.
 *
 */
public class PrintJobsModelKeyProvider implements
		ModelKeyProvider<PrintJobModel> {
	
	
	@Override
	public final String getKey(final PrintJobModel item) {
		return item.getJobId();
	}
	
	
}
