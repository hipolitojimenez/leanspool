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
	 * The print jobs paging loader.
	 */
	private final transient PrintJobsPagingLoader printJobsPagingLoader;
	
	
	/**
	 * Constructor.
	 * @param columnConfigList the column config list.
	 */
	public PrintJobsGrid(
			final List<ColumnConfig<PrintJobModel, ?>> columnConfigList) {
		super(new PrintJobsGridStore(),
			new ColumnModel<PrintJobModel>(columnConfigList));
		setId("printJobsGrid");
		printJobsPagingLoader =
			new PrintJobsPagingLoader(new PrintJobsHttpProxy(), getStore());
		setLoader(printJobsPagingLoader);
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
		printJobsPagingLoader.setPrinter(printer);
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
		printJobsPagingLoader.setStatus(status);
	}
	
	
}
