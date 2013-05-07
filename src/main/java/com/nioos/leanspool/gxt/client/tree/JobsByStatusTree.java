package com.nioos.leanspool.gxt.client.tree;



public class JobsByStatusTree extends AbstractBaseTree<String, String> {
	
	
	public JobsByStatusTree() {
		super(new JobsByStatusTreeStore(), new StringTreeValueProvider());
		getStyle().setLeafIcon(TreeImages.INSTANCE.status());
	}
	
	
}
