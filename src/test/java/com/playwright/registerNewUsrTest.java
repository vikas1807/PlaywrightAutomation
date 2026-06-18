package com.playwright;

import com.Base.Basesetup;
import com.pages.homePage;
import org.testng.annotations.Test;

public class registerNewUsrTest extends Basesetup {

    @Test
    public void tst()
    {
       homePage hm = new homePage();
       hm.enterEmailId("test3@zohomail.in");
    }
    @Test
    public void validateEmailAlreadyexist()
    {
        homePage hm = new homePage();
        hm.validateEmailAlreadExist("test3@zohomail.in");
    }
}
