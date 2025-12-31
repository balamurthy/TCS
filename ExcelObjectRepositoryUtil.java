package utils;
import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.By;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

public class ExcelObjectRepositoryUtil {

    private static Map<String, By> locatorMap = new HashMap<>();

    public static void loadExcel() {

        try {
            FileInputStream fis = new FileInputStream(
                System.getProperty("user.dir")
                + "/src/test/resources/ObjRepo.xlsx"
            );

            Workbook workbook = WorkbookFactory.create(fis);
            Sheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {

                if (row.getRowNum() == 0) continue; // skip header

                String elementName = row.getCell(0).getStringCellValue();
                String locatorType = row.getCell(1).getStringCellValue();
                String locatorValue = row.getCell(2).getStringCellValue();

                By by = getBy(locatorType, locatorValue);
                locatorMap.put(elementName, by);
            }
            workbook.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static By getBy(String type, String value) {
    	System.out.println(value);
    	
        switch (type.toLowerCase().trim()) {
            case "id": return By.id(value);
            case "name": return By.name(value);
            case "xpath": return By.xpath(value);
            case "cssSelector": return By.cssSelector(value);
            case "classname": return By.className(value);
            case "linktext": return By.linkText(value);
            case "partialLinkText": return By.partialLinkText(value);
            default:
                throw new RuntimeException("Invalid locator type: " + type);
        }
    }

    public static By getLocator(String elementName) {
        return locatorMap.get(elementName);
    }
}
