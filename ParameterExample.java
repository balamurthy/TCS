package SanityTests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class ParameterExample {
  
	@Parameters("browser")
	@Test
  public void f(String b) {
	  
	  System.out.println("Browser to run tests is:" + b);
	  
  }
}
