package com.nioos.leanspool.gxt.client.grid;



import java.util.List;

import com.sencha.gxt.data.shared.loader.JsonReader;
import com.sencha.gxt.data.shared.loader.ListLoadResult;
import com.sencha.gxt.data.shared.loader.ListLoadResultBean;



public class PrintJobsJsonReader extends
		JsonReader<ListLoadResult<PrintJobModel>, PrintJobsJsonRoot> {
	
	
	public PrintJobsJsonReader() {
		super(PrintJobsAutoBeanFactory.INSTANCE, PrintJobsJsonRoot.class);
	}
	
	
	@Override
	protected ListLoadResult<PrintJobModel> createReturnData(Object loadConfig,
			PrintJobsJsonRoot records) {
		List<PrintJobModel> jobList = records.getJobs();
		return new ListLoadResultBean<PrintJobModel>(jobList);
	}
	
	
}
