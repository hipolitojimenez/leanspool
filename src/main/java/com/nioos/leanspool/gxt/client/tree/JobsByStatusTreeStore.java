package com.nioos.leanspool.gxt.client.tree;



import com.sencha.gxt.data.shared.TreeStore;



public class JobsByStatusTreeStore extends TreeStore<String> {
	
	
	public JobsByStatusTreeStore() {
		super(new StringKeyProvider());
		//
		String root = "Jobs By Status";
		add(root);
		String pending = "Pending";
		add(root, pending);
		String completed = "Completed";
		add(root, completed);
		String failed = "Failed";
		add(root, failed);
	}
	
	
}
