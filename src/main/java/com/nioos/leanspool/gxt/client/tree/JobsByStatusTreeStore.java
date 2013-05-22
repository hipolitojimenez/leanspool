package com.nioos.leanspool.gxt.client.tree;



import com.sencha.gxt.data.shared.TreeStore;



/**
 * Jobs by status tree store.
 * 
 * @author Hipolito Jimenez.
 *
 */
public class JobsByStatusTreeStore extends TreeStore<String> {
	
	
	/**
	 * Root node name.
	 */
	private static final String ROOT = "Jobs By Status";
	
	
	/**
	 * Constructor.
	 */
	public JobsByStatusTreeStore() {
		super(new StringKeyProvider());
		//
		add(ROOT);
		//final String pending = "Pending";
		add(ROOT, "Pending");
		//final String completed = "Completed";
		add(ROOT, "Completed");
		//final String failed = "Failed";
		add(ROOT, "Failed");
	}
	
	
}
