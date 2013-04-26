package com.nioos.leanspool.gxt.client.grid;



import com.sencha.gxt.data.shared.ListStore;



public class PrintJobsGridStore extends ListStore<PrintJobModel> {
	
	
	public PrintJobsGridStore() {
		super(new PrintJobsModelKeyProvider());
	}
	
	
}
