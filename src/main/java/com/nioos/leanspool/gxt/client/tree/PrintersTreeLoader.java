package com.nioos.leanspool.gxt.client.tree;



import java.util.List;

import com.nioos.leanspool.gxt.client.MsgBoxLoaderHandler;
import com.nioos.leanspool.gxt.shared.PrinterModel;
import com.sencha.gxt.data.shared.TreeStore;
import com.sencha.gxt.data.shared.loader.ChildTreeStoreBinding;
import com.sencha.gxt.data.shared.loader.TreeLoader;



/**
 * Printers tree loader.
 * 
 * @author Hipolito Jimenez.
 *
 */
public class PrintersTreeLoader extends TreeLoader<PrinterModel> {
	
	
	/**
	 * Constructor.
	 * @param treeStore the tree store.
	 */
	public PrintersTreeLoader(final TreeStore<PrinterModel> treeStore) {
		super(new PrintersHttpProxy(), new PrintersJsonReader());
		//
		final ChildTreeStoreBinding<PrinterModel> handler =
			new ChildTreeStoreBinding<PrinterModel>(treeStore);
		addLoadHandler(handler);
		final MsgBoxLoaderHandler<PrinterModel, List<PrinterModel>> msgBoxHandler = new MsgBoxLoaderHandler<PrinterModel, List<PrinterModel>>("Retrieving printers");
		addLoaderHandler(msgBoxHandler);
	}
	
	
	@Override
	public final boolean hasChildren(final PrinterModel parent) {
		return "Jobs By Printer".equals(parent.getKey());
	}
	
	
}
