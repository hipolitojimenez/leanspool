package com.nioos.leanspool.gxt.client.grid;



import com.nioos.leanspool.gwt.shared.PrintJobModel;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;



/**
 * Job Size column configuration.
 * 
 * @author Hipolito Jimenez.
 *
 */
public class JobSizeColumnConfig extends ColumnConfig<PrintJobModel, Integer> {
	
	
	/**
	 * Job Size column width.
	 */
	private static final int JOB_SIZE_WIDTH = 100;
	
	
	/**
	 * Job Size column header.
	 */
	private static final String JOB_SIZE_HEADER = "Size";
	
	
	/**
	 * Constructor.
	 */
	public JobSizeColumnConfig() {
		super(new JobSizeValueProvider(), JOB_SIZE_WIDTH,
			JOB_SIZE_HEADER);
	}
	
	
}
