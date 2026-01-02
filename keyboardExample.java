package SanityTests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class keyboardExample {
	 public static WebDriver driver;
	 
	 public static void main(String[] args) throws InterruptedException {
		 
		    driver=utils.BaseTest.getDriver();
		    	    
		 // Launch the URL 
	        driver.get("https://ebay.com");
	        WebElement srchbox = driver.findElement(By.xpath("//input[@Title='Search']"));
	        
	        
	        
	}

}
