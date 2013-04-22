package com.nioos.leanspool.gxt.client.tree;



import com.sencha.gxt.widget.core.client.tree.Tree;



public class AllJobsTree extends Tree<String, String> {
	
	
	public AllJobsTree() {
		super(new AllJobsTreeStore(), new StringTreeValueProvider());
		getStyle().setLeafIcon(TreeImages.INSTANCE.job());
		// TODO Auto-generated constructor stub
	}
	
	
}
