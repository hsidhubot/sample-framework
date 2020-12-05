package com.hs.driver;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;

// Extended to access protected method 'quitBrowserstackLocal Instance' in BASE RUNNER class
@Log4j2
public class BaseWebDriver extends BrowserstackLocalInstance {

    private static ThreadLocal<WebDriver> dr = new ThreadLocal<>();

    protected static void setupWebDriver(String browser, String browserstackEnvironment) {
        WebDriver driver = new WebDriverFactory().create(browser, browserstackEnvironment);
        setWebdriver(driver);
        log.info("Webdriver Setup Complete");
    }

    public static void setWebdriver(WebDriver driver) {
        dr.set(driver);
    }

    public static WebDriver getWebdriver() {
        return dr.get();
    }

    protected static void quitBrowser() {
        getWebdriver().quit();
        log.info("Webdriver Setup Exited Successfully");
        dr.set(null);
    }
}
