package com.nioos.leanspool.printer;



public class PrintersException extends Exception {
	
	
	private static final long serialVersionUID = -2556322505879507097L;
	
	
	public PrintersException() {
		//
	}
	
	
	public PrintersException(String message) {
		super(message);
	}
	
	
	public PrintersException(Throwable cause) {
		super(cause);
	}
	
	
	public PrintersException(String message, Throwable cause) {
		super(message, cause);
	}
	
	
}
