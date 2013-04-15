package com.nioos.leanspool.gxt.client;



import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import com.sencha.gxt.widget.core.client.container.Viewport;



public class LeanSpooler implements EntryPoint {
	
	
	@Override
	public void onModuleLoad() {
		Viewport viewport = new Viewport();
		//TODO
		RootPanel.get().add(viewport);
	}
	
	
}
