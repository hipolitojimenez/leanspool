package com.nioos.leanspool.gxt.client.tree;



import java.util.List;

import com.nioos.leanspool.gxt.shared.PrinterModel;
import com.sencha.gxt.data.shared.loader.JsonReader;



/**
 * Printers json reader.
 * 
 * @author Hipolito Jimenez.
 *
 */
public class PrintersJsonReader extends
		JsonReader<List<PrinterModel>, PrintersJsonRoot> {
	
	
	/**
	 * Constructor.
	 */
	public PrintersJsonReader() {
		super(PrintersAutoBeanFactory.INSTANCE, PrintersJsonRoot.class);
	}
	
	
	@Override
	protected final List<PrinterModel> createReturnData(final Object loadConfig,
			final PrintersJsonRoot records) {
		return records.getPrinters();
	}
	
	
}
