package com.nioos.leanspool.printer;



import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;



//TODO move to own package
public class DataSourceUtils {
	
	
	public static DataSource buildDataSource(String propertiesFile) throws Exception {
		Properties dataSourceProperties =
			getDataSourceProperties(propertiesFile);
		return BasicDataSourceFactory.createDataSource(dataSourceProperties);
	}
	
	
	private static Properties getDataSourceProperties(String propertiesFile)
			throws IOException {
		Properties properties = new Properties();
		InputStream inputStream =
			DataSourceUtils.class.getResourceAsStream(propertiesFile);
		properties.load(inputStream);
		return properties;
	}
	
	
}
