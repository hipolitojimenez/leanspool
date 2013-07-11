package com.nioos.leanspool.gxt.client.grid;



import com.nioos.leanspool.gxt.shared.PrintJobModel;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;



/**
 * Job Status column configuration.
 * 
 * @author Hipolito Jimenez.
 *
 */
public class JobStatusColumnConfig extends ColumnConfig<PrintJobModel, String> {
	
	
	/**
	 * Job Status column width.
	 */
	private static final int JOB_STATUS_WIDTH = 100;
	
	
	/**
	 * Job Status column header.
	 */
	private static final String JOB_STATUS_HEADER = "Status";
	
	
	/**
	 * Constructor.
	 */
	public JobStatusColumnConfig() {
		super(new JobStatusValueProvider(), JOB_STATUS_WIDTH,
			JOB_STATUS_HEADER);
	}
	
	
}
