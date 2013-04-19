package com.nioos.leanspool.gxt.client.container;



import com.google.gwt.core.client.GWT;
import com.nioos.leanspool.gxt.client.tree.JobsManagementTree;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.container.AccordionLayoutContainer;
import com.sencha.gxt.widget.core.client.container.AccordionLayoutContainer.AccordionLayoutAppearance;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer.BorderLayoutData;
import com.sencha.gxt.widget.core.client.container.MarginData;
import com.sencha.gxt.widget.core.client.container.Viewport;



public class JobsManagementViewport extends Viewport {
	
	
	private static final int INITIAL_WEST_SIZE = 200;
	
	
	public JobsManagementViewport() {
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
		westWidget.setHeaderVisible(false);
		AccordionLayoutContainer accordion = new AccordionLayoutContainer();
		AccordionLayoutAppearance appearance = GWT.<AccordionLayoutAppearance> create(AccordionLayoutAppearance.class);
		ContentPanel jobsManagementPanel = new ContentPanel(appearance);
		jobsManagementPanel.setHeadingText("View All Jobs");
		jobsManagementPanel.add(new JobsManagementTree());
		accordion.add(jobsManagementPanel);
		accordion.setActiveWidget(jobsManagementPanel);
		//
		ContentPanel contentPanel02 = new ContentPanel(appearance);
		contentPanel02.setHeadingText("View By Printer");
		accordion.add(contentPanel02);
		//
		westWidget.add(accordion);
		borderLayoutContainer.setWestWidget(westWidget, westWidgetLayoutData);
	}
	
	
}
