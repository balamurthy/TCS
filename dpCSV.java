package SanityTests;

import org.testng.annotations.DataProvider;

import utils.CSVUtils;



public class dpCSV {
	
	 @DataProvider(name = "csvLoginData")
	    public Object[][] getLoginData() {

	        return CSVUtils.readData(
	            "src/test/resources/testdata.csv"
	        );
	    }  
	  
	  
  }

