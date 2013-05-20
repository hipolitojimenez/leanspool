package com.nioos.leanspool.gxt.client.tree;



import com.google.gwt.core.shared.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;



/**
 * Images used in the tree widget.
 * @author Hipolito Jimenez.
 *
 */
public interface TreeImages extends ClientBundle {
	
	
	/**
	 * The instance.
	 */
	TreeImages INSTANCE = GWT.create(TreeImages.class);
	
	
	/**
	 * The printer image.
	 * @return the printer image.
	 */
	@Source("printer.png")
	ImageResource printer();
	
	
	/**
	 * The job image.
	 * @return the job image.
	 */
	@Source("job.png")
	ImageResource job();
	
	
	/**
	 * The status image.
	 * @return the status image.
	 */
	@Source("status.png")
	ImageResource status();
	
	
}
