package com.playwright;

import com.Base.Basesetup;
import com.pages.homePage;
import com.utils.Dataprovider;
import org.testng.annotations.Test;

public class registerNewUsrTest extends Basesetup {

    @Test(dataProvider = "excelData", dataProviderClass = Dataprovider.class)
    public void tst(String email)
    {
       homePage hm = new homePage();
       hm.enterEmailId(email);
    }
    @Test
    public void validateEmailAlreadyexist()
    {
        homePage hm = new homePage();
        hm.validateEmailAlreadExist("test3@zohomail.in");
    }
}
