package com.nioos.leanspool.gxt.client.tree;



import java.util.ArrayList;
import java.util.List;

import com.nioos.leanspool.gxt.client.HasRelatedGrid;
import com.nioos.leanspool.gxt.client.grid.JobIdColumnConfig;
import com.nioos.leanspool.gxt.client.grid.PrintJobsGrid;
import com.nioos.leanspool.gxt.client.grid.PrinterNameColumnConfig;
import com.nioos.leanspool.gxt.shared.PrintJobModel;
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
				final List<M> selectionList = event.getSelection();
				final TreeChangeEvent treeChangeEvent = new TreeChangeEvent();
				if (selectionList != null && !selectionList.isEmpty()) {
					final M selection = selectionList.get(0);
					isTheCurrentNodeLeaf =
						AbstractBaseTree.this.isLeaf(selection);
					treeChangeEvent.setLeaf(isTheCurrentNodeLeaf);
					selectedNodeName =
						treeChangeEvent.setCurrentNodeName(selection);
					AbstractBaseTree.this.changeSelectedNodeName(
						selectedNodeName);
				}
				treeChangeEvent.fireFromSource(AbstractBaseTree.this);
			}
		});
		//
		final List<ColumnConfig<PrintJobModel, ?>> columnConfigList =
			new ArrayList<ColumnConfig<PrintJobModel, ?>>();
		final JobIdColumnConfig jobIdColumnConfig = new JobIdColumnConfig();
		columnConfigList.add(jobIdColumnConfig);
		final PrinterNameColumnConfig printerNameColumnConfig =
			new PrinterNameColumnConfig();
		columnConfigList.add(printerNameColumnConfig);
		printJobsGrid = new PrintJobsGrid(columnConfigList);
	}
	
	
	/**
	 * Change the selected node name.
	 * @param theSelectedNodeName the selected node name.
	 */
	protected abstract void changeSelectedNodeName(
		final String theSelectedNodeName);
	
	
	/**
	 * The selected tree node name.
	 */
	private transient String selectedNodeName;
	
	
	/**
	 * Is the current node a lead node?
	 */
	private transient boolean isTheCurrentNodeLeaf;
	
	
	/**
	 * The associated print jobs grid.
	 */
	private final transient PrintJobsGrid printJobsGrid;
	
	
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
		return isTheCurrentNodeLeaf;
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
