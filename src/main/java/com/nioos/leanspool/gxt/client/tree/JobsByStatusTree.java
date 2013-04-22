package com.nioos.leanspool.gxt.client.tree;



import com.sencha.gxt.widget.core.client.tree.Tree;



public class JobsByStatusTree extends Tree<String, String> {
	
	
	public JobsByStatusTree() {
		super(new JobsByStatusTreeStore(), new StringTreeValueProvider());
		getStyle().setLeafIcon(TreeImages.INSTANCE.status());
		// TODO Auto-generated constructor stub
	}
	
	
}
