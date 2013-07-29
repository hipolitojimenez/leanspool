package com.nioos.leanspool.gxt.client.grid;



import com.nioos.leanspool.gxt.shared.PrintJobModel;
import com.sencha.gxt.core.client.ValueProvider;



/**
 * Printer name grid value provider.
 * 
 * @author Hipolito Jimenez.
 *
 */
public class PrinterNameValueProvider implements
		ValueProvider<PrintJobModel, String> {
	
	
	@Override
	public final String getValue(final PrintJobModel object) {
		return object.getPrinterName();
	}
	
	
	@Override
	public final void setValue(final PrintJobModel object, final String value) {
		object.setPrinterName(value);
	}
	
	
	@Override
	public final String getPath() {
		return "PrinterName";
	}
	
	
}
