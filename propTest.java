package testNGTests;

import java.util.Properties;

import org.testng.annotations.Test;
import utils.PropertyFileReader;

public class propTest {
  @Test
  public void readpropertyfile() {
	  Properties config = PropertyFileReader.loadProperties();

	  String browser = config.getProperty("browser");
	  String url = config.getProperty("url");

	  System.out.println(browser);
	  System.out.println(url);
  }
}
