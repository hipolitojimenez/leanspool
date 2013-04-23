package com.nioos.leanspool.gxt.client;



import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;



public abstract class AbstractBaseEvent<H extends EventHandler> extends GwtEvent<H> {
	
	
	protected static final EventBus EVENTBUS = new SimpleEventBus();
	
	
	public void fireFromSource(Object source) {
		EVENTBUS.fireEventFromSource(this, source);
	}
	
	
}