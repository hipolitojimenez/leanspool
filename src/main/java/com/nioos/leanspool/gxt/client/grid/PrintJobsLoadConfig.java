package com.nioos.leanspool.gxt.client.grid;



import com.sencha.gxt.data.shared.loader.PagingLoadConfig;



/**
 * Print jobs load config.
 * @author Hipolito Jimenez.
 */
public interface PrintJobsLoadConfig extends PagingLoadConfig {
	
	/**
	 * Sets the printer.
	 * @param thePrinter the printer.
	 */
	void setPrinter(String thePrinter);
	
	/**
	 * Gets the printer.
	 * @return the printer.
	 */
	String getPrinter();
	
	/**
	 * Sets the status.
	 * @param theStatus  the status.
	 */
	void setStatus(String theStatus);
	
	/**
	 * Gets the status.
	 * @return the status.
	 */
	String getStatus();
	
}
