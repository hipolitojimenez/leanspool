package com.nioos.leanspool.gxt.client.container;



import com.nioos.leanspool.gxt.client.HasRelatedGrid;
import com.nioos.leanspool.gxt.client.grid.PrintJobsGrid;
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



/**
 * Jobs management viewport.
 * 
 * @author Hipolito Jimenez.
 *
 */
public class JobsManagementViewport extends Viewport {
	
	
	/**
	 * Tree change handler.
	 * @author Hipolito Jimenez.
	 */
	private static final class InternalTreeChangeHandler implements
			TreeChangeHandler {
		
		/**
		 * The target content panel.
		 */
		private final ContentPanel targetContentPanel;
		
		/**
		 * Constructor.
		 * @param contentPanel the target content panel.
		 */
		private InternalTreeChangeHandler(final ContentPanel contentPanel) {
			targetContentPanel = contentPanel;
		}
		
		@Override
		public void onTreeChange(final TreeChangeEvent event) {
			targetContentPanel.clear();
			String currentNodeName = event.getCurrentNodeName();
			targetContentPanel.setHeadingText(currentNodeName);
			if (currentNodeName != null && event.isLeaf()) {
				HasRelatedGrid hasRelatedGrid =
					(HasRelatedGrid) event.getSource();
				PrintJobsGrid grid = hasRelatedGrid.getRelatedGrid();
				if (grid != null) {
					grid.getStore().clear();
					targetContentPanel.add(grid);
					grid.getLoader().load();
				}
			}
		}
		
	}
	
	
	/**
	 * Initial west panel size.
	 */
	private static final int INITIAL_WEST_SIZE = 200;
	
	
	/**
	 * Constructor.
	 */
	public JobsManagementViewport() {
		BorderLayoutContainer borderLayoutContainer =
			new BorderLayoutContainer();
		buildWestWidget(borderLayoutContainer);
		buildCenterWidget(borderLayoutContainer);
		add(borderLayoutContainer);
	}
	
	
	/**
	 * Builds the center widget.
	 * @param borderLayoutContainer the border layout container.
	 */
	private void buildCenterWidget(
			final BorderLayoutContainer borderLayoutContainer) {
		final ContentPanel centerWidget = new ContentPanel();
		MarginData centerWidgetLayoutData = new MarginData(1);
		borderLayoutContainer.setCenterWidget(centerWidget,
			centerWidgetLayoutData);
		//
		TreeChangeEvent.registerHandler(
			new InternalTreeChangeHandler(centerWidget));
	}
	
	
	/**
	 * Builds the west widget.
	 * @param borderLayoutContainer the border layout container.
	 */
	private void buildWestWidget(
			final BorderLayoutContainer borderLayoutContainer) {
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
