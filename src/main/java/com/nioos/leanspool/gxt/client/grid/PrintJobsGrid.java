package com.nioos.leanspool.gxt.client.grid;



import java.util.List;

import com.nioos.leanspool.gxt.shared.PrintJobModel;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.ColumnModel;
import com.sencha.gxt.widget.core.client.grid.Grid;



/**
 * Print jobs grid.
 * 
 * @author Hipolito Jimenez.
 *
 */
public class PrintJobsGrid extends Grid<PrintJobModel> {
	
	
	/**
	 * The print jobs HTTP proxy.
	 */
	private final transient PrintJobsHttpProxy printJobsHttpProxy =
		new PrintJobsHttpProxy();
	
	
	/**
	 * Constructor.
	 * @param columnConfigList the column config list.
	 */
	public PrintJobsGrid(
			final List<ColumnConfig<PrintJobModel, ?>> columnConfigList) {
		super(new PrintJobsGridStore(),
			new ColumnModel<PrintJobModel>(columnConfigList));
		setLoader(new PrintJobsListLoader(printJobsHttpProxy, getStore()));
	}
	
	
	/**
	 * Hide the printer name column.
	 */
	public final void hidePrinterNameColumn() {
		getColumnModel().findColumnConfig("PrinterName").setHidden(true);
	}
	
	
	/**
	 * Sets the printer whose print jobs we are interested.
	 * @param printer the printer.
	 */
	public final void setPrinter(final String printer) {
		printJobsHttpProxy.setPrinter(printer);
	}
	
	
	/**
	 * Hide the status column.
	 */
	public final void hideStatusColumn() {
		getColumnModel().findColumnConfig("JobStatus").setHidden(true);
	}
	
	
	/**
	 * Sets the status whose print jobs we are interested.
	 * @param status the status.
	 */
	public final void setStatus(final String status) {
		printJobsHttpProxy.setStatus(status);
	}
	
	
}
