package com.nioos.leanspool.gxt.client.grid;



import com.google.gwt.http.client.RequestBuilder;
import com.sencha.gxt.data.client.loader.HttpProxy;
import com.sencha.gxt.data.client.writer.UrlEncodingWriter;



/**
 * Print jobs HTTP proxy.
 * 
 * @author Hipolito Jimenez.
 *
 */
public class PrintJobsHttpProxy extends HttpProxy<PrintJobsLoadConfig> {
	
	
	/**
	 * Print jobs json HTTP URL.
	 */
	private static final String PRINTJOBS_URL = "getPrintJobs.json";
	
	
	/**
	 * Constructor.
	 */
	public PrintJobsHttpProxy() {
		super(new RequestBuilder(RequestBuilder.GET, PRINTJOBS_URL));
		//
		final UrlEncodingWriter<PrintJobsLoadConfig> urlEncodingWriter =
			new UrlEncodingWriter<PrintJobsLoadConfig>(
				PrintJobsAutoBeanFactory.INSTANCE, PrintJobsLoadConfig.class);
		setWriter(urlEncodingWriter);
	}
	
	
}
