package com.nioos.leanspool.gxt.client.container;



import com.google.gwt.core.client.GWT;
import com.nioos.leanspool.gxt.client.tree.TreeChangeEvent;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.container.AccordionLayoutContainer.AccordionLayoutAppearance;
import com.sencha.gxt.widget.core.client.event.ExpandEvent;
import com.sencha.gxt.widget.core.client.event.ExpandEvent.ExpandHandler;
import com.sencha.gxt.widget.core.client.tree.Tree;



public class TreeContentPanel extends ContentPanel {
	
	
	private static final AccordionLayoutAppearance APPEARANCE =
		GWT.<AccordionLayoutAppearance> create(AccordionLayoutAppearance.class);
	
	
	public <M, C> TreeContentPanel(Tree<M, C> tree) {
		super(APPEARANCE);
		add(tree);
		addExpandHandler(new ExpandHandler() {
			@Override
			public void onExpand(ExpandEvent event) {
				// TODO Auto-generated method stub
				TreeChangeEvent treeChangeEvent = new TreeChangeEvent();
				treeChangeEvent.setCurrentNodeName("TreeContentPanel");
				treeChangeEvent.fireFromSource(this);
			}
		});
		// TODO Auto-generated constructor stub
	}
	
	
}
