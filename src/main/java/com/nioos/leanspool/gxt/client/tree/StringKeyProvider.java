package com.nioos.leanspool.gxt.client.tree;



import com.sencha.gxt.data.shared.ModelKeyProvider;



public class StringKeyProvider
		implements ModelKeyProvider<String> {
	
	
	@Override
	public String getKey(String item) {
		return item;
	}
	
	
}
