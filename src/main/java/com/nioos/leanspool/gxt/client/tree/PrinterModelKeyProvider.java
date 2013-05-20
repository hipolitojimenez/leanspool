package com.nioos.leanspool.gxt.client.tree;



import com.sencha.gxt.data.shared.ModelKeyProvider;



/**
 * Printer model key provider.
 * 
 * @author Hipolito Jimenez.
 *
 */
public class PrinterModelKeyProvider
		implements ModelKeyProvider<PrinterModel> {
	
	
	@Override
	public final String getKey(final PrinterModel item) {
		return item.getKey();
	}
	
	
}
