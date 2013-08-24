package com.nioos.leanspool.gxt.client.grid;



import com.nioos.leanspool.gwt.shared.PrintJobModel;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;



/**
 * Job Id column configuration.
 * 
 * @author Hipolito Jimenez.
 *
 */
public class JobIdColumnConfig extends ColumnConfig<PrintJobModel, String> {
	
	
	/**
	 * Job Id column width.
	 */
	private static final int JOB_ID_WIDTH = 100;
	
	
	/**
	 * Job Id column header.
	 */
	private static final String JOB_ID_HEADER = "Job ID";
	
	
	/**
	 * Constructor.
	 */
	public JobIdColumnConfig() {
		super(new JobIdValueProvider(), JOB_ID_WIDTH, JOB_ID_HEADER);
	}
	
	
}
