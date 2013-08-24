package com.nioos.leanspool.gxt.client.tree;



import com.nioos.leanspool.gwt.shared.PrinterModel;
import com.sencha.gxt.data.shared.TreeStore;



/**
 * Jobs by printer tree store.
 * 
 * @author Hipolito Jimenez.
 *
 */
public class JobsByPrinterTreeStore extends TreeStore<PrinterModel> {
	
	
	/**
	 * Constructor.
	 */
	public JobsByPrinterTreeStore() {
		super(new PrinterModelKeyProvider());
	}
	
	
}
