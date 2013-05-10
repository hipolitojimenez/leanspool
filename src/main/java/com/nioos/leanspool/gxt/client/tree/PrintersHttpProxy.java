package com.nioos.leanspool.gxt.client.tree;



import com.google.gwt.http.client.RequestBuilder;
import com.sencha.gxt.data.client.loader.HttpProxy;
import com.sencha.gxt.data.client.writer.UrlEncodingWriter;



public class PrintersHttpProxy extends HttpProxy<PrinterModel> {
	
	
	private static final String PRINTERS_URL = "getPrinters.json";
	
	
	public PrintersHttpProxy() {
		super(new RequestBuilder(RequestBuilder.GET, PRINTERS_URL));
		//
		UrlEncodingWriter<PrinterModel> urlEncodingWriter = new UrlEncodingWriter<PrinterModel>(PrintersAutoBeanFactory.INSTANCE, PrinterModel.class);
		setWriter(urlEncodingWriter);
	}
	
	
}
