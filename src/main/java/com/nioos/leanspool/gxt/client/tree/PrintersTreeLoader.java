package com.nioos.leanspool.gxt.client.tree;



import com.sencha.gxt.data.shared.TreeStore;
import com.sencha.gxt.data.shared.loader.ChildTreeStoreBinding;
import com.sencha.gxt.data.shared.loader.TreeLoader;



public class PrintersTreeLoader extends TreeLoader<PrinterModel> {
	
	
	public PrintersTreeLoader(TreeStore<PrinterModel> treeStore) {
		super(new PrintersHttpProxy(), new PrintersJsonReader());
		//
		ChildTreeStoreBinding<PrinterModel> handler =
			new ChildTreeStoreBinding<PrinterModel>(treeStore);
		addLoadHandler(handler);
	}
	
	
	@Override
	public boolean hasChildren(PrinterModel parent) {
		return "Jobs By Printer".equals(parent.getKey());
	}
	
	
}
