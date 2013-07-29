package com.nioos.leanspool.gxt.client.tree;



import java.util.List;

import com.nioos.leanspool.gxt.shared.PrinterModel;
import com.sencha.gxt.data.shared.loader.BeforeLoadEvent;
import com.sencha.gxt.data.shared.loader.LoadEvent;
import com.sencha.gxt.data.shared.loader.LoadExceptionEvent;
import com.sencha.gxt.data.shared.loader.LoaderHandler;
import com.sencha.gxt.widget.core.client.box.AutoProgressMessageBox;



/**
 * Printers loader handler.
 * Shows and hides the auto progress message box.
 * @author Hipolito Jimenez.
 */
public class PrintersLoaderHandler implements
		LoaderHandler<PrinterModel, List<PrinterModel>> {
	
	
	/**
	 * The auto progress message box showed on load.
	 */
	private final transient AutoProgressMessageBox autoProgressMessageBox =
		new AutoProgressMessageBox("Retrieving printers");
	
	
	@Override
	public final void onBeforeLoad(final BeforeLoadEvent<PrinterModel> event) {
		autoProgressMessageBox.auto();
		autoProgressMessageBox.show();
	}
	
	
	@Override
	public final void onLoadException(
			final LoadExceptionEvent<PrinterModel> event) {
		autoProgressMessageBox.hide();
	}
	
	
	@Override
	public final void onLoad(final LoadEvent<PrinterModel,
			List<PrinterModel>> event) {
		autoProgressMessageBox.hide();
	}
	
	
}
