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
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.FileReader;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;

@Log4j2
public class BrowserstackRemoteDriverManager extends BrowserstackLocalInstance implements IDriver {

    @Override
    public WebDriver createInstance(String browserstackEnvironment, String target) {
        RemoteWebDriver remoteWebDriver = null;
        ConfigurationProperties configuration = ConfigCache.getOrCreate(ConfigurationProperties.class);
        String jsonFileName = "browserstack.conf.json";
        String browserstackRunEnviornment = new runTimeConfig().getBrowserStackRunTimeEnvironmentConfiguration();
        try {
            remoteWebDriver = setUpBrowserStack(browserstackEnvironment, jsonFileName);
            log.info("Browserstack environment setup successfull");
        } catch (Exception e) {
            log.error("Error Option 1 - Check in PROPERTIES files !");
            log.error("Error Option 2 - Browserstack URL is invalid or Grid is not available");
            log.error("Error Option 3 - Either another browserstack local client is running on your machine or some server is listening on same port");
            log.error("Error Option 4 - Browser: " + browserstackEnvironment);
            log.error("Error Option 5 - Browser: " + browserstackEnvironment + "is not valid or recognized", e);
        }
        return remoteWebDriver;
    }


    private RemoteWebDriver setUpBrowserStack(String run_environment, String config_file) throws Exception {
        JSONParser parser = new JSONParser();
        JSONObject config = (JSONObject) parser.parse(new FileReader("src/main/resources/json/" + config_file));
        JSONObject envs = (JSONObject) config.get("environments");

        DesiredCapabilities capabilities = new DesiredCapabilities();

        Map<String, String> envCapabilities = (Map<String, String>) envs.get(run_environment);
        Iterator it = envCapabilities.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            capabilities.setCapability(pair.getKey().toString(), pair.getValue().toString());
        }

        Map<String, String> commonCapabilities = (Map<String, String>) config.get("capabilities");
        it = commonCapabilities.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            if (capabilities.getCapability(pair.getKey().toString()) == null) {
                capabilities.setCapability(pair.getKey().toString(), pair.getValue().toString());
            }
        }

        String username = System.getenv("BROWSERSTACK_USERNAME");
        if (username == null) {
            username = (String) config.get("user");
        }

        String accessKey = System.getenv("BROWSERSTACK_ACCESS_KEY");
        if (accessKey == null) {
            accessKey = (String) config.get("key");
        }

        String app = System.getenv("BROWSERSTACK_APP_ID");
        if (app != null && !app.isEmpty()) {
            capabilities.setCapability("app", app);
        }


//        if (capabilities.getCapability("browserstack.local") != null && capabilities.getCapability("browserstack.local") == "true") {
//            loc = new Local();
//            Map<String, String> options = new HashMap<>();
//            options.put("key", accessKey);
//            loc.start(options);
//        }


        return new RemoteWebDriver(new URL("https://" + username + ":" + accessKey + "@" + config.get("server") + "/wd/hub"), capabilities);
    }
}
