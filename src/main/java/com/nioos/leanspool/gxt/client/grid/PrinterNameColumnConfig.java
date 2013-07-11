package com.nioos.leanspool.gxt.client.grid;



import com.nioos.leanspool.gxt.shared.PrintJobModel;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;



/**
 * Printer name column configuration.
 * 
 * @author Hipolito Jimenez.
 *
 */
public class PrinterNameColumnConfig
		extends ColumnConfig<PrintJobModel, String> {
	
	
	/**
	 * Printer name column width.
	 */
	private static final int PRINTER_NAME_WIDTH = 100;
	
	
	/**
	 * Printer name column header.
	 */
	private static final String PRINTER_NAME_HEADER = "Printer Name";
	
	
	/**
	 * Constructor.
	 */
	public PrinterNameColumnConfig() {
		super(new PrinterNameValueProvider(), PRINTER_NAME_WIDTH,
			PRINTER_NAME_HEADER);
	}
	
	
}
