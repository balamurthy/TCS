package SanityTests;

 
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
 
public class Actions_hover {
 
 public static WebDriver driver;
 
 public static void main(String[] args) throws InterruptedException {
	 
	    driver=utils.BaseTest.getDriver();
	    
	    
	 // Launch the URL 
        driver.get("https://ebay.com");
        
     driver.manage().window().maximize();
	    
	//Instantiate Action Class        
        
		Actions actions = new Actions(driver);
        //Retrieve WebElement 'Main Item 2' to perform mouse hover 
    	WebElement menuOption = driver.findElement(By.linkText("Electronics"));
    	
    	//Mouse hover menuOption Electronics
    	actions.moveToElement(menuOption).perform();
    	
    	System.out.println("Done Mouse hover on 'Smart watch' from Menu");
    	//Not a good practice. Remove when done practising.
    	Thread.sleep(1000);
    	//Now Select 'Apple' from sub menu which has got displayed on mouse hover of 'Music'
    	WebElement subMenuOption = driver.findElement(By.linkText("Smart watches")); 
    	//Mouse hover menuOption Smart watches
    	actions.moveToElement(subMenuOption).perform();
    	System.out.println("Done Mouse hover on 'Smart watch' from Electronics");
    	
    	WebElement srch = driver.findElement(By.xpath("//input[@Title='Search']"));
    	
    	new Actions(driver)
        .sendKeys(srch, "Selenium!")
        .sendKeys(Keys.ARROW_LEFT)
        .keyDown(Keys.SHIFT)
        .sendKeys(Keys.ARROW_UP)
        .keyUp(Keys.SHIFT)
        .keyUp(Keys.CONTROL)
        .sendKeys("xvv")
        .perform();
    	
        // Close the main window 
    	driver.close();
 }
 
}
 
