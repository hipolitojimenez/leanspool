package com.nioos.leanspool.gxt.client.tree;



import com.nioos.leanspool.gxt.shared.Errors;
import com.sencha.gxt.widget.core.client.box.AlertMessageBox;



/**
 * An error dialog that displays an error icon.
 */
public class ErrorDialog extends AlertMessageBox {
	
	
	/**
	 * Constructor.
	 * @param errorCode the error code to be shown in the error dialog.
	 */
	public ErrorDialog(final Errors errorCode) {
		super("Error", null);
		switch (errorCode) {
			case NOERROR:
				//do nothing
				break;
			case GETPRINTERS:
				setMessage("Cannot get printers");
				break;
			default:
				setMessage("Unknown error");
				break;
		}
		if (errorCode != Errors.NOERROR) {
			show();
		}
	}
	
	
}
