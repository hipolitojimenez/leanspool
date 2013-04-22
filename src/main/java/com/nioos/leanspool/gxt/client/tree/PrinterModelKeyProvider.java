package com.nioos.leanspool.gxt.client.tree;



import com.sencha.gxt.data.shared.ModelKeyProvider;



public class PrinterModelKeyProvider
		implements ModelKeyProvider<PrinterModel> {
	
	
	@Override
	public String getKey(PrinterModel item) {
		return item.getKey();
	}
	
	
}
