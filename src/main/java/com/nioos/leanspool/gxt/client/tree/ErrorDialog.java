package com.nioos.leanspool.gxt.client.tree;



import com.nioos.leanspool.gxt.shared.Errors;
import com.sencha.gxt.widget.core.client.box.AlertMessageBox;



public class ErrorDialog extends AlertMessageBox {
	
	
	public ErrorDialog(Errors errorCode) {
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
