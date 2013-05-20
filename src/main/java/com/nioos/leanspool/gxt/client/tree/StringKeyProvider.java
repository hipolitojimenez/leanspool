package com.nioos.leanspool.gxt.client.tree;



import com.sencha.gxt.data.shared.ModelKeyProvider;



/**
 * Tree string key provider.
 * @author Hipolito Jimenez.
 *
 */
public class StringKeyProvider
		implements ModelKeyProvider<String> {
	
	
	@Override
	public final String getKey(final String item) {
		return item;
	}
	
	
}
