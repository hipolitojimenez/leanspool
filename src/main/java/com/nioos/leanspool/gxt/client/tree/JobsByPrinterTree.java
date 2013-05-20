package com.nioos.leanspool.gxt.client.tree;



/**
 * Jobs by printer tree.
 * 
 * @author Hipolito Jimenez.
 *
 */
public class JobsByPrinterTree extends AbstractBaseTree<PrinterModel, String> {
	
	
	/**
	 * Constructor.
	 */
	public JobsByPrinterTree() {
		super(new JobsByPrinterTreeStore(),
			new PrinterModelTreeValueProvider());
		getStyle().setLeafIcon(TreeImages.INSTANCE.printer());
		//
		setLoader(new PrintersTreeLoader(getStore()));
	}
	
	
}
