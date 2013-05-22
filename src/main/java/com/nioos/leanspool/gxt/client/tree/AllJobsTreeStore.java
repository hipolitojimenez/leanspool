package com.nioos.leanspool.gxt.client.tree;



import com.sencha.gxt.data.shared.TreeStore;



/**
 * All jobs tree store.
 * 
 * @author Hipolito Jimenez.
 */
public class AllJobsTreeStore extends TreeStore<String> {
	
	
	/**
	 * Constructor.
	 */
	public AllJobsTreeStore() {
		super(new StringKeyProvider());
		//
		add("All Jobs");
	}
	
	
}
