package com.nioos.leanspool.gxt.client.container;



import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer;
import com.sencha.gxt.widget.core.client.container.Viewport;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer.BorderLayoutData;



public class LeanSpoolerViewport extends Viewport {
	
	
	public LeanSpoolerViewport() {
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
		add(borderLayoutContainer);
	}
	
	
}
