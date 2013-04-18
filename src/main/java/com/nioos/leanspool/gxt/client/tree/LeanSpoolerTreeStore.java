package com.nioos.leanspool.gxt.client.tree;



import com.sencha.gxt.data.shared.TreeStore;



public class LeanSpoolerTreeStore extends TreeStore<String> {
	
	
	public LeanSpoolerTreeStore() {
		super(new LeanSpoolerPrinterModelKeyProvider());
		//
		add("root");
		add("root", "child01");
		add("root", "child02");
		add("root", "child03");
		add("root", "child04");
		add("Printers");
		add("Jobs");
		add("Errors");
	}
	
	
}
