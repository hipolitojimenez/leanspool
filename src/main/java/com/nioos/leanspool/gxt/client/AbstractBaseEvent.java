package com.nioos.leanspool.gxt.client;



import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;



/**
 * Base abstract event class.
 * 
 * @author Hipolito Jimenez.
 *
 * @param <H> the base event handler class
 */
public abstract class AbstractBaseEvent<H extends EventHandler>
		extends GwtEvent<H> {
	
	
	/**
	 * The event bus for the events.
	 */
	protected static final EventBus EVENTBUS = new SimpleEventBus();
	
	
	/**
	 * Fire a new event from the given source.
	 * @param source the source of the event.
	 */
	public final void fireFromSource(final Object source) {
		EVENTBUS.fireEventFromSource(this, source);
	}
	
	
}