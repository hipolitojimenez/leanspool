package com.nioos.leanspool.gxt.client.tree;

import com.nioos.leanspool.gxt.client.grid.PrintJobsGrid;



/**
 * Jobs by status tree.
 * 
 * @author Hipolito Jimenez.
 *
 */
public class JobsByStatusTree extends AbstractBaseTree<String, String> {
	
	
	/**
	 * Constructor.
	 */
	public JobsByStatusTree() {
		super(new JobsByStatusTreeStore(), new StringTreeValueProvider());
		getStyle().setLeafIcon(TreeImages.INSTANCE.status());
		//
		getRelatedGrid().hideStatusColumn();
	}
	
	
	@Override
	protected void changeSelectedNodeName(final String theSelectedNodeName) {
		final PrintJobsGrid printJobsGrid = getRelatedGrid();
		printJobsGrid.setStatus(theSelectedNodeName);
	}
	
	
}
