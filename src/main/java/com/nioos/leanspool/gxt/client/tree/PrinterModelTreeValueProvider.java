package com.nioos.leanspool.gxt.client.tree;



import com.nioos.leanspool.gwt.shared.PrinterModel;
import com.sencha.gxt.core.client.ValueProvider;



/**
 * Printer model tree value provider.
 * 
 * @author Hipolito Jimenez.
 *
 */
public class PrinterModelTreeValueProvider implements
		ValueProvider<PrinterModel, String> {
	
	
	@Override
	public final String getValue(final PrinterModel object) {
		return object.getKey();
	}
	
	
	@Override
	public final void setValue(final PrinterModel object, final String value) {
		object.setKey(value);
	}
	
	
	@Override
	public final String getPath() {
		return null;
	}
	
	
}
