package com.nioos.leanspool.gxt.client.tree;



import com.nioos.leanspool.gxt.client.AbstractBaseEvent;



/**
 * Tree change event.
 * @author Hipolito Jimenez.
 *
 */
public class TreeChangeEvent extends AbstractBaseEvent<TreeChangeHandler> {
	
	
	/**
	 * The event type.
	 */
	private static final Type<TreeChangeHandler> TYPE =
		new Type<TreeChangeHandler>();
	
	
	/**
	 * The node name as a string.
	 */
	private String nodeName;
	
	
	/**
	 * Is the current node a lead node?
	 */
	private boolean isLeaf = false;
	
	
	@Override
	public final Type<TreeChangeHandler> getAssociatedType() {
		return TYPE;
	}
	
	
	@Override
	protected final void dispatch(final TreeChangeHandler handler) {
		handler.onTreeChange(this);
	}
	
	
	/**
	 * Sets the current node name.
	 * @param currentNode the current node.
	 * @param <M> the node class.
	 * @return the string with the current node name.
	 */
	public final <M> String setCurrentNodeName(final M currentNode) {
		if (currentNode instanceof String) {
			nodeName = (String) currentNode;
		}
		if (currentNode instanceof PrinterModel) {
			nodeName = ((PrinterModel) currentNode).getKey();
		}
		return nodeName;
	}
	
	
	/**
	 * Gets the current node name.
	 * @return the current node name.
	 */
	public final String getCurrentNodeName() {
		return nodeName;
	}
	
	
	/**
	 * Register a new event handler.
	 * @param handler the new event handler.
	 */
	public static void registerHandler(final TreeChangeHandler handler) {
		EVENTBUS.addHandler(TYPE, handler);
	}
	
	
	/**
	 * Sets if the current node is a leaf node.
	 * @param leaf if the current node is a leaf node or not.
	 */
	public final void setLeaf(final boolean leaf) {
		isLeaf = leaf;
	}
	
	
	/**
	 * Gets if the current node is a leaf node.
	 * @return if the current node is a leaf node or not.
	 */
	public final boolean isLeaf() {
		return isLeaf;
	}
	
	
}
