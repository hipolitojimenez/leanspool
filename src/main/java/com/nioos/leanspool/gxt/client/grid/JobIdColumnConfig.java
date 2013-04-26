package com.nioos.leanspool.gxt.client.grid;



import com.sencha.gxt.widget.core.client.grid.ColumnConfig;



public class JobIdColumnConfig extends ColumnConfig<PrintJobModel, String> {
	
	
	private static final int JOB_ID_WITH = 100;
	
	
	private static final String JOB_ID_HEADER = "Job ID";
	
	
	public JobIdColumnConfig() {
		super(new JobIdValueProvider(), JOB_ID_WITH, JOB_ID_HEADER);
	}
	
	
}
