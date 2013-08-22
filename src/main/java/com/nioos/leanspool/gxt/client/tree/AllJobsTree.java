package com.nioos.leanspool.gxt.client.tree;



/**
 * All jobs tree.
 * 
 * @author Hipolito Jimenez.
 */
public class AllJobsTree extends AbstractBaseTree<String, String> {
	
	
	/**
	 * Constructor.
	 */
	public AllJobsTree() {
		super(new AllJobsTreeStore(), new StringTreeValueProvider());
		getStyle().setLeafIcon(TreeImages.INSTANCE.job());
		setId("allJobsTree");
	}
	
	
	@Override
	protected void changeSelectedNodeName(final String theSelectedNodeName) {
		//Do nothing
	}
	
	
}
