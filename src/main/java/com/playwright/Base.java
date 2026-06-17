package com.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class Base {

    Playwright playwright;
    @Test
    public void Setup() throws IOException {
        Configfilereader cfr = new Configfilereader();
        playwright = Playwright.create();
        Page page = null;
        if (cfr.getBrowser().equalsIgnoreCase("chrome"))
        {
            Browser chrome = playwright.chromium().launch(new BrowserType.LaunchOptions().setSlowMo(2000).setHeadless(false));
             page = chrome.newPage();


        }
        else if (cfr.getBrowser().equalsIgnoreCase("firefox"))
        {
            Browser firefox = playwright.firefox().launch(new BrowserType.LaunchOptions().setSlowMo(2000).setHeadless(false));
            page = firefox.newPage();
        }
        else if (cfr.getBrowser().equalsIgnoreCase("edge"))
        {
            Browser edge = playwright.webkit().launch(new BrowserType.LaunchOptions().setSlowMo(2000).setHeadless(false));
            page = edge.newPage();
        }else {
            System.out.println("Browser not found");
        }
        page.navigate(cfr.getURL());
    }
}
