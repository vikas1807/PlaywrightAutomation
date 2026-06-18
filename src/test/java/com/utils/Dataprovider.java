package com.utils;

import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

public class Dataprovider {
    @DataProvider(name = "excelData")
    public Object[][] excelData(Method method) {

        String filePath = System.getProperty("user.dir")+"/src/test/resources/TestData.xlsx";

        return ExcelUtil.getTestData(filePath,"LoginTest");
    }
}
