package com.Factory;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;

public class PlaywrightFactory {

    private static final ThreadLocal<Browser> browserThreadLocal = new ThreadLocal<>();
    private static final ThreadLocal<BrowserContext> contextThreadLocal = new ThreadLocal<>();
    private static final ThreadLocal<Page> pageThreadLocal = new ThreadLocal<>();

    // Browser
    public static void setBrowser(Browser browser) {
        browserThreadLocal.set(browser);
    }

    public static Browser getBrowser() {
        return browserThreadLocal.get();
    }

    // Context
    public static void setContext(BrowserContext context) {
        contextThreadLocal.set(context);
    }

    public static BrowserContext getContext() {
        return contextThreadLocal.get();
    }

    // Page
    public static void setPage(Page page) {
        pageThreadLocal.set(page);
    }

    public static Page getPage() {
        return pageThreadLocal.get();
    }

    public static void remove() {
        pageThreadLocal.remove();
        contextThreadLocal.remove();
        browserThreadLocal.remove();
    }
}
