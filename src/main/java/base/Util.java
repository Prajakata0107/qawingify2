package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Util {
	public String getValue(String filepath, String Key) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(filepath);
		} catch (FileNotFoundException e) {
			System.out.println("File not Found:" + filepath);
		}

		Properties prop = new Properties();
		try {
			prop.load(file);
		} catch (IOException e) {
			System.out.println("unable to loade properties file:" + filepath);
		}
		return prop.getProperty(Key);
	}

	/**
	 * this method can be used on OR.properties file only
	 * 
	 * @param key for which we want the locator
	 * @return the locator value in the form of {@code String}
	 */
	public String getLocator(String key) {
		String baseDir = System.getProperty("user.dir");
		return getValue(baseDir + "/src/main/resources/Environment.properties", key);

	}
}



