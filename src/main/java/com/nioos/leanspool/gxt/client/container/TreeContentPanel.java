package com.nioos.leanspool.gxt.client.container;



import com.google.gwt.core.client.GWT;
import com.nioos.leanspool.gxt.client.tree.AbstractBaseTree;
import com.nioos.leanspool.gxt.client.tree.TreeChangeEvent;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.container.AccordionLayoutContainer.AccordionLayoutAppearance;
import com.sencha.gxt.widget.core.client.event.ExpandEvent;
import com.sencha.gxt.widget.core.client.event.ExpandEvent.ExpandHandler;



public class TreeContentPanel extends ContentPanel {
	
	
	private static final AccordionLayoutAppearance APPEARANCE =
		GWT.<AccordionLayoutAppearance> create(AccordionLayoutAppearance.class);
	
	
	public <M, C> TreeContentPanel(final AbstractBaseTree<M, C> tree) {
		super(APPEARANCE);
		add(tree);
		addExpandHandler(new ExpandHandler() {
			@Override
			public void onExpand(ExpandEvent event) {
				TreeChangeEvent treeChangeEvent = new TreeChangeEvent();
				treeChangeEvent.setCurrentNodeName(tree.getSelectedNodeName());
				treeChangeEvent.fireFromSource(this);
			}
		});
		// TODO Auto-generated constructor stub
	}
	
	
}
