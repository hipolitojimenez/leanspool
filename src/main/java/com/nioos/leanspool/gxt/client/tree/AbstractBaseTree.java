package com.nioos.leanspool.gxt.client.tree;



import java.util.List;

import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.TreeStore;
import com.sencha.gxt.widget.core.client.selection.SelectionChangedEvent;
import com.sencha.gxt.widget.core.client.selection.SelectionChangedEvent.SelectionChangedHandler;
import com.sencha.gxt.widget.core.client.tree.Tree;



public abstract class AbstractBaseTree<M, C> extends Tree<M, C> {
	
	
	public AbstractBaseTree(TreeStore<M> store,
			ValueProvider<? super M, C> valueProvider) {
		super(store, valueProvider);
		//
		getSelectionModel().addSelectionChangedHandler(new SelectionChangedHandler<M>() {
			@Override
			public void onSelectionChanged(SelectionChangedEvent<M> event) {
				List<M> selectionList = event.getSelection();
				TreeChangeEvent treeChangeEvent = new TreeChangeEvent();
				if (selectionList != null && !selectionList.isEmpty()) {
					M selection = selectionList.get(0);
					selectedNodeName = treeChangeEvent.setCurrentNodeName(selection);
				}
				treeChangeEvent.fireFromSource(this);
			}
		});
	}
	
	
	protected String selectedNodeName;
	
	
	public String getSelectedNodeName() {
		return selectedNodeName;
	}
	
	
}
