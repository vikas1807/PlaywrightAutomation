package com.pages;

import com.Factory.PlaywrightFactory;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.testng.Assert;

public class homePage {

    protected static final String trialBtn = "Start a FREE TRIAL";
    protected static final String email = "#page-v1-step1-email";
    protected static final String checkBox = "#page-free-trial-step1-cu-gdpr-consent-checkbox";
    protected static final String createactBtn = "Create a Free Trial Account";
    protected static final String firstName = "#page-v1-fname";
    protected static final String lastName = "#page-v1-lname";
    protected static final String phNumber = "#page-v1-pnumber";
    protected static final String ActBtn = "Create Account";
    protected static final String continueBtn = "skip & continue to app";
    protected static final String loadActTxt = "Set Up Your Account";

    Page page;

    public homePage()
    {
        this.page = PlaywrightFactory.getPage();
    }

    public void enterEmailId(String email1)
    {
        Page window = PlaywrightFactory.getContext().waitForPage(()->{
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(trialBtn)).click();
        });
        window.waitForLoadState();
        window.locator(email).fill(email1);
        window.locator(checkBox).check();
        window.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(createactBtn)).click();
        window.locator(firstName).fill("testFirst");
        window.locator(lastName).fill("testLast");
        window.locator(phNumber).clear();
        window.locator(phNumber).fill("1234567890");
        window.getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName(ActBtn)).click();
        window.getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName(continueBtn)).click();
        String text = window.getByText(loadActTxt).textContent();
        Assert.assertEquals(text.trim(),"Set Up Your Account");
    }
}
