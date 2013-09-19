package com.nioos.leanspool.gxt.client.grid;



import com.nioos.leanspool.gwt.shared.PrintJobModel;
import com.nioos.leanspool.gxt.client.MsgBoxLoaderHandler;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.data.shared.loader.LoadHandler;
import com.sencha.gxt.data.shared.loader.LoadResultListStoreBinding;
import com.sencha.gxt.data.shared.loader.PagingLoadResult;
import com.sencha.gxt.data.shared.loader.PagingLoader;



/**
 * Print jobs paging loader.
 * @author Hipolito Jimenez.
 */
public class PrintJobsPagingLoader extends
		PagingLoader<PrintJobsLoadConfig, PagingLoadResult<PrintJobModel>> {
	
	
	
	/**
	 * The printer.
	 */
	private String printer;
	
	
	/**
	 * The status.
	 */
	private String status;
	
	
	/**
	 * Constructor.
	 * @param printJobsHttpProxy the print jobs http proxy.
	 * @param listStore the print jobs list store.
	 */
	public PrintJobsPagingLoader(final PrintJobsHttpProxy printJobsHttpProxy,
			final ListStore<PrintJobModel> listStore) {
		super(printJobsHttpProxy, new PrintJobsJsonReader());
		//
		final LoadHandler<PrintJobsLoadConfig, PagingLoadResult<PrintJobModel>>
			handler = new LoadResultListStoreBinding<PrintJobsLoadConfig,
				PrintJobModel, PagingLoadResult<PrintJobModel>>(listStore);
		addLoadHandler(handler);
		final MsgBoxLoaderHandler<PrintJobsLoadConfig,
			PagingLoadResult<PrintJobModel>> msgBoxHandler =
				new MsgBoxLoaderHandler<PrintJobsLoadConfig,
					PagingLoadResult<PrintJobModel>>("Loading print jobs");
		addLoaderHandler(msgBoxHandler);
		setRemoteSort(true);
	}
	
	
	/**
	 * Gets the printer.
	 * @return the printer.
	 */
	public final String getPrinter() {
		return printer;
	}
	
	
	/**
	 * Sets the printer.
	 * @param thePrinter the printer.
	 */
	public final void setPrinter(final String thePrinter) {
		printer = thePrinter;
	}
	
	
	/**
	 * Sets the status.
	 * @param theStatus the status.
	 */
	public final void setStatus(final String theStatus) {
		status = theStatus;
	}
	
	
	/**
	 * gets the status.
	 * @return the status.
	 */
	public final String getStatus() {
		return status;
	}
	
	
	@Override
	protected final PrintJobsLoadConfig prepareLoadConfig(
			final PrintJobsLoadConfig config) {
		final PrintJobsLoadConfig loadConfig = super.prepareLoadConfig(config);
		loadConfig.setPrinter(printer);
		loadConfig.setStatus(status);
		return loadConfig;
	}


	@Override
	protected final PrintJobsLoadConfig newLoadConfig() {
		return new PrintJobsLoadConfigBean();
	}
	
	
}
