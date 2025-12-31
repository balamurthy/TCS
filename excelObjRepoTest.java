package testNGTests;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import utils.BaseTest;
import utils.ExcelObjectRepositoryUtil;

public class excelObjRepoTest extends BaseTest{
	static WebDriver driver;
@Test
  public void loginUsingObjRepo() {
	    //place this line inside @BeforeSuite when running from testng xml suite
		ExcelObjectRepositoryUtil.loadExcel();
	    
		driver=	getDriver();
		driver.get("https://the-internet.herokuapp.com/login");
		
		
		driver.findElement(
			    ExcelObjectRepositoryUtil.getLocator("username")
			).sendKeys("tomsmith");

			driver.findElement(
			    ExcelObjectRepositoryUtil.getLocator("password")
			).sendKeys("SuperSecretPassword!");

			driver.findElement(
			    ExcelObjectRepositoryUtil.getLocator("loginBtn")
			).click();
			
			try {
				driver.findElement(
					    ExcelObjectRepositoryUtil.getLocator("logoutBtn")
					).click();
				
			}
			catch(NoSuchElementException e)
			{
				System.out.println("Login failed");
			}
  }
}
