package com.nioos.leanspool.gxt.client.tree;



import java.util.List;

import com.nioos.leanspool.gxt.shared.PrinterModel;



/**
 * Printers json root interface.
 * 
 * @author Hipolito Jimenez.
 *
 */
public interface PrintersJsonRoot {
	
	/**
	 * Gets the list of printers.
	 * @return the list of printers.
	 */
	List<PrinterModel> getPrinters();	
	
}
