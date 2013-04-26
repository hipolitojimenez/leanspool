package com.nioos.leanspool.gxt.client.grid;



import com.sencha.gxt.data.shared.ModelKeyProvider;



public class PrintJobsModelKeyProvider implements
		ModelKeyProvider<PrintJobModel> {
	
	
	@Override
	public String getKey(PrintJobModel item) {
		return item.getJobId();
	}
	
	
}
