package com.nioos.leanspool.gxt.client.grid;



import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.http.client.RequestBuilder;
import com.google.web.bindery.autobean.shared.AutoBean;
import com.google.web.bindery.autobean.shared.AutoBeanFactory;
import com.sencha.gxt.data.client.loader.HttpProxy;
import com.sencha.gxt.data.client.writer.UrlEncodingWriter;
import com.sencha.gxt.data.shared.loader.JsonReader;
import com.sencha.gxt.data.shared.loader.ListLoadConfig;
import com.sencha.gxt.data.shared.loader.ListLoadResult;
import com.sencha.gxt.data.shared.loader.ListLoadResultBean;
import com.sencha.gxt.data.shared.loader.ListLoader;
import com.sencha.gxt.data.shared.loader.LoadHandler;
import com.sencha.gxt.data.shared.loader.LoadResultListStoreBinding;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.Grid;



public class PrintJobsGrid extends Grid<PrintJobModel> {
	
	
	interface PrintJobListJsonRoot {
		List<PrintJobModel> getJobs();
	}
	
	
	interface PrintJobModelAutoBeanFactory extends AutoBeanFactory {
		AutoBean<PrintJobListJsonRoot> printJobListJsonRoot();
		AutoBean<ListLoadConfig> listLoadConfig();
	}
	
	
	public PrintJobsGrid(List<ColumnConfig<PrintJobModel, ?>> columnConfigList) {
		super(new PrintJobsGridStore(),
			new PrintJobsColumnModel(columnConfigList));
		PrintJobModelAutoBeanFactory factory = GWT.create(PrintJobModelAutoBeanFactory.class);
		JsonReader<ListLoadResult<PrintJobModel>, PrintJobListJsonRoot> reader = new JsonReader<ListLoadResult<PrintJobModel>, PrintJobListJsonRoot>(factory, PrintJobListJsonRoot.class) {
			@Override
			protected ListLoadResult<PrintJobModel> createReturnData(
					Object loadConfig, PrintJobListJsonRoot records) {
				return new ListLoadResultBean<PrintJobModel>(records.getJobs());
			}
		};
		String url = "getPrintJobs.json";
		RequestBuilder requestBuilder = new RequestBuilder(RequestBuilder.GET, url);
		HttpProxy<ListLoadConfig> proxy = new HttpProxy<ListLoadConfig>(requestBuilder);
		UrlEncodingWriter<ListLoadConfig> writer = new UrlEncodingWriter<ListLoadConfig>(factory, ListLoadConfig.class);
		proxy.setWriter(writer);
		ListLoader<ListLoadConfig, ListLoadResult<PrintJobModel>> listLoader =
			new ListLoader<ListLoadConfig, ListLoadResult<PrintJobModel>>(proxy, reader);
		LoadHandler<ListLoadConfig, ListLoadResult<PrintJobModel>> handler =
			new LoadResultListStoreBinding<ListLoadConfig, PrintJobModel, ListLoadResult<PrintJobModel>>(getStore());
		listLoader.addLoadHandler(handler);
		listLoader.setRemoteSort(true);
		setLoader(listLoader);
	}
	
	
}
