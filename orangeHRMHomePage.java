package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;

public class orangeHRMHomePage {
	WebDriver driver;
	boolean result;
	public orangeHRMHomePage (WebDriver driver) { 
		this.driver=driver;
	}
	
	//Element identification area
	By username = By.name("username");
	By password = By.name("password");
	By loginBtn = By.xpath("//button[@type='submit']");
	
	//methods (Setter and getter) and boolean
	public boolean isUsernameVisible() {
		
		 return (driver.findElement(username).isDisplayed());
		
	}
	
	public Point getLocationOfUsername() 
	{
		return (driver.findElement(username).getLocation());
	}
	
	public void doLogin(String un,String pw) {
		
		driver.findElement(username).sendKeys(un);
		driver.findElement(password).sendKeys(pw);
		driver.findElement(loginBtn).click();
		
	}
	
	public boolean isPasswordMasked() {
		
		if (driver.findElement(password).getAttribute("type") == "password") {
			result = true;
		}
		else
		{
			result = false;
		}
		
		return result;
	}
	
}
