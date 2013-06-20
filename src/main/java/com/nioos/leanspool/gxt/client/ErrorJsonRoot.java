package com.nioos.leanspool.gxt.client;

import com.nioos.leanspool.gxt.shared.Errors;


/**
 * Error json root interface.
 * 
 * @author Hipolito Jimenez.
 *
 */
public interface ErrorJsonRoot {
	
	/**
	 * Get the error code.
	 * @return  the error code.
	 */
	Errors getErrorCode();
	
}
