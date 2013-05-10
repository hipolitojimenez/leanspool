package com.nioos.leanspool.gxt.client.tree;



import com.google.gwt.core.client.GWT;
import com.google.web.bindery.autobean.shared.AutoBean;
import com.google.web.bindery.autobean.shared.AutoBeanFactory;



public interface PrintersAutoBeanFactory extends AutoBeanFactory {
	
	PrintersAutoBeanFactory INSTANCE =
		GWT.create(PrintersAutoBeanFactory.class);
	
	AutoBean<PrintersJsonRoot> printersJsonRoot();
	
}
