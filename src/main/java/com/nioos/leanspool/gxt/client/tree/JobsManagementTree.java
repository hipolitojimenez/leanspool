package com.nioos.leanspool.gxt.client.tree;



import com.sencha.gxt.widget.core.client.tree.Tree;



public class JobsManagementTree extends Tree<PrinterModel, String> {
	
	
	public JobsManagementTree() {
		super(new JobsManagementTreeStore(), new LeanSpoolerTreeValueProvider());
		// TODO Auto-generated constructor stub
	}
	
	
}
