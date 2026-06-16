package com.playwright;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class BaseTest {
    @Test
    public void setup() {
        try {
            Playwright playwright = Playwright.create();
            {
                Browser brws = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(true).setArgs(Arrays.asList("--start-maximized")).setSlowMo(3000));
                Browser.NewContextOptions contextOptions = new Browser.NewContextOptions()
                        .setViewportSize(1920, 1080);
                BrowserContext context = brws.newContext(contextOptions);
                Page page = context.newPage();
                page.navigate("https://app.vwo.com/#/login");
                Page newWindow = context.waitForPage(()->{
                    page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Start a FREE TRIAL")).click();
                });

                newWindow.waitForLoadState();
                newWindow.locator("#page-v1-step1-email").fill("vikasrathod1807@zohomail.in");
                newWindow.locator("#page-free-trial-step1-cu-gdpr-consent-checkbox").check();

                //Page newWindow1 = context.waitForPage(()->{
                    newWindow.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Create a Free Trial Account")).click();
                    String error = newWindow.getByText("An account with this email already exists. ").textContent();
                    //String[] splittext = error.split("\\.");
                    //String errorText = splittext[0]+".";
                    Assert.assertEquals(error.trim(),"An account with this email already exists.");
                   // System.out.println(error);
               // });

               // newWindow1.waitForLoadState();
                newWindow.locator("#page-v1-fname").fill("testFirst");
                newWindow.locator("#page-v1-lname").fill("testLast");
                newWindow.locator("#page-v1-pnumber").clear();
                newWindow.locator("#page-v1-pnumber").fill("1234567890");
                newWindow.getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName("Create Account")).click();

                System.out.println(page.title());
                //newWindow1.close();
                newWindow.close();
                context.close();
                brws.close();
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
