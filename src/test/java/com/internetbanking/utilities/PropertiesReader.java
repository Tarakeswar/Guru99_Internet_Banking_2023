package com.internetbanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;

public class PropertiesReader {

	private static PropertiesReader propReader;

	private Properties properties;

	public PropertiesReader() {
		properties = loadProperties();
	}

	private Properties loadProperties() {
		File file = new File("./src/test/resources/Configurations/config.properties");
		FileInputStream fileInput = null;
		Properties props = new Properties();
		try {
			fileInput = new FileInputStream(file);
			props.load(fileInput);
			fileInput.close();
		} catch (FileNotFoundException e) {
			System.out.println("config.properties file is missing or corrupted : " + e.getMessage());
		} catch (IOException e) {
			System.out.println("read failed due to " + e.getMessage());
		}
		return props;

	}

	public static PropertiesReader getInstance() {
		if (propReader == null) {
			propReader = new PropertiesReader();
		}
		return propReader;
	}
	
	public String getProperty(String key)
	{
		return properties.getProperty(key);
	}
	public boolean hasProperty(String key)
	{
		return StringUtils.isNotBlank(properties.getProperty(key));
	}

}
