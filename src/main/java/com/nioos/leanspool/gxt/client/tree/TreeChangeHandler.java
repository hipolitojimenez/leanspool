package com.nioos.leanspool.gxt.client.tree;



import com.google.gwt.event.shared.EventHandler;



/**
 * Interface for the tree change event handler.
 * @author Hipolito Jimenez.
 *
 */
public interface TreeChangeHandler extends EventHandler {
	
	/**
	 * Handles the tree change event.
	 * @param event the tree change event.
	 */
	void onTreeChange(TreeChangeEvent event);
	
}
