package com.nioos.leanspool.gxt.client.container;



import com.nioos.leanspool.gxt.client.tree.LeanSpoolerTree;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer.BorderLayoutData;
import com.sencha.gxt.widget.core.client.container.MarginData;
import com.sencha.gxt.widget.core.client.container.Viewport;



public class LeanSpoolerViewport extends Viewport {
	
	
	private static final int INITIAL_WEST_SIZE = 200;
	
	
	public LeanSpoolerViewport() {
		BorderLayoutContainer borderLayoutContainer =
			new BorderLayoutContainer();
		buildWestWidget(borderLayoutContainer);
		buildCenterWidget(borderLayoutContainer);
		add(borderLayoutContainer);
	}
	
	
	private void buildCenterWidget(BorderLayoutContainer borderLayoutContainer) {
		ContentPanel centerWidget = new ContentPanel();
		MarginData centerWidgetLayoutData = new MarginData(1);
		borderLayoutContainer.setCenterWidget(centerWidget,
			centerWidgetLayoutData);
	}
	
	
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
		westWidget.add(new LeanSpoolerTree());
		//
		borderLayoutContainer.setWestWidget(westWidget, westWidgetLayoutData);
	}
	
	
}
