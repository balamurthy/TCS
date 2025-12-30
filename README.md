
Place the following code in the TestNG test case class


@AfterMethod
public void aftermethod(ITestResult result) {
    if (ITestResult.FAILURE == result.getStatus()) {
        takeScreenshot(result.getName());
    }
    driver.quit();
}
