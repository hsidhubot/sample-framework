/*
 * Author : Harwinder Sidhu
 */

package com.hs.driver.driverManager;

import com.hs.config.ConfigurationProperties;
import com.hs.config.runTimeConfig;
import com.hs.driver.BrowserstackLocalInstance;
import com.hs.driver.IDriver;
import lombok.extern.log4j.Log4j2;
import org.aeonbits.owner.ConfigCache;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

@Log4j2
public class CrossBrowserDriverManager extends BrowserstackLocalInstance implements IDriver {

    @Override
    public WebDriver createInstance(String browserstackEnvironment, String target) {
        RemoteWebDriver remoteWebDriver = null;
        ConfigurationProperties configuration = ConfigCache.getOrCreate(ConfigurationProperties.class);
        String jsonFileName = "crossbrowser.conf.json";
        String browserstackRunEnviornment = new runTimeConfig().getBrowserStackRunTimeEnvironmentConfiguration();
        try {
            remoteWebDriver = setUpBrowserStack(browserstackEnvironment, jsonFileName);
        } catch (Exception e) {
            log.fatal(e);
            log.error("Error Option 1 - Check in PROPERTIES files !");
            log.error("Error Option 2 - Browserstack URL is invalid or Grid is not available");
            log.error("Error Option 3 - Either another browserstack local client is running on your machine or some server is listening on same port");
            log.error("Error Option 4 - Browser: " + browserstackEnvironment);
            log.error("Error Option 5 - Browser: " + browserstackEnvironment + "is not valid or recognized", e);
        }
        return remoteWebDriver;
    }

    private RemoteWebDriver setUpBrowserStack(String run_environment, String config_file) throws Exception {
//        JSONParser parser = new JSONParser();
//        JSONObject config = (JSONObject) parser.parse(new FileReader("src/main/resources/json/" + config_file));
//
//        DesiredCapabilities caps = new DesiredCapabilities();
//        HashMap<String, String> cbtoptions = new HashMap<String, String>();
//        cbtoptions.put("screenResolution", "1366x768");
//        cbtoptions.put("record_video", "true");
//
//        caps.setCapability("browserName", "Chrome");
//        caps.setCapability("browserVersion", "80x64");
//        caps.setCapability("platformName", "Mac OSX 10.15");
//        caps.setCapability("cbt:options", cbtoptions);
//
//
//        String username = System.getenv("CROSSBROWSER_USERNAME");
//        if (username == null) {
//            username = (String) config.get("user");
//        }
//
//        String authkey = System.getenv("CROWSERBROWSER_ACCESS_KEY");
//        if (authkey == null) {
//            authkey = (String) config.get("key");
//        }
//
//        RemoteWebDriver driver = new RemoteWebDriver(new URL("http://" + username + ":" + authkey + "@hub.crossbrowsertesting.com:80/wd/hub"), caps);
//        return driver;

        String username = "harwinder.sidhu%40valtech.com"; // Your username
        String authkey = "uaa6e015a4fe0c90";  // Your authkey

        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("name", "Taylor Wimpey Tests");
        caps.setCapability("build", "1.0");
        caps.setCapability("browserName", "Chrome");
        caps.setCapability("version", "72");
        caps.setCapability("platform", "Windows 10");
        caps.setCapability("screenResolution", "1366x768");
        caps.setCapability("record_video", "true");
        caps.setCapability("record_network", "false");


        RemoteWebDriver driver = new RemoteWebDriver(new URL("http://" + username + ":" + authkey + "@hub.crossbrowsertesting.com:80/wd/hub"), caps);
        log.info("Session ID : " + driver.getSessionId());
        return driver;
    }
}
