package com.nioos.leanspool.gxt.client.grid;



import com.google.gwt.core.client.GWT;
import com.google.web.bindery.autobean.shared.AutoBean;
import com.google.web.bindery.autobean.shared.AutoBeanFactory;
import com.sencha.gxt.data.shared.loader.PagingLoadConfig;



/**
 * Print jobs AutoBean factory.
 * 
 * @author Hipolito Jimenez.
 *
 */
public interface PrintJobsAutoBeanFactory extends AutoBeanFactory {
	
	/**
	 * Print jobs AutoBean factory instance.
	 */
	PrintJobsAutoBeanFactory INSTANCE =
		GWT.create(PrintJobsAutoBeanFactory.class);
	
	/**
	 * Gets the print jobs.
	 * @return the print jobs.
	 */
	AutoBean<PrintJobsJsonRoot> printJobsJsonRoot();
	
	/**
	 * Gets the load config.
	 * @return the load config.
	 */
	AutoBean<PagingLoadConfig> pagingLoadConfig();
	
}
