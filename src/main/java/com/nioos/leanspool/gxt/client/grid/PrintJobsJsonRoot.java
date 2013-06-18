package com.nioos.leanspool.gxt.client.grid;



import java.util.List;

import com.nioos.leanspool.gxt.shared.PrintJobModel;



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
