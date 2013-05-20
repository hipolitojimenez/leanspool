package com.nioos.leanspool.gxt.client.tree;



import com.sencha.gxt.core.client.ValueProvider;



/**
 * Tree string value provider.
 * @author Hipolito Jimenez.
 *
 */
public class StringTreeValueProvider implements
		ValueProvider<String, String> {
	
	
	@Override
	public final String getValue(final String object) {
		return object;
	}
	
	
	@Override
	public void setValue(final String object, final String value) {
		//object = value;
	}
	
	
	@Override
	public final String getPath() {
		return null;
	}
	
	
}
