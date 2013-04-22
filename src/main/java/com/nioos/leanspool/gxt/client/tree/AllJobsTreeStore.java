package com.nioos.leanspool.gxt.client.tree;



import com.sencha.gxt.data.shared.TreeStore;



public class AllJobsTreeStore extends TreeStore<String> {
	
	
	public AllJobsTreeStore() {
		super(new StringKeyProvider());
		//
		String root = "All Jobs";
		add(root);
	}
	
	
}
