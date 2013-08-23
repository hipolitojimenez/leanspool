package com.nioos.leanspool.gxt.client.container;



import java.util.List;

import com.nioos.leanspool.gxt.client.grid.PrintJobsGrid;
import com.nioos.leanspool.gxt.client.grid.PrintJobsLoadConfigBean;
import com.nioos.leanspool.gxt.client.grid.PrintJobsPagingLoader;
import com.nioos.leanspool.gxt.client.tree.TreeChangeEvent;
import com.sencha.gxt.data.shared.SortInfo;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.container.BoxLayoutContainer.BoxLayoutPack;
import com.sencha.gxt.widget.core.client.toolbar.PagingToolBar;



/**
 * Grid content panel.
 * @author Hipolito Jimenez.
 */
public class GridContentPanel extends ContentPanel {
	
	
	/**
	 * Paging tool bar width.
	 */
	private static final int PAGINGTOOLBARWIDTH = 450;
	
	
	/**
	 * Paging page size.
	 */
	public static final int PAGESIZE = 50;
	
	
	/**
	 * Paging tool bar widget.
	 */
	private final  transient PagingToolBar pagingToolBar =
		new PagingToolBar(PAGESIZE);
	
	
	/**
	 * Print jobs grid.
	 */
	private transient PrintJobsGrid grid;
	
	
	/**
	 * Constructor.
	 */
	public GridContentPanel() {
		super();
		TreeChangeEvent.registerHandler(new BaseTreeChangeHandler(this));
		getButtonBar().setPack(BoxLayoutPack.CENTER);
		pagingToolBar.disable();
		pagingToolBar.setWidth(PAGINGTOOLBARWIDTH);
		getButtonBar().add(pagingToolBar);
	}
	
	
	/**
	 * Removes the grid from the content panel.
	 * Also disables and unbinds the paging tool bar.
	 */
	public final void clearGrid() {
		if (grid != null) {
			grid.removeFromParent();
			pagingToolBar.bind(null);
			pagingToolBar.clear();
			pagingToolBar.disable();
		}
	}
	
	
	/**
	 * Add the grid to the content panel.
	 * Enables and binds the paging tool bar.
	 * Loads data to the new grid.
	 * @param printJobsGrid the new print jobs grid.
	 */
	public final void addGrid(final PrintJobsGrid printJobsGrid) {
		clearGrid();
		grid = printJobsGrid;
		add(grid);
		forceLayout();
		pagingToolBar.enable();
		final PrintJobsPagingLoader pagingLoader =
			(PrintJobsPagingLoader) grid.getLoader();
		pagingToolBar.bind(pagingLoader);
		//
		final List<? extends SortInfo> info = pagingLoader.getSortInfo();
		//
		final PrintJobsLoadConfigBean pjlcb =
			new PrintJobsLoadConfigBean(0, PAGESIZE);
		pjlcb.setSortInfo(info);
		pjlcb.setPrinter(pagingLoader.getPrinter());
		pjlcb.setStatus(pagingLoader.getStatus());
		pagingLoader.load(pjlcb);
	}
	
	
}
