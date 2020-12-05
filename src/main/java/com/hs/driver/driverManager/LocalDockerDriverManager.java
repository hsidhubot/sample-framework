/*
 * Author : Harwinder Sidhu
 */

package com.hs.driver.driverManager;

import com.hs.controller.ConfigRunSetup;
import com.hs.driver.IDriver;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

@Log4j2
public class LocalDockerDriverManager implements IDriver {
    RemoteWebDriver remoteWebDriver = null;

    @Override
    public WebDriver createInstance(String browser, String target) {
        String baseUrl = null;
        if (SystemUtils.IS_OS_MAC) {
            baseUrl = new ConfigRunSetup().getBaseUrlForDocker();
        } else if (SystemUtils.IS_OS_WINDOWS) {
            baseUrl = new ConfigRunSetup().getBaseUrlForDockerWindows();
        }

        try {
            return setupDocker(browser, baseUrl);
        } catch (Exception e) {
            log.error("DOCKER URL is invalid or Grid is not available");
        }
        return remoteWebDriver;
    }


    private RemoteWebDriver setupDocker(String browser, String baseUrl) throws Exception {
        DesiredCapabilities cap = null;
        switch (browser.toLowerCase()) {
            case "chrome":
                cap = DesiredCapabilities.chrome();
                cap.setCapability("version", "");
                cap.setPlatform(Platform.LINUX);
                break;
            case "firefox":
                cap = DesiredCapabilities.firefox();
                cap.setCapability("version", "");
                cap.setPlatform(Platform.LINUX);
                break;
            case "edge":
                cap = DesiredCapabilities.edge();
                cap.setCapability("version", "");
//                cap.setCapability("os","Windows");
//                cap.setCapability("os_version","10");
                cap.setCapability("browser","Edge");
                cap.setCapability("browser_version","15");
                cap.setCapability("resolution","1024x768");
                cap.setPlatform(Platform.LINUX);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + browser.toLowerCase());
        }
        remoteWebDriver = new RemoteWebDriver((new URL(baseUrl + "/wd/hub")), cap);
        log.info("Local Docker Setup Complete - "+remoteWebDriver.getTitle());
        return remoteWebDriver;
    }
}
