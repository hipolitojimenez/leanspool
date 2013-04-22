package com.nioos.leanspool.gxt.client.tree;



import com.sencha.gxt.data.shared.TreeStore;



public class JobsByPrinterTreeStore extends TreeStore<PrinterModel> {
	
	
	public JobsByPrinterTreeStore() {
		super(new PrinterModelKeyProvider());
		//
		PrinterModel root = new PrinterModel("Jobs By Printer");
		add(root);
		PrinterModel printer01 = new PrinterModel("printer01");
		add(root, printer01);
		PrinterModel printer02 = new PrinterModel("printer02");
		add(root, printer02);
		PrinterModel printer03 = new PrinterModel("printer03");
		add(root, printer03);
		PrinterModel printer04 = new PrinterModel("printer04");
		add(root, printer04);
	}
	
	
}
