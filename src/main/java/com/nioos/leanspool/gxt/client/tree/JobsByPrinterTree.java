package com.nioos.leanspool.gxt.client.tree;



import com.sencha.gxt.widget.core.client.tree.Tree;



public class JobsByPrinterTree extends Tree<PrinterModel, String> {
	
	
	public JobsByPrinterTree() {
		super(new JobsByPrinterTreeStore(), new PrinterModelTreeValueProvider());
		getStyle().setLeafIcon(TreeImages.INSTANCE.printer());
		// TODO Auto-generated constructor stub
	}
	
	
}
