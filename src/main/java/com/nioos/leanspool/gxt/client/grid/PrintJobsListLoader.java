package com.nioos.leanspool.gxt.client.grid;



import com.nioos.leanspool.gxt.shared.PrintJobModel;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.data.shared.loader.ListLoadConfig;
import com.sencha.gxt.data.shared.loader.ListLoadResult;
import com.sencha.gxt.data.shared.loader.ListLoader;
import com.sencha.gxt.data.shared.loader.LoadHandler;
import com.sencha.gxt.data.shared.loader.LoadResultListStoreBinding;



/**
 * Print jobs list loader.
 * 
 * @author Hipolito Jimenez.
 *
 */
public class PrintJobsListLoader extends
		ListLoader<ListLoadConfig, ListLoadResult<PrintJobModel>> {
	
	
	/**
	 * Constructor.
	 * @param printJobsHttpProxy the print jobs http proxy.
	 * @param listStore the print jobs list store.
	 */
	public PrintJobsListLoader(final PrintJobsHttpProxy printJobsHttpProxy,
			final ListStore<PrintJobModel> listStore) {
		super(printJobsHttpProxy, new PrintJobsJsonReader());
		//
		final LoadHandler<ListLoadConfig, ListLoadResult<PrintJobModel>> handler = new LoadResultListStoreBinding<ListLoadConfig, PrintJobModel, ListLoadResult<PrintJobModel>>(listStore);
		addLoadHandler(handler);
		setRemoteSort(true);
	}
	
	
}
