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
        test.get().pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
           	
    //	test.get().fail(result.getThrowable());
    	BaseTest base = (BaseTest) result.getInstance();
        String screenshotPath =
            base.takeScreenshot(result.getMethod().getMethodName());
        
        test.get().fail(result.getThrowable(),
            MediaEntityBuilder
                .createScreenCaptureFromPath(screenshotPath)
                .build()
        		
        		);
    	System.out.println("Method :" + result.getMethod().getMethodName() + " failed");
    	System.out.println("From listener Screenshot on failure available at " + screenshotPath);
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}