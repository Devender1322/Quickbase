package utilitise;

import java.io.FileInputStream;
import java.util.Properties;

import Report.HtmlRoport;

public class Readconfig extends HtmlRoport
{
	Properties properties;
	String path = "D:\\EclipseFiles\\Quickbase\\Configuration\\config.properties";
	
	
	public Readconfig() {
		properties = new Properties();
		FileInputStream fis;
		try {
			fis = new FileInputStream(path);
			properties.load(fis);
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	public String getbaseUrl() {
		String value = properties.getProperty("BaseUrl");
		if (value != null) {
			return value;

		} else {
			throw new RuntimeException("URL is not specified in config file");

		}

	}

	public String getBrowser() {
		String value = properties.getProperty("browser");
		if (value != null) {
			return value;

		} else {
			throw new RuntimeException("Browser is not specified in config file");

		}

	}

}
