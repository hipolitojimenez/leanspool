package com.nioos.leanspool.gxt.client.tree;



import com.sencha.gxt.widget.core.client.tree.Tree;



public class JobsByPrinterTree extends Tree<PrinterModel, String> {
	
	
	public JobsByPrinterTree() {
		super(new JobsByPrinterTreeStore(), new LeanSpoolerTreeValueProvider());
		getStyle().setLeafIcon(TreeImages.INSTANCE.printer());
		// TODO Auto-generated constructor stub
	}
	
	
}
