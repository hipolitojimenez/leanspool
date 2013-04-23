package com.nioos.leanspool.gxt.client.container;



import com.google.gwt.core.client.GWT;
import com.nioos.leanspool.gxt.client.tree.AllJobsTree;
import com.nioos.leanspool.gxt.client.tree.JobsByPrinterTree;
import com.nioos.leanspool.gxt.client.tree.JobsByStatusTree;
import com.nioos.leanspool.gxt.client.tree.TreeChangeEvent;
import com.nioos.leanspool.gxt.client.tree.TreeChangeHandler;
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
		//TODO
		TreeChangeEvent.registerHandler(new TreeChangeHandler() {
			@Override
			public void onTreeChange(TreeChangeEvent event) {
				System.out.println("ev : " + event.getCurrentNodeName());
			}
		});
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
		//
		ContentPanel allJobsPanel = new ContentPanel(appearance);
		allJobsPanel.setHeadingText("View All Jobs");
		allJobsPanel.add(new AllJobsTree());
		accordion.add(allJobsPanel);
		accordion.setActiveWidget(allJobsPanel);
		//
		ContentPanel jobsByPrinterPanel = new ContentPanel(appearance);
		jobsByPrinterPanel.setHeadingText("View Jobs By Printer");
		jobsByPrinterPanel.add(new JobsByPrinterTree());
		accordion.add(jobsByPrinterPanel);
		//
		ContentPanel jobsByStatusPanel = new ContentPanel(appearance);
		jobsByStatusPanel.setHeadingText("View Jobs By Status");
		jobsByStatusPanel.add(new JobsByStatusTree());
		accordion.add(jobsByStatusPanel);
		//
		westWidget.add(accordion);
		borderLayoutContainer.setWestWidget(westWidget, westWidgetLayoutData);
	}
	
	
}
