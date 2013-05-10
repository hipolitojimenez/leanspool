package com.nioos.leanspool.gxt.client.grid;



import com.google.gwt.http.client.RequestBuilder;
import com.sencha.gxt.data.client.loader.HttpProxy;
import com.sencha.gxt.data.client.writer.UrlEncodingWriter;
import com.sencha.gxt.data.shared.loader.ListLoadConfig;



public class PrintJobsHttpProxy extends HttpProxy<ListLoadConfig> {
	
	
	private static final String PRINTJOBS_URL = "getPrintJobs.json";
	
	
	public PrintJobsHttpProxy() {
		super(new RequestBuilder(RequestBuilder.GET, PRINTJOBS_URL));
		//
		UrlEncodingWriter<ListLoadConfig> urlEncodingWriter = new UrlEncodingWriter<ListLoadConfig>(PrintJobsAutoBeanFactory.INSTANCE, ListLoadConfig.class);
		setWriter(urlEncodingWriter);
	}
	
	
}
