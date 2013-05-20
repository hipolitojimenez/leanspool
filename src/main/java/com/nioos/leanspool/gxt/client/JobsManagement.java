package com.nioos.leanspool.gxt.client;



import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import com.nioos.leanspool.gxt.client.container.JobsManagementViewport;



/**
 * Jobs management GWT UI entry point.
 * 
 * @author Hipolito Jimenez.
 *
 */
public class JobsManagement implements EntryPoint {
	
	
	@Override
	public final void onModuleLoad() {
		RootPanel.get().add(new JobsManagementViewport());
	}
	
	
}
