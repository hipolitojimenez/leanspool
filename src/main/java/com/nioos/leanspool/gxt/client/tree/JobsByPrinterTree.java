package com.nioos.leanspool.gxt.client.tree;



public class JobsByPrinterTree extends AbstractBaseTree<PrinterModel, String> {
	
	
	public JobsByPrinterTree() {
		super(new JobsByPrinterTreeStore(), new PrinterModelTreeValueProvider());
		getStyle().setLeafIcon(TreeImages.INSTANCE.printer());
		//
		setLoader(new PrintersTreeLoader(getStore()));
	}
	
	
}
