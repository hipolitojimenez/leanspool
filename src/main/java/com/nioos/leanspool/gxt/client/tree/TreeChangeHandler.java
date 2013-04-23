package com.nioos.leanspool.gxt.client.tree;



import com.google.gwt.event.shared.EventHandler;



public interface TreeChangeHandler extends EventHandler {
	
	void onTreeChange(TreeChangeEvent event);
	
}
