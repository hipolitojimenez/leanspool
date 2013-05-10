package com.nioos.leanspool.gxt.client.grid;



import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.data.shared.loader.ListLoadConfig;
import com.sencha.gxt.data.shared.loader.ListLoadResult;
import com.sencha.gxt.data.shared.loader.ListLoader;
import com.sencha.gxt.data.shared.loader.LoadHandler;
import com.sencha.gxt.data.shared.loader.LoadResultListStoreBinding;



public class PrintJobsListLoader extends
		ListLoader<ListLoadConfig, ListLoadResult<PrintJobModel>> {
	
	
	public PrintJobsListLoader(ListStore<PrintJobModel> listStore) {
		super(new PrintJobsHttpProxy(), new PrintJobsJsonReader());
		//
		LoadHandler<ListLoadConfig, ListLoadResult<PrintJobModel>> handler = new LoadResultListStoreBinding<ListLoadConfig, PrintJobModel, ListLoadResult<PrintJobModel>>(listStore);
		addLoadHandler(handler);
		setRemoteSort(true);
	}
	
	
}
