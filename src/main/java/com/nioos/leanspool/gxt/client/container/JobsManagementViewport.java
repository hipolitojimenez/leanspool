package com.nioos.leanspool.gxt.client.container;



import com.nioos.leanspool.gxt.client.tree.AbstractBaseTree;
import com.nioos.leanspool.gxt.client.tree.AllJobsTree;
import com.nioos.leanspool.gxt.client.tree.JobsByPrinterTree;
import com.nioos.leanspool.gxt.client.tree.JobsByStatusTree;
import com.nioos.leanspool.gxt.client.tree.TreeChangeEvent;
import com.nioos.leanspool.gxt.client.tree.TreeChangeHandler;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.container.AccordionLayoutContainer;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer.BorderLayoutData;
import com.sencha.gxt.widget.core.client.container.MarginData;
import com.sencha.gxt.widget.core.client.container.Viewport;
import com.sencha.gxt.widget.core.client.grid.Grid;



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
		final ContentPanel centerWidget = new ContentPanel();
		MarginData centerWidgetLayoutData = new MarginData(1);
		borderLayoutContainer.setCenterWidget(centerWidget,
			centerWidgetLayoutData);
		//
		TreeChangeEvent.registerHandler(new TreeChangeHandler() {
			@Override
			public void onTreeChange(TreeChangeEvent event) {
				centerWidget.setHeadingText(event.getCurrentNodeName());
				centerWidget.clear();
				Object source = event.getSource();
				if (source instanceof AbstractBaseTree<?, ?>) {
					AbstractBaseTree<?, ?> tree =
							(AbstractBaseTree<?, ?>) source;
					Grid<?> grid = tree.getRelatedGrid();
					if (grid != null) {
						//TODO grid store remove
						centerWidget.add(grid);
						//TODO grid loader load
					}
				}
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
		//
		TreeContentPanel allJobsPanel =
			new TreeContentPanel(new AllJobsTree());
		allJobsPanel.setHeadingText("View All Jobs");
		accordion.add(allJobsPanel);
		accordion.setActiveWidget(allJobsPanel);
		//
		TreeContentPanel jobsByPrinterPanel =
			new TreeContentPanel(new JobsByPrinterTree());
		jobsByPrinterPanel.setHeadingText("View Jobs By Printer");
		accordion.add(jobsByPrinterPanel);
		//
		TreeContentPanel jobsByStatusPanel =
			new TreeContentPanel(new JobsByStatusTree());
		jobsByStatusPanel.setHeadingText("View Jobs By Status");
		accordion.add(jobsByStatusPanel);
		//
		westWidget.add(accordion);
		borderLayoutContainer.setWestWidget(westWidget, westWidgetLayoutData);
	}
	
	
}
