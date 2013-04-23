package com.nioos.leanspool.gxt.client.tree;



import com.google.gwt.event.shared.GwtEvent;



public class TreeChangeEvent extends GwtEvent<TreeChangeHandler> {
	
	
	public static final Type<TreeChangeHandler> TYPE =
		new Type<TreeChangeHandler>();
	
	
	private String nodeName;
	
	
	@Override
	public Type<TreeChangeHandler> getAssociatedType() {
		return TYPE;
	}
	
	
	@Override
	protected void dispatch(TreeChangeHandler handler) {
		handler.onTreeChange(this);
	}
	
	
	public void setCurrentNodeName(String currentNodeName) {
		nodeName = currentNodeName;
	}
	
	
	public String getCurrentNodeName() {
		return nodeName;
	}
	
	
}
