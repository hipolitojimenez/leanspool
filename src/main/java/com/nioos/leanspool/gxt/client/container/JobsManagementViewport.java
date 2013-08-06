package com.nioos.leanspool.gxt.client.container;



import com.nioos.leanspool.gxt.client.tree.AllJobsTree;
import com.nioos.leanspool.gxt.client.tree.JobsByPrinterTree;
import com.nioos.leanspool.gxt.client.tree.JobsByStatusTree;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.container.AccordionLayoutContainer;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer.BorderLayoutData;
import com.sencha.gxt.widget.core.client.container.MarginData;
import com.sencha.gxt.widget.core.client.container.Viewport;



/**
 * Jobs management viewport.
 * 
 * @author Hipolito Jimenez.
 *
 */
public class JobsManagementViewport extends Viewport {
	
	
	/**
	 * Initial west panel size.
	 */
	private static final int INITIAL_WEST_SIZE = 200;
	
	
	/**
	 * Constructor.
	 */
	public JobsManagementViewport() {
		super();
		final BorderLayoutContainer borderLayoutContainer =
			new BorderLayoutContainer();
		buildWestWidget(borderLayoutContainer);
		buildCenterWidget(borderLayoutContainer);
		//
		add(borderLayoutContainer);
	}
	
	
	/**
	 * Builds the center widget.
	 * @param borderLayoutContainer the border layout container.
	 */
	private void buildCenterWidget(
			final BorderLayoutContainer borderLayoutContainer) {
		final GridContentPanel centerWidget = new GridContentPanel();
		final MarginData centerWidgetLayoutData = new MarginData(1);
		borderLayoutContainer.setCenterWidget(centerWidget,
			centerWidgetLayoutData);
	}
	
	
	/**
	 * Builds the west widget.
	 * @param borderLayoutContainer the border layout container.
	 */
	private void buildWestWidget(
			final BorderLayoutContainer borderLayoutContainer) {
		final BorderLayoutData westWidgetLayoutData =
			new BorderLayoutData(INITIAL_WEST_SIZE);
		westWidgetLayoutData.setCollapsible(true);
		westWidgetLayoutData.setSplit(true);
		westWidgetLayoutData.setCollapseMini(true);
		final Margins westMargins = new Margins(1);
		westWidgetLayoutData.setMargins(westMargins);
		//
		final ContentPanel westWidget = new ContentPanel();
		westWidget.setHeaderVisible(false);
		final AccordionLayoutContainer accordion =
			new AccordionLayoutContainer();
		//
		final TreeContentPanel allJobsPanel =
			new TreeContentPanel(new AllJobsTree());
		allJobsPanel.setHeadingText("View All Jobs");
		accordion.add(allJobsPanel);
		accordion.setActiveWidget(allJobsPanel);
		//
		final TreeContentPanel jobsByPrinterPanel =
			new TreeContentPanel(new JobsByPrinterTree());
		jobsByPrinterPanel.setHeadingText("View Jobs By Printer");
		accordion.add(jobsByPrinterPanel);
		//
		final TreeContentPanel jobsByStatusPanel =
			new TreeContentPanel(new JobsByStatusTree());
		jobsByStatusPanel.setHeadingText("View Jobs By Status");
		accordion.add(jobsByStatusPanel);
		//
		westWidget.add(accordion);
		borderLayoutContainer.setWestWidget(westWidget, westWidgetLayoutData);
	}
	
	
}
