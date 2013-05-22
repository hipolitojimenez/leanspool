package com.nioos.leanspool.gxt.client.tree;



import com.google.gwt.http.client.RequestBuilder;
import com.sencha.gxt.data.client.loader.HttpProxy;
import com.sencha.gxt.data.client.writer.UrlEncodingWriter;



/**
 * Printers HTTP proxy.
 * 
 * @author Hipolito Jimenez.
 *
 */
public class PrintersHttpProxy extends HttpProxy<PrinterModel> {
	
	
	/**
	 * Printers HTTP URL.
	 */
	private static final String PRINTERS_URL = "getPrinters.json";
	
	
	/**
	 * Constructor.
	 */
	public PrintersHttpProxy() {
		super(new RequestBuilder(RequestBuilder.GET, PRINTERS_URL));
		//
		final UrlEncodingWriter<PrinterModel> urlEncodingWriter =
			new UrlEncodingWriter<PrinterModel>(
				PrintersAutoBeanFactory.INSTANCE, PrinterModel.class);
		setWriter(urlEncodingWriter);
	}
	
	
}
