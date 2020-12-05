
package com.hs.driver.driverManager;

import com.hs.config.runTimeConfig;
import com.hs.driver.IDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;

@Log4j2
public class LocalDriverManager implements IDriver {

    @Override
    public WebDriver createInstance(String browser, String target) {
        WebDriver driver = null;
        boolean isBrowserHeadless = Boolean.parseBoolean(new runTimeConfig().getheadlessRunTimeConfiguration());

        try {
            if (isBrowserHeadless) {
                driver = new LocalHeadlessDriverManager().createInstance(browser, target);
                log.info("Using Headless driver for browser : " + browser);
            } else {
//              This helps you to create a browser instance without explicitly defining the browser class.
                DriverManagerType driverManagerType = DriverManagerType.valueOf(browser.toUpperCase());
                Class<?> driverClass = Class.forName(driverManagerType.browserClass());
                WebDriverManager.getInstance(driverManagerType).setup();
                driver = (WebDriver) driverClass.newInstance();
                driver.manage().window().maximize();
                log.info("Using browser : " + browser);
            }
        } catch (IllegalAccessException | ClassNotFoundException e) {
            log.fatal("LocalDriverManager could not be created. Please Check !");
            log.error("The class could not be found", e);
        } catch (InstantiationException e) {
            log.fatal("Problem during driver instantiation", e);
        }
        return driver;
    }

}
