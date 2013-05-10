package com.nioos.leanspool.gxt.client.tree;



import java.util.List;

import com.sencha.gxt.data.shared.loader.JsonReader;



public class PrintersJsonReader extends
		JsonReader<List<PrinterModel>, PrintersJsonRoot> {
	
	
	public PrintersJsonReader() {
		super(PrintersAutoBeanFactory.INSTANCE, PrintersJsonRoot.class);
	}
	
	
	@Override
	protected List<PrinterModel> createReturnData(Object loadConfig,
			PrintersJsonRoot records) {
		return records.getPrinters();
	}
	
	
}
