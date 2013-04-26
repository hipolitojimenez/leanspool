package com.nioos.leanspool.gxt.client.container;



import com.google.gwt.core.client.GWT;
import com.nioos.leanspool.gxt.client.HasRelatedGrid;
import com.nioos.leanspool.gxt.client.tree.AbstractBaseTree;
import com.nioos.leanspool.gxt.client.tree.TreeChangeEvent;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.container.AccordionLayoutContainer.AccordionLayoutAppearance;
import com.sencha.gxt.widget.core.client.event.CollapseEvent;
import com.sencha.gxt.widget.core.client.event.CollapseEvent.CollapseHandler;
import com.sencha.gxt.widget.core.client.event.ExpandEvent;
import com.sencha.gxt.widget.core.client.event.ExpandEvent.ExpandHandler;
import com.sencha.gxt.widget.core.client.grid.Grid;



public class TreeContentPanel extends ContentPanel implements HasRelatedGrid {
	
	
	private static final AccordionLayoutAppearance APPEARANCE =
		GWT.<AccordionLayoutAppearance> create(AccordionLayoutAppearance.class);
	
	
	private AbstractBaseTree<?, ?> internalTree;
	
	
	public <M, C> TreeContentPanel(final AbstractBaseTree<M, C> tree) {
		super(APPEARANCE);
		internalTree = tree;
		add(tree);
		addCollapseHandler(new CollapseHandler() {
			@Override
			public void onCollapse(CollapseEvent event) {
				TreeChangeEvent treeChangeEvent = new TreeChangeEvent();
				treeChangeEvent.setLeaf(false);
				treeChangeEvent.fireFromSource(TreeContentPanel.this);
			}
		});
		addExpandHandler(new ExpandHandler() {
			@Override
			public void onExpand(ExpandEvent event) {
				TreeChangeEvent treeChangeEvent = new TreeChangeEvent();
				treeChangeEvent.setCurrentNodeName(tree.getSelectedNodeName());
				treeChangeEvent.setLeaf(tree.isCurrentNodeLeaf());
				treeChangeEvent.fireFromSource(TreeContentPanel.this);
			}
		});
	}
	
	
	@Override
	public Grid<?> getRelatedGrid() {
		return internalTree.getRelatedGrid();
	}
	
	
}
