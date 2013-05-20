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



/**
 * Base abstract tree.
 * 
 * @author Hipolito Jimenez
 *
 * @param <M>  the model type
 * @param <C> the cell data type
 */
public abstract class AbstractBaseTree<M, C> extends Tree<M, C>
		implements HasRelatedGrid {
	
	
	/**
	 * Constructor.
	 * @param store the tree store.
	 * @param valueProvider the tree value provider.
	 */
	public AbstractBaseTree(final TreeStore<M> store,
			final ValueProvider<? super M, C> valueProvider) {
		super(store, valueProvider);
		//
		getSelectionModel().addSelectionChangedHandler(
				new SelectionChangedHandler<M>() {
			@Override
			public void onSelectionChanged(
					final SelectionChangedEvent<M> event) {
				List<M> selectionList = event.getSelection();
				TreeChangeEvent treeChangeEvent = new TreeChangeEvent();
				if (selectionList != null && !selectionList.isEmpty()) {
					M selection = selectionList.get(0);
					isCurrentNodeLeaf = AbstractBaseTree.this.isLeaf(selection);
					treeChangeEvent.setLeaf(isCurrentNodeLeaf);
					selectedNodeName =
						treeChangeEvent.setCurrentNodeName(selection);
				}
				treeChangeEvent.fireFromSource(AbstractBaseTree.this);
			}
		});
		//
		List<ColumnConfig<PrintJobModel, ?>> columnConfigList =
			new ArrayList<ColumnConfig<PrintJobModel, ?>>();
		JobIdColumnConfig jobIdColumnConfig = new JobIdColumnConfig();
		columnConfigList.add(jobIdColumnConfig);
		printJobsGrid = new PrintJobsGrid(columnConfigList);
	}
	
	
	/**
	 * The selected tree node name.
	 */
	private String selectedNodeName;
	
	
	/**
	 * Is the current node a lead node?
	 */
	private boolean isCurrentNodeLeaf;
	
	
	/**
	 * The associated print jobs grid.
	 */
	private PrintJobsGrid printJobsGrid;
	
	
	/**
	 * Gets the selected tree node name.
	 * @return the selected tree node name.
	 */
	public final String getSelectedNodeName() {
		return selectedNodeName;
	}
	
	
	/**
	 * Is the current node a lead node?
	 * @return true if the current node is a lead node.
	 */
	public final boolean isCurrentNodeLeaf() {
		return isCurrentNodeLeaf;
	}
	
	
	/**
	 * Gets the associated print jobs grid.
	 * @return the associated print jobs grid.
	 */
	@Override
	public final PrintJobsGrid getRelatedGrid() {
		return printJobsGrid;
	}
	
	
}
