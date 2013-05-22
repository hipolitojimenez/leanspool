package com.nioos.leanspool.gxt.client.container;



import com.google.gwt.core.client.GWT;
import com.nioos.leanspool.gxt.client.HasRelatedGrid;
import com.nioos.leanspool.gxt.client.grid.PrintJobsGrid;
import com.nioos.leanspool.gxt.client.tree.AbstractBaseTree;
import com.nioos.leanspool.gxt.client.tree.TreeChangeEvent;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.container.AccordionLayoutContainer.AccordionLayoutAppearance;
import com.sencha.gxt.widget.core.client.event.CollapseEvent;
import com.sencha.gxt.widget.core.client.event.CollapseEvent.CollapseHandler;
import com.sencha.gxt.widget.core.client.event.ExpandEvent;
import com.sencha.gxt.widget.core.client.event.ExpandEvent.ExpandHandler;



/**
 * Tree content panel.
 * @author Hipolito Jimenez.
 *
 */
public class TreeContentPanel extends ContentPanel implements HasRelatedGrid {
	
	
	/**
	 * Accordion layout appearance.
	 */
	private static final AccordionLayoutAppearance APPEARANCE =
		GWT.<AccordionLayoutAppearance> create(AccordionLayoutAppearance.class);
	
	
	/**
	 * Tree widget on this content panel.
	 */
	private final transient AbstractBaseTree<?, ?> internalTree;
	
	
	/**
	 * Constructor.
	 * @param tree the tree widget to be added to this content panel.
	 * @param <M>  the model type
	 * @param <C> the cell data type
	 */
	public <M, C> TreeContentPanel(final AbstractBaseTree<M, C> tree) {
		super(APPEARANCE);
		internalTree = tree;
		add(tree);
		addCollapseHandler(new CollapseHandler() {
			@Override
			public void onCollapse(final CollapseEvent event) {
				final TreeChangeEvent treeChangeEvent = new TreeChangeEvent();
				treeChangeEvent.setLeaf(false);
				treeChangeEvent.fireFromSource(TreeContentPanel.this);
			}
		});
		addExpandHandler(new ExpandHandler() {
			@Override
			public void onExpand(final ExpandEvent event) {
				final TreeChangeEvent treeChangeEvent = new TreeChangeEvent();
				treeChangeEvent.setCurrentNodeName(tree.getSelectedNodeName());
				treeChangeEvent.setLeaf(tree.isCurrentNodeLeaf());
				treeChangeEvent.fireFromSource(TreeContentPanel.this);
			}
		});
	}
	
	
	@Override
	public final PrintJobsGrid getRelatedGrid() {
		return internalTree.getRelatedGrid();
	}
	
	
}
