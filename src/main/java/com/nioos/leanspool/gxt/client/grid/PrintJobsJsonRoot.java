package com.nioos.leanspool.gxt.client.grid;



import java.util.List;



/**
 * Print jobs json root interface.
 * 
 * @author Hipolito Jimenez.
 *
 */
public interface PrintJobsJsonRoot {
	
	/**
	 * Get the jobs list.
	 * @return the jobs list.
	 */
	List<PrintJobModel> getJobs();
	
}
