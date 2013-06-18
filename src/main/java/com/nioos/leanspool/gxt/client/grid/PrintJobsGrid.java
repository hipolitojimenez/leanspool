package com.nioos.leanspool.gxt.client.grid;



import java.util.List;

import com.nioos.leanspool.gxt.shared.PrintJobModel;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.ColumnModel;
import com.sencha.gxt.widget.core.client.grid.Grid;



/**
 * Print jobs grid.
 * 
 * @author Hipolito Jimenez.
 *
 */
public class PrintJobsGrid extends Grid<PrintJobModel> {
	
	
	/**
	 * Constructor.
	 * @param columnConfigList the column config list.
	 */
	public PrintJobsGrid(
			final List<ColumnConfig<PrintJobModel, ?>> columnConfigList) {
		super(new PrintJobsGridStore(),
			new ColumnModel<PrintJobModel>(columnConfigList));
		setLoader(new PrintJobsListLoader(getStore()));
	}
	
	
}
