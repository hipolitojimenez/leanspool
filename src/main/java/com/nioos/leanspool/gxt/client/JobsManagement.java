package com.nioos.leanspool.gxt.client;



import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;
import com.nioos.leanspool.gxt.client.container.JobsManagementViewport;



public class JobsManagement implements EntryPoint {
	
	
	public static final EventBus EVENTBUS = new SimpleEventBus();
	
	
	@Override
	public void onModuleLoad() {
		RootPanel.get().add(new JobsManagementViewport());
	}
	
	
}
