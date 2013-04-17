package com.nioos.leanspool.gxt.client;



import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer.BorderLayoutData;
import com.sencha.gxt.widget.core.client.container.Viewport;



public class LeanSpooler implements EntryPoint {
	
	
	@Override
	public void onModuleLoad() {
		Viewport viewport = new Viewport();
		//
		BorderLayoutContainer borderLayoutContainer =
			new BorderLayoutContainer();
		//
		BorderLayoutData westWidgetLayoutData = new BorderLayoutData(200);
		westWidgetLayoutData.setCollapsible(true);
		westWidgetLayoutData.setSplit(true);
		Margins westMargins = new Margins(1);
		westWidgetLayoutData.setMargins(westMargins);
		ContentPanel westWidget = new ContentPanel();
		borderLayoutContainer.setWestWidget(westWidget, westWidgetLayoutData);
		//
		ContentPanel centerWidget = new ContentPanel();
		borderLayoutContainer.setCenterWidget(centerWidget);
		//
		viewport.add(borderLayoutContainer);
		//TODO
		RootPanel.get().add(viewport);
	}
	
	
}
