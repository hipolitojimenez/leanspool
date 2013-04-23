package com.nioos.leanspool.gxt.client.tree;



import java.util.List;

import com.nioos.leanspool.gxt.client.JobsManagement;
import com.sencha.gxt.widget.core.client.selection.SelectionChangedEvent;
import com.sencha.gxt.widget.core.client.selection.SelectionChangedEvent.SelectionChangedHandler;
import com.sencha.gxt.widget.core.client.tree.Tree;



public class AllJobsTree extends Tree<String, String> {
	
	
	public AllJobsTree() {
		super(new AllJobsTreeStore(), new StringTreeValueProvider());
		getStyle().setLeafIcon(TreeImages.INSTANCE.job());
		getSelectionModel().addSelectionChangedHandler(new SelectionChangedHandler<String>() {
			@Override
			public void onSelectionChanged(SelectionChangedEvent<String> event) {
				List<String> selectionList = event.getSelection();
				TreeChangeEvent treeChangeEvent = new TreeChangeEvent();
				if (selectionList != null && !selectionList.isEmpty()) {
					String selection = selectionList.get(0);
					treeChangeEvent.setCurrentNodeName(selection);
				}
				JobsManagement.EVENTBUS.fireEventFromSource(treeChangeEvent, this);
			}
		});
		// TODO Auto-generated constructor stub
	}
	
	
}
