package com.nioos.leanspool.gxt.client.tree;

import com.nioos.leanspool.gxt.client.AbstractBaseEvent;



public class TreeChangeEvent extends AbstractBaseEvent<TreeChangeHandler> {
	
	
	private static final Type<TreeChangeHandler> TYPE =
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
	
	
	public <M> String setCurrentNodeName(M currentNodeName) {
		if (currentNodeName instanceof String) {
			nodeName = (String) currentNodeName;
		}
		if (currentNodeName instanceof PrinterModel) {
			nodeName = ((PrinterModel) currentNodeName).getKey();
		}
		return nodeName;
	}
	
	
	public String getCurrentNodeName() {
		return nodeName;
	}
	
	
	public static void registerHandler(TreeChangeHandler handler) {
		EVENTBUS.addHandler(TYPE, handler);
	}
	
	
}
