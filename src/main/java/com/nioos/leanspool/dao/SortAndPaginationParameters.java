package com.nioos.leanspool.dao;



/**
 * Sort and pagination parameters used to build the query.
 * @author Hipolito Jimenez.
 */
public class SortAndPaginationParameters {
	
	
	/**
	 * Sort parameters used to build the query.
	 */
	private final transient SortParameters sortParameters;
	
	
	/**
	 * Constrcutor.
	 * @param theSortParameters the sort parameters.
	 */
	public SortAndPaginationParameters(final SortParameters theSortParameters) {
		sortParameters = theSortParameters;
	}
	
	
	/**
	 * Gets the sort parameters.
	 * @return the sort parameters.
	 */
	public final SortParameters getSortParameters() {
		return sortParameters;
	}
	
	
}
