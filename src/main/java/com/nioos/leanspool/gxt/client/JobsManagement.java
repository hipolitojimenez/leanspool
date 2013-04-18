package com.nioos.leanspool.gxt.client;



import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import com.nioos.leanspool.gxt.client.container.JobsManagementViewport;



public class JobsManagement implements EntryPoint {
	
	
	@Override
	public void onModuleLoad() {
		RootPanel.get().add(new JobsManagementViewport());
	}
	
	
}
