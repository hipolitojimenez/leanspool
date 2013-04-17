package com.nioos.leanspool.gxt.client.container;



import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer;
import com.sencha.gxt.widget.core.client.container.MarginData;
import com.sencha.gxt.widget.core.client.container.Viewport;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer.BorderLayoutData;



public class LeanSpoolerViewport extends Viewport {
	
	
	//TODO change name to something more clear
	private static final int INITIAL_WEST_SIZE = 200;
	
	
	public LeanSpoolerViewport() {
		BorderLayoutContainer borderLayoutContainer =
			new BorderLayoutContainer();
		buildWestWidget(borderLayoutContainer);
		buildCenterWidget(borderLayoutContainer);
		add(borderLayoutContainer);
	}
	
	
	//TODO change name to something more clear
	private void buildCenterWidget(BorderLayoutContainer borderLayoutContainer) {
		ContentPanel centerWidget = new ContentPanel();
		MarginData centerWidgetLayoutData = new MarginData(1);
		borderLayoutContainer.setCenterWidget(centerWidget,
			centerWidgetLayoutData);
	}
	
	
	//TODO change name to something more clear
	private void buildWestWidget(BorderLayoutContainer borderLayoutContainer) {
		BorderLayoutData westWidgetLayoutData =
			new BorderLayoutData(INITIAL_WEST_SIZE);
		westWidgetLayoutData.setCollapsible(true);
		westWidgetLayoutData.setSplit(true);
		westWidgetLayoutData.setCollapseMini(true);
		Margins westMargins = new Margins(1);
		westWidgetLayoutData.setMargins(westMargins);
		//
		ContentPanel westWidget = new ContentPanel();
		//
		borderLayoutContainer.setWestWidget(westWidget, westWidgetLayoutData);
	}
	
	
}
