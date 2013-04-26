package com.nioos.leanspool.gxt.client.tree;



import java.util.ArrayList;
import java.util.List;

import com.nioos.leanspool.gxt.client.HasRelatedGrid;
import com.nioos.leanspool.gxt.client.grid.JobIdColumnConfig;
import com.nioos.leanspool.gxt.client.grid.PrintJobModel;
import com.nioos.leanspool.gxt.client.grid.PrintJobsGrid;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.TreeStore;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.selection.SelectionChangedEvent;
import com.sencha.gxt.widget.core.client.selection.SelectionChangedEvent.SelectionChangedHandler;
import com.sencha.gxt.widget.core.client.tree.Tree;



public abstract class AbstractBaseTree<M, C> extends Tree<M, C> implements HasRelatedGrid {
	
	
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
					isCurrentNodeLeaf = AbstractBaseTree.this.isLeaf(selection);
					treeChangeEvent.setLeaf(isCurrentNodeLeaf);
					selectedNodeName = treeChangeEvent.setCurrentNodeName(selection);
				}
				treeChangeEvent.fireFromSource(AbstractBaseTree.this);
			}
		});
		//
		List<ColumnConfig<PrintJobModel, ?>> columnConfigList =
			new ArrayList<ColumnConfig<PrintJobModel,?>>();
		JobIdColumnConfig jobIdColumnConfig = new JobIdColumnConfig();
		columnConfigList.add(jobIdColumnConfig);
		printJobsGrid = new PrintJobsGrid(columnConfigList);
	}
	
	
	private String selectedNodeName;
	
	
	private boolean isCurrentNodeLeaf;
	
	
	private PrintJobsGrid printJobsGrid;
	
	
	public String getSelectedNodeName() {
		return selectedNodeName;
	}
	
	
	public boolean isCurrentNodeLeaf() {
		return isCurrentNodeLeaf;
	}
	
	
	@Override
	public PrintJobsGrid getRelatedGrid() {
		return printJobsGrid;
	}
	
	
}
