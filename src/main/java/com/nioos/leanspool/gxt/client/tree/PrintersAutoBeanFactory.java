package com.nioos.leanspool.gxt.client.tree;



import com.google.gwt.core.client.GWT;
import com.google.web.bindery.autobean.shared.AutoBean;
import com.google.web.bindery.autobean.shared.AutoBeanFactory;



/**
 * Printers AutoBean factory.
 * 
 * @author Hipolito Jimenez.
 *
 */
public interface PrintersAutoBeanFactory extends AutoBeanFactory {
	
	/**
	 * Printers AutoBean factory instance.
	 */
	PrintersAutoBeanFactory INSTANCE =
		GWT.create(PrintersAutoBeanFactory.class);
	
	/**
	 * Get the printers.
	 * @return the printers.
	 */
	AutoBean<PrintersJsonRoot> printersJsonRoot();
	
}
