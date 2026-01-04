package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;

public class dashboardPage {
	WebDriver driver;
	boolean result;
	
	public dashboardPage (WebDriver driver) { 
		this.driver=driver;
	}
	
	//Element identification area
	By usericon = By.xpath("//span[contains(@class,\"userdropdown\")]");
	By logoutlink = By.linkText("Logout");
	
	public boolean isLoginSuccessful() {
		
		try {
			driver.findElement(usericon).click();
			
			result=true;
			
			driver.findElement(logoutlink).click();
		}
		catch(NoSuchElementException e) {
			result = false;
			
		}
		
		return result;
		    
		
	}
	
		
}
