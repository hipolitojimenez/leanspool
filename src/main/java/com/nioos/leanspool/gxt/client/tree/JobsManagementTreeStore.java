package com.nioos.leanspool.gxt.client.tree;



import com.sencha.gxt.data.shared.TreeStore;



public class JobsManagementTreeStore extends TreeStore<PrinterModel> {
	
	
	public JobsManagementTreeStore() {
		super(new LeanSpoolerPrinterModelKeyProvider());
		//
		PrinterModel root = new PrinterModel("root");
		add(root);
		PrinterModel child01 = new PrinterModel("child01");
		add(root, child01);
		PrinterModel child02 = new PrinterModel("child02");
		add(root, child02);
		PrinterModel child03 = new PrinterModel("child03");
		add(root, child03);
		PrinterModel child04 = new PrinterModel("child04");
		add(root, child04);
		PrinterModel printers = new PrinterModel("Printers");
		add(printers);
		PrinterModel jobs = new PrinterModel("Jobs");
		add(jobs);
		PrinterModel errors = new PrinterModel("Errors");
		add(errors);
	}
	
	
}
