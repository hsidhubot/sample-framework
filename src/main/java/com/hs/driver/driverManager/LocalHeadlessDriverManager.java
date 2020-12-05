/*
 * Author : Harwinder Sidhu
 */

package com.hs.driver.driverManager;

import com.hs.driver.IDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

import static io.github.bonigarcia.wdm.config.DriverManagerType.*;

@Log4j2
public class LocalHeadlessDriverManager implements IDriver {

    @Override
    public WebDriver createInstance(String browser, String target) {
        WebDriver driver = null;
        try {
            driver = getHeadlessDriver(browser);
        } catch (IllegalArgumentException e) {
            log.error("Headless Browser: " + browser + "is not valid or recognized", e);
        }
        return driver;
    }

    private static WebDriver getHeadlessDriver(String browser) {
        log.info("Creating headless driver for Browser ..." + browser);
        WebDriver driver;
        DriverManagerType driverManagerType = DriverManagerType.valueOf(browser.toUpperCase());
        switch (driverManagerType) {
            case CHROME:
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless");
                chromeOptions.addArguments("--disable-gpu");
                WebDriverManager.getInstance(CHROME).setup();
                driver = new ChromeDriver(chromeOptions);
                log.info("CHROME headless webdriver created successfully.");
                break;
            case FIREFOX:
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--headless");
                firefoxOptions.addArguments("--disable-gpu");
                WebDriverManager.getInstance(FIREFOX).setup();
                driver = new FirefoxDriver(firefoxOptions);
                log.info("FIREFOX headless webdriver created successfully.");
                break;
            case OPERA:
                OperaOptions operaOptions = new OperaOptions();
                operaOptions.addArguments("--headless");
                operaOptions.addArguments("--disable-gpu");
                WebDriverManager.getInstance(OPERA).setup();
                driver = new OperaDriver(operaOptions);
                log.info("OPERA headless webdriver created successfully.");
                break;
            case EDGE:
                log.fatal("EDGE headless webdriver setting need to be coded");
            case IEXPLORER:
                log.fatal("IEXPLORER headless webdriver setting need to be coded");
            case PHANTOMJS:
                log.fatal("PHANTOMJS headless webdriver setting need to be coded");
            case SELENIUM_SERVER_STANDALONE:
                log.fatal("Invalid driver Manager Type " + driverManagerType);
                throw new IllegalStateException("Not supported: " + driverManagerType);
            default:
                log.fatal("Unexpected driver Manager Type " + driverManagerType);
                throw new IllegalStateException("Unexpected value: " + driverManagerType);
        }
        log.info("Headless driver created successfully ..");
        return driver;
    }

}
