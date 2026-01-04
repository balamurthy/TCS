package utils;
import java.io.IOException;

// ExtentReportManager.java
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ExtentReportManager {
    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();


    public static ExtentReports getInstance() {
    	
    	//throws java.io.IOException {
        if (extent == null) {
            String reportPath = System.getProperty("user.dir") + "/test-output/ExtentReport.html";
            System.out.println(reportPath);
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
         // Load extent-config.xml from resources
            String configPath = System.getProperty("user.dir") + "/src/test/resources/extent-config.xml";
           System.out.println(configPath);
         //   sparkReporter.loadXMLConfig(configPath);
            
            sparkReporter.config().setReportName("TestNG Automation report");
            sparkReporter.config().setDocumentTitle("Test Results");
            sparkReporter.config().setTheme(Theme.STANDARD);

            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);
            extent.setSystemInfo("Tester", "Bala Murthy");
        }
        return extent;
    }

	public static ExtentTest getTest() {
		return extentTest.get();
	}
}