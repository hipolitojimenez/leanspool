package com.nioos.leanspool.gxt.client.container;



import com.nioos.leanspool.gxt.client.HasRelatedGrid;
import com.nioos.leanspool.gxt.client.grid.PrintJobsGrid;
import com.nioos.leanspool.gxt.client.tree.TreeChangeEvent;
import com.nioos.leanspool.gxt.client.tree.TreeChangeHandler;



/**
 * Tree change handler.
 * @author Hipolito Jimenez.
 */
public class BaseTreeChangeHandler implements TreeChangeHandler {
	
	
	/**
	 * The target grid content panel.
	 */
	private final transient GridContentPanel targetPanel;
	
	
	/**
	 * Constructor.
	 * @param gridContentPanel the target grid content panel.
	 */
	BaseTreeChangeHandler(final GridContentPanel gridContentPanel) {
		targetPanel = gridContentPanel;
	}
	
	
	@Override
	public final void onTreeChange(final TreeChangeEvent event) {
		targetPanel.clearGrid();
		final String currentNodeName = event.getCurrentNodeName();
		targetPanel.setHeadingText(currentNodeName);
		if (currentNodeName != null && event.isLeaf()) {
			final HasRelatedGrid hasRelatedGrid =
				(HasRelatedGrid) event.getSource();
			final PrintJobsGrid grid = hasRelatedGrid.getRelatedGrid();
			if (grid != null) {
				grid.getStore().clear();
				targetPanel.addGrid(grid);
			}
		}
	}
	
	
}
