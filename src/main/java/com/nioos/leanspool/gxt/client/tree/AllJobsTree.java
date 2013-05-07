package com.nioos.leanspool.gxt.client.tree;



public class AllJobsTree extends AbstractBaseTree<String, String> {
	
	
	public AllJobsTree() {
		super(new AllJobsTreeStore(), new StringTreeValueProvider());
		getStyle().setLeafIcon(TreeImages.INSTANCE.job());
	}
	
	
}
