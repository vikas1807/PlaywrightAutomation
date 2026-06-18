package com.Base;

import com.Factory.PlaywrightFactory;
import com.microsoft.playwright.*;
import com.playwright.Configfilereader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Basesetup {

    Playwright playwright;
    @BeforeMethod
    public void setup() throws Exception {

        Configfilereader cfr = new Configfilereader();

        playwright = Playwright.create();
        Browser browser = playwright.chromium()
                .launch(new BrowserType.LaunchOptions()
                        .setHeadless(true));

        BrowserContext context = browser.newContext();

        Page page = context.newPage();

        PlaywrightFactory.setBrowser(browser);
        PlaywrightFactory.setContext(context);
        PlaywrightFactory.setPage(page);

        page.navigate(cfr.getURL());
    }

    @AfterMethod
    public void tearDown() {

        PlaywrightFactory.getPage().close();
        PlaywrightFactory.getContext().close();
        PlaywrightFactory.getBrowser().close();

        PlaywrightFactory.remove();

        playwright.close();
    }
}
