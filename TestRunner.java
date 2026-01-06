package MyRunner;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.TestNGCucumberRunner;



@SuppressWarnings("deprecation")
@CucumberOptions(
        features = "src/test/resources/Features/Search.feature",
        glue = "stepDefinitions",
        tags = "@Smoketest",
        plugin = {
                "pretty",
                "summary",
                "html:target/cucumber-reports/cucumber-pretty/CucumberHTMLReport.html",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "rerun:target/cucumber-reports/rerun.txt"
        		},
        monochrome=true,
        dryRun=false
        
        )
public class TestRunner extends AbstractTestNGCucumberTests {
  
}