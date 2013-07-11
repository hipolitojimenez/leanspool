package com.nioos.leanspool.gxt.client.tree;



import com.nioos.leanspool.gxt.client.grid.PrintJobsGrid;
import com.nioos.leanspool.gxt.shared.PrinterModel;



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
		//
		getRelatedGrid().hidePrinterNameColumn();
	}
	
	
	@Override
	protected final void changeSelectedNodeName(
			final String theSelectedNodeName) {
		final PrintJobsGrid printJobsGrid = getRelatedGrid();
		printJobsGrid.setPrinter(theSelectedNodeName);
	}
	
	
}
