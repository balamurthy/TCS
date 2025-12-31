package SanityTests;

import org.testng.annotations.DataProvider;

import utils.ExcelUtil;

public class dpExcel {

    @DataProvider(name = "loginData")
    public Object[][] loginDataProvider() {
        return ExcelUtil.getExcelData("data");
    }
}
