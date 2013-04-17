package com.nioos.leanspool.gxt.client;



import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import com.nioos.leanspool.gxt.client.container.LeanSpoolerViewport;



public class LeanSpooler implements EntryPoint {
	
	
	@Override
	public void onModuleLoad() {
		RootPanel.get().add(new LeanSpoolerViewport());
	}
	
	
}
