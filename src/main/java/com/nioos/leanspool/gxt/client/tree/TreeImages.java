package com.nioos.leanspool.gxt.client.tree;



import com.google.gwt.core.shared.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;



public interface TreeImages extends ClientBundle {
	
	
	public static final TreeImages INSTANCE = GWT.create(TreeImages.class);
	
	
	@Source("printer.png")
	ImageResource printer();
	
	
	@Source("job.png")
	ImageResource job();
	
	
	@Source("status.png")
	ImageResource status();
	
	
}
