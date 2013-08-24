package com.nioos.leanspool.gxt.client.tree;



import com.nioos.leanspool.gwt.shared.PrinterModel;
import com.nioos.leanspool.gxt.client.grid.PrintJobsGrid;



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
		setId("jobsByPrinterTree");
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
