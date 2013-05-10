package com.nioos.leanspool.gxt.client.grid;



import com.google.gwt.core.client.GWT;
import com.google.web.bindery.autobean.shared.AutoBean;
import com.google.web.bindery.autobean.shared.AutoBeanFactory;
import com.sencha.gxt.data.shared.loader.ListLoadConfig;



public interface PrintJobsAutoBeanFactory extends AutoBeanFactory {
	
	PrintJobsAutoBeanFactory INSTANCE = GWT.create(PrintJobsAutoBeanFactory.class);
	
	AutoBean<PrintJobsJsonRoot> printJobsJsonRoot();
	
	AutoBean<ListLoadConfig> listLoadConfig();
	
}
