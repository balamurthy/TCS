
Place the following code in the TestNG test case class


@AfterMethod
public void aftermethod(ITestResult result) {
    if (ITestResult.FAILURE == result.getStatus()) {
        takeScreenshot(result.getName());
    }
    driver.quit();
}

Extent report - In order to make a TestNG test report to ExtentReport.html under test-output folder, you have to do the following:
place the @Listeners below one line before the class 

@Listeners(TestListener.class)
public class homepagetests extends BaseTest {

Dependencies in the pom.xml

<!-- Extent Reports -->
    <dependency>
        <groupId>com.aventstack</groupId>
        <artifactId>extentreports</artifactId>
        <version>5.1.1</version>
    </dependency>

 
