package testNGTests;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utils.BaseTest;

public class homepagetests extends BaseTest {
  static WebDriver driver;
  boolean result;
  
	@BeforeClass
  public void opendriver() {
	  driver = getDriver();
  }
  @Test(enabled=false)
  public void logocheck() {
	  
	  driver.get("file:///E:/BLaptop/TCSRjp/TCSMaterials/logo.html");
	  
	  	  try {
	         driver.findElement(By.xpath("/html/body/table/tbody/tr[1]/td/img"));
	         							 
	         result=true;
	  	  }
	  	  catch (NoSuchElementException e)
	  	  {
	  		  result=false;
	  		  
	  	  }
	  	  Assert.assertTrue(result);
	  }

@Test
public void dollarRatecheck() {
	  
	  driver.get("file:///E:/BLaptop/TCSRjp/TCSMaterials/dollarrate.html");
	  
	  		//Find Dollar text and the rate in the dynamic dom
	  	  try {

	  		  String dollarrate;
	  		  
	  		  dollarrate =driver.findElement(By.xpath("//*[text()=\"Dollar\"]/following-sibling::td[1]")).getText();
	          
	  		  double rate = Double.parseDouble(dollarrate);
	  		  
	  		  if (rate > 80)
	  		  {
	  			System.out.println("Dollar Rate is greater than 80");
	  			  result=true;
	  		  } 
	  		  else
	  		  {
	  			  System.out.println("Dollar Rate is less than 80");
	  			 result = false ; 
	  		  }
	  	  }
	  	  catch (NoSuchElementException e)
	  	  {
	  		  result=false;
	  		  
	  	  }
	  	  
	  //	2. Get the currency name which has overtaken Dollar
	  	  
	  	  String higherCurrency,higherCurrencyRate;
	  	                                  
	  	  higherCurrency=driver.findElement(By.xpath("//*[text()=\"Dollar\"]/parent::tr/preceding-sibling::tr[1]/td[1]")).getText();
	  	  higherCurrencyRate = driver.findElement(By.xpath("//*[text()=\"Dollar\"]/parent::tr/preceding-sibling::tr[1]/td[2]")).getText();
	  	  System.out.println("The currency that has overtaken Dollar is " + higherCurrency + " and the rate is "+ higherCurrencyRate);
	  	  
	  	  
	  	  //4. Which is the highest currency and its rate
	  	  String firstCurrency,firstCurrencyRate;
	  	  firstCurrency=driver.findElement(By.xpath("//table/descendant::tr[1]/td[1]")).getText();
	  	  firstCurrencyRate = driver.findElement(By.xpath("//table/descendant::tr[1]/td[1]/following-sibling::td")).getText();
	  	  
	  	  
	  	  System.out.println("The highest currency is " + firstCurrency  + " and its rate is " + firstCurrencyRate);
	  	  	
	  	  
	  	  Assert.assertTrue(result);
	  }

	

@AfterClass
public void teardown()
{
	driver.close();
}
}