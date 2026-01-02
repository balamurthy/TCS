package SanityTests;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import utils.BaseTest;

public class SelectBoxExample extends BaseTest{
    static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
        // Setup driver
        driver = getDriver();
        driver.manage().window().maximize();

        // Open demo page
        driver.get("https://the-internet.herokuapp.com/dropdown");

        // Locate the dropdown element
        driver.findElement(By.id("dropdown")).click();
        WebElement dropdown = driver.findElement(By.id("dropdown"));

        // Initialize Select class
        Select select = new Select(dropdown);

        // Select by visible text
try {
        select.selectByVisibleText("Option 8");
        System.out.println("✅ Selected Option 8");
        Thread.sleep(1000);
}
catch(NoSuchElementException e) {
		System.out.println("No option 8 available.");
}
        // Select by value attribute
        select.selectByValue("2");
        System.out.println("✅ Selected Option 2");
        Thread.sleep(1000);

        // Select by index (0 = first option, 1 = second, etc.)
        select.selectByIndex(1); // selects Option 1
        System.out.println("✅ Selected Option by index");

        // Print selected option
        WebElement selectedOption = select.getFirstSelectedOption();
        System.out.println("Currently selected: " + selectedOption.getText());
        
        driver.quit();
    }
}