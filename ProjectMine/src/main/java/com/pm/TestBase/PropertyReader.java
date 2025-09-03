package com.pm.TestBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

	private static Properties properties;

	// Static block loads properties file only once
	static {
		try {
			String path = System.getProperty("user.dir") + "/src/main/resources/config.properties";
			File file=new File(path);
			FileInputStream fis = new FileInputStream(file);
			properties = new Properties();
			properties.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("❌ Failed to load config.properties file.");
		}
	}

	// Generic method to fetch property value
	public static String getProperty(String key) {
		String value = properties.getProperty(key);
		if (value == null) {
			throw new RuntimeException("❌ Property '" + key + "' not found in config.properties");
		}
		return value;
	}

}
