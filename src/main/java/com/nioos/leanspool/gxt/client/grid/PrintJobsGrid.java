package com.nioos.leanspool.gxt.client.grid;



import java.util.List;

import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.ColumnModel;
import com.sencha.gxt.widget.core.client.grid.Grid;



public class PrintJobsGrid extends Grid<PrintJobModel> {
	
	
	public PrintJobsGrid(List<ColumnConfig<PrintJobModel, ?>> columnConfigList) {
		super(new PrintJobsGridStore(),
			new ColumnModel<PrintJobModel>(columnConfigList));
		setLoader(new PrintJobsListLoader(getStore()));
	}
	
	
}
