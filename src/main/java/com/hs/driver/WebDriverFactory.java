package com.hs.driver;

import com.hs.config.runTimeConfig;
import com.hs.driver.driverManager.BrowserstackRemoteDriverManager;
import com.hs.driver.driverManager.CrossBrowserDriverManager;
import com.hs.driver.driverManager.LocalDockerDriverManager;
import com.hs.driver.driverManager.LocalDriverManager;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;

@Log4j2
class WebDriverFactory {
    WebDriver create(String browser, String browserstackEnvironment) {
        log.info("Value selected for TARGET in Properties files -" + new runTimeConfig().getTargetConfiguration().toUpperCase());
        Target target = Target.valueOf(new runTimeConfig().getTargetConfiguration().toUpperCase());
        WebDriver webdriver;
        switch (target) {
            case LOCALMACHINE:
            case LOCAL:
                webdriver = new LocalDriverManager().createInstance(browser, String.valueOf(target));
                log.info("Target - LOCAL Webdriver - setup successful");
                break;
            case BROWSERSTACK:
                webdriver = new BrowserstackRemoteDriverManager().createInstance(browserstackEnvironment, String.valueOf(target));
                log.info("Target - BROWSERSTACK Remote Webdriver- setup successful");
                break;
            case CROSSBROWSER:
                webdriver = new CrossBrowserDriverManager().createInstance(browserstackEnvironment, String.valueOf(target));
                log.info("Target - CROSSBROWSER Webdriver- setup successful");
                break;
            case DOCKER:
                webdriver = new LocalDockerDriverManager().createInstance(browser, String.valueOf(target));
                log.info("Target - DOCKER Webdriver- setup successful");
                break;
            default:
                log.fatal("Unexpected value in the target. Please check properties file" + target);
                log.error("Current Value of TARGET - " + target);
                throw new IllegalStateException("Not one of the required ENUMS listed for TARGET : " + target);
        }
        return webdriver;
    }

    enum Target {
        LOCALMACHINE, BROWSERSTACK, DOCKER, LOCAL, CROSSBROWSER
    }
}
