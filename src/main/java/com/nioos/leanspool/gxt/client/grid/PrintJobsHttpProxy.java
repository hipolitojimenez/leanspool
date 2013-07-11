package com.nioos.leanspool.gxt.client.grid;



import com.google.gwt.http.client.RequestBuilder;
import com.sencha.gxt.data.client.loader.HttpProxy;
import com.sencha.gxt.data.client.writer.UrlEncodingWriter;
import com.sencha.gxt.data.shared.loader.ListLoadConfig;



/**
 * Print jobs HTTP proxy.
 * 
 * @author Hipolito Jimenez.
 *
 */
public class PrintJobsHttpProxy extends HttpProxy<ListLoadConfig> {
	
	
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
		final UrlEncodingWriter<ListLoadConfig> urlEncodingWriter =
			new UrlEncodingWriter<ListLoadConfig>(
				PrintJobsAutoBeanFactory.INSTANCE, ListLoadConfig.class);
		setWriter(urlEncodingWriter);
	}
	
	
	/**
	 * Sets the printer parameter.
	 * @param printer the printer parameter.
	 */
	public final void setPrinter(final String printer) {
		String newUrl = PRINTJOBS_URL; // NOPMD
		if (printer != null) {
			newUrl = PRINTJOBS_URL + "?printer=" + printer;
		}
		initUrl = newUrl;
		builder = new RequestBuilder(RequestBuilder.GET, newUrl);
	}
	
	
}
