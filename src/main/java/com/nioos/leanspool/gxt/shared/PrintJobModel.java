package com.nioos.leanspool.gxt.shared;



/**
 * Print job model interface.
 * 
 * @author Hipolito Jimenez.
 *
 */
public interface PrintJobModel {
	
	/**
	 * Gets the job id.
	 * @return the job id.
	 */
	String getJobId();
	
	/**
	 * Sets the job id.
	 * @param value the job id.
	 */
	void setJobId(String value);
	
	
	/**
	 * Gets the printer name.
	 * @return the printer name.
	 */
	String getPrinterName();
	
	
	/**
	 * Sets the printer name.
	 * @param value the printer name.
	 */
	void setPrinterName(String value);
	
	
}
