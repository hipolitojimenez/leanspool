package com.nioos.leanspool.gxt.client.grid;



import com.sencha.gxt.data.shared.loader.PagingLoadConfigBean;



/**
 * PrintJobsLoadConfig implementation.
 * @author Hipolito Jimenez.
 */
public class PrintJobsLoadConfigBean extends PagingLoadConfigBean
		implements PrintJobsLoadConfig {
	
	
	/**
	 * Serial version uid.
	 */
	private static final long serialVersionUID = 4117301243988551450L;
	
	
	/**
	 * Paging page size.
	 */
	public static final int PAGESIZE = 50;
	
	
	/**
	 * The printer.
	 */
	private String printer;
	
	
	/**
	 * The status.
	 */
	private String status;
	
	
	/**
	 * Constructor.
	 * @param offset the offset.
	 * @param limit the limit.
	 */
	public PrintJobsLoadConfigBean(final int offset, final int limit) {
		super(offset, limit);
	}
	
	
	/**
	 * Constructor.
	 */
	public PrintJobsLoadConfigBean() {
		this(0, PAGESIZE);
	}
	
	
	@Override
	public final void setPrinter(final String thePrinter) {
		printer = thePrinter;
	}
	
	
	@Override
	public final String getPrinter() {
		return printer;
	}
	
	
	@Override
	public final void setStatus(final String theStatus) {
		status = theStatus;
	}
	
	
	@Override
	public final String getStatus() {
		return status;
	}
	
	
}
