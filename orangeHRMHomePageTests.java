package testNGTests;

import org.openqa.selenium.Point;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;



import Pages.dashboardPage;
import Pages.orangeHRMHomePage;
import SanityTests.dpCSV;
import utils.BaseTest;
import utils.TestListener;
@Listeners(TestListener.class)

public class orangeHRMHomePageTests extends BaseTest {
	
	static WebDriver driver;
	
	orangeHRMHomePage oh ;
	dashboardPage dpage;
	boolean result;
	
	@BeforeClass
	public void init() {
		driver= getDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		oh = new orangeHRMHomePage(driver);
	
	
	}
  
	@Test
  public void isUsernameVisibleTest() {
		
		result = oh.isUsernameVisible();
		
		Assert.assertTrue(result);
	}
	
	@Test
	public void isUsernamePositionSameTest() {
		
		Point p = oh.getLocationOfUsername();
		//X:312 Y:294
		int x = p.getX();
		int y = p.getY();
		
		if (x >300 && y <300 )
		{
			result = true;
		}
		else { 
			result = false; 
		
		}
		System.out.println("CurrentX:" + p.getX() + " CurrentY:" +p.getY());
			
		Assert.assertEquals(result, true);
		
	}
	
	@Test (enabled=false)
	public void isPasswordMaskedTest () {
		
		result = oh.isPasswordMasked();
		Assert.assertEquals(result, true);
	}
	
	@Test(dependsOnMethods={"isUsernamePositionSameTest","isUsernameVisibleTest"},
			dataProvider = "csvLoginData",
	        dataProviderClass = dpCSV.class
	      )
	public void isLoginSuccessful (String un,String pw) {
		
		 ITestResult tresult = Reporter.getCurrentTestResult();
		 
		 // Store values for listener
	    tresult.setAttribute("username", un);
	    tresult.setAttribute("password", pw);
		
		oh.doLogin(un, pw);
		
		
		dpage = new dashboardPage(driver);
		
		result = dpage.isLoginSuccessful();
		
		Assert.assertEquals(result, true);
		
		//if login failed, refresh the page as the error message is shown in the login page itself.
		// Reset the context for the next set of data to be entered in username password boxes
		//if login succeeded, logout link click is done in dashboardPage.java
		if(result==false)
		{
			
			driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
				
		}
		
	}
	
	@AfterTest
	public void teardown() {
		driver.close();
	}
	
}
