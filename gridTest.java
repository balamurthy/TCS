package SanityTests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class gridTest {
	WebDriver driver;
	
	@Test
	public void gridTestMethodChrome()
	 {
		// TODO Auto-generated method stub

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setBrowserName("chrome");

		try {
			driver = new RemoteWebDriver(new URL("http://localhost:4444"),caps);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.get("https://example.com");
		System.out.println(driver.getTitle());
		driver.quit();

		
		
	}

}
