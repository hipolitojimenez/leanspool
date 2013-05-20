package com.nioos.leanspool.gxt.client.tree;



/**
 * Jobs by status tree.
 * 
 * @author Hipolito Jimenez.
 *
 */
public class JobsByStatusTree extends AbstractBaseTree<String, String> {
	
	
	/**
	 * Constructor.
	 */
	public JobsByStatusTree() {
		super(new JobsByStatusTreeStore(), new StringTreeValueProvider());
		getStyle().setLeafIcon(TreeImages.INSTANCE.status());
	}
	
	
}
