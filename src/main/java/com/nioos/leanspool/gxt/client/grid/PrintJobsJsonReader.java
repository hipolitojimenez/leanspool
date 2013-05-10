package com.nioos.leanspool.gxt.client.grid;



import com.sencha.gxt.data.shared.loader.JsonReader;
import com.sencha.gxt.data.shared.loader.ListLoadResult;



public class PrintJobsJsonReader extends
		JsonReader<ListLoadResult<PrintJobModel>, PrintJobsJsonRoot> {
	
	
	public PrintJobsJsonReader() {
		super(PrintJobsAutoBeanFactory.INSTANCE, PrintJobsJsonRoot.class);
	}
	
	
}
