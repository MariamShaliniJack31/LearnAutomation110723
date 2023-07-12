package SamplePackage;

import java.io.FileInputStream;
import java.util.Properties;
import org.testng.annotations.Test;

public class Example {
	
	public static Properties prop;
	public static FileInputStream fis;
	static String val;
	
	@Test
	public static String property() {
				
		try {
				prop = new Properties();
				fis = new FileInputStream("Config.properties");
				prop.load(fis);
		} catch (Exception e) {
			System.out.println("No File Found " + e.getMessage());
			e.printStackTrace();
		}
		System.out.println(prop.getProperty("browser"));
		val = prop.getProperty("browser");
		return val;
	}
}
