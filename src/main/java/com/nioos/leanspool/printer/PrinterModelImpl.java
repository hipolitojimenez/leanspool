package com.nioos.leanspool.printer;



import com.nioos.leanspool.gxt.shared.PrinterModel;



/**
 * PrinterModel implementation.
 * @author Hipolito Jimenez.
 *
 */
public class PrinterModelImpl implements PrinterModel {
	
	
	/**
	 * The key.
	 */
	private String key;
	
	
	
	/**
	 * Constructor.
	 * @param theKey the key.
	 */
	public PrinterModelImpl(final String theKey) {
		key = theKey;
	}
	
	
	@Override
	public final String getKey() {
		return key;
	}
	
	
	@Override
	public final void setKey(final String value) {
		key = value;
	}
	
	
}
