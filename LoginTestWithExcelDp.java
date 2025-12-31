package testNGTests;
import org.testng.annotations.Test;

import SanityTests.dpExcel;
import SanityTests.loginUtil;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LoginTestWithExcelDp {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/login");
    }

    @Test(dataProvider = "loginData",
          dataProviderClass = dpExcel.class)
    public void loginTest(String username, String password) {

    	boolean success = loginUtil.login(username, password);
        
    	Assert.assertEquals(success,true);
         }
}
