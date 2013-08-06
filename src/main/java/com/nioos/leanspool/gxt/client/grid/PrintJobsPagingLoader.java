package com.nioos.leanspool.gxt.client.grid;



import com.nioos.leanspool.gxt.client.MsgBoxLoaderHandler;
import com.nioos.leanspool.gxt.shared.PrintJobModel;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.data.shared.loader.LoadHandler;
import com.sencha.gxt.data.shared.loader.LoadResultListStoreBinding;
import com.sencha.gxt.data.shared.loader.PagingLoadConfig;
import com.sencha.gxt.data.shared.loader.PagingLoadResult;
import com.sencha.gxt.data.shared.loader.PagingLoader;



/**
 * Print jobs paging loader.
 * 
 * @author Hipolito Jimenez.
 *
 */
public class PrintJobsPagingLoader extends
		PagingLoader<PagingLoadConfig, PagingLoadResult<PrintJobModel>> {
	
	
	/**
	 * Constructor.
	 * @param printJobsHttpProxy the print jobs http proxy.
	 * @param listStore the print jobs list store.
	 */
	public PrintJobsPagingLoader(final PrintJobsHttpProxy printJobsHttpProxy,
			final ListStore<PrintJobModel> listStore) {
		super(printJobsHttpProxy, new PrintJobsJsonReader());
		//
		final LoadHandler<PagingLoadConfig, PagingLoadResult<PrintJobModel>> handler = new LoadResultListStoreBinding<PagingLoadConfig, PrintJobModel, PagingLoadResult<PrintJobModel>>(listStore);
		addLoadHandler(handler);
		final MsgBoxLoaderHandler<PagingLoadConfig, PagingLoadResult<PrintJobModel>> msgBoxHandler = new MsgBoxLoaderHandler<PagingLoadConfig, PagingLoadResult<PrintJobModel>>("Loading print jobs");
		addLoaderHandler(msgBoxHandler);
		setRemoteSort(true);
	}
	
	
}
