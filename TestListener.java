package utils;
// TestListener.java
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

public class TestListener implements ITestListener {
    private static ExtentReports extent = ExtentReportManager.getInstance();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
    	String username = (String) result.getAttribute("username");
        String password = (String) result.getAttribute("password");

    	test.get().pass("Login Test Passed for " + username + " & " +password);
        
    }

    @Override
    public void onTestFailure(ITestResult result) {
           	
    //	test.get().fail(result.getThrowable());
    	
    	// Read attributes set from test
        String username = (String) result.getAttribute("username");
        String password = (String) result.getAttribute("password");

        // Safety (null check)
        if (username == null) username = "NA";
        if (password == null) password = "NA";
        
    	BaseTest base = (BaseTest) result.getInstance();
        String screenshotPath =
            base.takeScreenshot(result.getMethod().getMethodName()+ "_"+ username+"_"+password);
        
        test.get().fail(result.getThrowable(),
            MediaEntityBuilder
                .createScreenCaptureFromPath(screenshotPath)
                .build()
        		
        		);
        
        test.get().fail("Login Test Failed for " + username  + " & " +  password);
        
    	System.out.println("Method :" + result.getMethod().getMethodName() + " failed");
    	System.out.println("From listener Screenshot on failure available at " + screenshotPath);
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}