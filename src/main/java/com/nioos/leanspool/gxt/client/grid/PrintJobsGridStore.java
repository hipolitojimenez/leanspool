package com.nioos.leanspool.gxt.client.grid;



import com.nioos.leanspool.gxt.shared.PrintJobModel;
import com.sencha.gxt.data.shared.ListStore;



/**
 * Print jobs grid store.
 * 
 * @author Hipolito Jimenez.
 *
 */
public class PrintJobsGridStore extends ListStore<PrintJobModel> {
	
	
	/**
	 * Constructor.
	 */
	public PrintJobsGridStore() {
		super(new PrintJobsModelKeyProvider());
	}
	
	
}
