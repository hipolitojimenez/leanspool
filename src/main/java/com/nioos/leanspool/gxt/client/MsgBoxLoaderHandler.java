package com.nioos.leanspool.gxt.client;



import com.sencha.gxt.data.shared.loader.BeforeLoadEvent;
import com.sencha.gxt.data.shared.loader.LoadEvent;
import com.sencha.gxt.data.shared.loader.LoadExceptionEvent;
import com.sencha.gxt.data.shared.loader.LoaderHandler;
import com.sencha.gxt.widget.core.client.box.AutoProgressMessageBox;



/**
 * Message box loader handler.
 * Shows and hides the auto progress message box.
 * @author Hipolito Jimenez.
 * 
 * @param <C> the type of config to request the data
 * @param <M> the type of data to be loaded
 */
public class MsgBoxLoaderHandler<C, M> implements LoaderHandler<C, M> {
	
	
	/**
	 * The auto progress message box showed on load.
	 */
	private final transient AutoProgressMessageBox autoProgressMessageBox;
	
	
	/**
	 * Constructor.
	 * @param message the message shown in the message box.
	 */
	public MsgBoxLoaderHandler(final String message) {
		autoProgressMessageBox = new AutoProgressMessageBox(message);
	}
	
	
	@Override
	public final void onBeforeLoad(final BeforeLoadEvent<C> event) {
		autoProgressMessageBox.auto();
		autoProgressMessageBox.show();
	}
	
	
	@Override
	public final void onLoadException(final LoadExceptionEvent<C> event) {
		autoProgressMessageBox.hide();
	}
	
	
	@Override
	public final void onLoad(final LoadEvent<C, M> event) {
		autoProgressMessageBox.hide();
	}
	
	
}
