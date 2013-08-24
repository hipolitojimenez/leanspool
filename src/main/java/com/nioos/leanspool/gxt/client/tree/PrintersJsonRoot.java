package com.nioos.leanspool.gxt.client.tree;



import java.util.List;

import com.nioos.leanspool.gwt.shared.PrinterModel;
import com.nioos.leanspool.gxt.client.ErrorJsonRoot;



/**
 * Printers json root interface.
 * 
 * @author Hipolito Jimenez.
 *
 */
public interface PrintersJsonRoot extends ErrorJsonRoot {
	
	/**
	 * Gets the list of printers.
	 * @return the list of printers.
	 */
	List<PrinterModel> getPrinters();
	
}
