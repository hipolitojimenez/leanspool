package com.nioos.leanspool.gxt.client.grid;



import java.util.ArrayList;
import java.util.List;

import com.sencha.gxt.data.shared.loader.ListLoadConfig;
import com.sencha.gxt.data.shared.loader.ListLoadConfigBean;
import com.sencha.gxt.data.shared.loader.ListLoadResult;
import com.sencha.gxt.data.shared.loader.ListLoadResultBean;
import com.sencha.gxt.data.shared.loader.ListLoader;
import com.sencha.gxt.data.shared.loader.LoadHandler;
import com.sencha.gxt.data.shared.loader.LoadResultListStoreBinding;
import com.sencha.gxt.data.shared.loader.MemoryProxy;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.Grid;



public class PrintJobsGrid extends Grid<PrintJobModel> {
	
	
	public PrintJobsGrid(List<ColumnConfig<PrintJobModel, ?>> columnConfigList) {
		super(new PrintJobsGridStore(),
			new PrintJobsColumnModel(columnConfigList));
		//TODO load from json url
		List<PrintJobModel> dataList = new ArrayList<PrintJobModel>();
		PrintJobModel pjm01 = new PrintJobModel();
		pjm01.setJobId("pjm01");
		dataList.add(pjm01);
		PrintJobModel pjm02 = new PrintJobModel();
		pjm02.setJobId("pjm02");
		dataList.add(pjm02);
		ListLoadResult<PrintJobModel> memoryData = new ListLoadResultBean<PrintJobModel>(dataList);
		MemoryProxy<ListLoadConfig, ListLoadResult<PrintJobModel>> proxy =
			new MemoryProxy<ListLoadConfig, ListLoadResult<PrintJobModel>>(memoryData);
		ListLoader<ListLoadConfig, ListLoadResult<PrintJobModel>> listLoader =
			new ListLoader<ListLoadConfig, ListLoadResult<PrintJobModel>>(proxy);
		//
		ListLoadConfig loadConfig = new ListLoadConfigBean();
		listLoader.useLoadConfig(loadConfig);
		LoadHandler<ListLoadConfig, ListLoadResult<PrintJobModel>> loadHandler =
			new LoadResultListStoreBinding<ListLoadConfig, PrintJobModel, ListLoadResult<PrintJobModel>>(getStore());
		listLoader.addLoadHandler(loadHandler);
		//
		setLoader(listLoader);
	}
	
	
}
