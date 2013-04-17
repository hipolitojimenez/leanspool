package com.nioos.leanspool.gxt.client.container;



import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.TreeStore;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer.BorderLayoutData;
import com.sencha.gxt.widget.core.client.container.MarginData;
import com.sencha.gxt.widget.core.client.container.Viewport;
import com.sencha.gxt.widget.core.client.tree.Tree;



public class LeanSpoolerViewport extends Viewport {
	
	
	private static final int INITIAL_WEST_SIZE = 200;
	
	
	public LeanSpoolerViewport() {
		BorderLayoutContainer borderLayoutContainer =
			new BorderLayoutContainer();
		buildWestWidget(borderLayoutContainer);
		buildCenterWidget(borderLayoutContainer);
		add(borderLayoutContainer);
	}
	
	
	private void buildCenterWidget(BorderLayoutContainer borderLayoutContainer) {
		ContentPanel centerWidget = new ContentPanel();
		MarginData centerWidgetLayoutData = new MarginData(1);
		borderLayoutContainer.setCenterWidget(centerWidget,
			centerWidgetLayoutData);
	}
	
	
	private void buildWestWidget(BorderLayoutContainer borderLayoutContainer) {
		BorderLayoutData westWidgetLayoutData =
			new BorderLayoutData(INITIAL_WEST_SIZE);
		westWidgetLayoutData.setCollapsible(true);
		westWidgetLayoutData.setSplit(true);
		westWidgetLayoutData.setCollapseMini(true);
		Margins westMargins = new Margins(1);
		westWidgetLayoutData.setMargins(westMargins);
		//
		ContentPanel westWidget = new ContentPanel();
		//
		ModelKeyProvider<String> keyProvider = new ModelKeyProvider<String>() {
			@Override
			public String getKey(String item) {
				return item;
			}
		};
		TreeStore<String> treeStore = new TreeStore<String>(keyProvider);
		treeStore.add("root");
		treeStore.add("root", "child01");
		treeStore.add("root", "child02");
		treeStore.add("root", "child03");
		treeStore.add("root", "child04");
		//
		ValueProvider<String, String> treeValueProvider = new ValueProvider<String, String>() {
			@Override
			public String getValue(String object) {
				return object;
			}
			@Override
			public void setValue(String object, String value) {
				object = value;
			}
			@Override
			public String getPath() {
				return null;
			}
		};
		Tree<String, String> tree =
			new Tree<String, String>(treeStore, treeValueProvider);
		//
		westWidget.add(tree);
		//
		borderLayoutContainer.setWestWidget(westWidget, westWidgetLayoutData);
	}
	
	
}
