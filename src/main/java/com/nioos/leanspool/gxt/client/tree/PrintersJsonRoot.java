package com.nioos.leanspool.gxt.client.tree;



import java.util.List;

import com.nioos.leanspool.gxt.shared.Errors;
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
	
	/**
	 * Get the error code.
	 * @return  the error code.
	 */
	Errors getErrorCode();
	
}
