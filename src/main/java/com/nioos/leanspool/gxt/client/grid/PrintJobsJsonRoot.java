package com.nioos.leanspool.gxt.client.grid;



import java.util.List;

import com.nioos.leanspool.gxt.client.ErrorJsonRoot;
import com.nioos.leanspool.gxt.shared.PrintJobModel;



/**
 * Print jobs json root interface.
 * 
 * @author Hipolito Jimenez.
 *
 */
public interface PrintJobsJsonRoot extends ErrorJsonRoot {
	
	/**
	 * Get the jobs list.
	 * @return the jobs list.
	 */
	List<PrintJobModel> getJobs();
	
	/**
	 * Gets the total number of print jobs available.
	 * @return the total number of print jobs available.
	 */
	int getTotalLen();
	
	/**
	 * Gets the current offset.
	 * @return the current offset.
	 */
	int getOffset();
	
}
