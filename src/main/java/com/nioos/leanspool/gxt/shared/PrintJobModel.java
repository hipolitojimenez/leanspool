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
	
	/**
	 * Gets the job status.
	 * @return the job status.
	 */
	String getJobStatus();
	
	/**
	 * Sets the job status.
	 * @param value the job status.
	 */
	void setJobStatus(String value);
	
}
