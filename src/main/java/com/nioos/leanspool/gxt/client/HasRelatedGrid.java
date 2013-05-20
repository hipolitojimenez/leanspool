package com.nioos.leanspool.gxt.client;



import com.nioos.leanspool.gxt.client.grid.PrintJobsGrid;



/**
 * Interface for getting the associated grid of a given class (tree).
 * 
 * @author Hipolito Jimenez.
 * 
 */
public interface HasRelatedGrid {
	
	/**
	 * Gets the associated grid.
	 * @return the associated grid.
	 */
	PrintJobsGrid getRelatedGrid();
	
}