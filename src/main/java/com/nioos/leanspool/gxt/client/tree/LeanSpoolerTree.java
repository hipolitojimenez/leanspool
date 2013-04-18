package com.nioos.leanspool.gxt.client.tree;



import com.sencha.gxt.widget.core.client.tree.Tree;



public class LeanSpoolerTree extends Tree<PrinterModel, String> {
	
	
	public LeanSpoolerTree() {
		super(new LeanSpoolerTreeStore(), new LeanSpoolerTreeValueProvider());
		// TODO Auto-generated constructor stub
	}
	
	
}
