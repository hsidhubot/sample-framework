package com.hs.config;

import lombok.extern.log4j.Log4j2;
import org.aeonbits.owner.ConfigFactory;

/*
 * Class to make runtime modifications of the properties contained in the Config object.
 * Removes the listed property and then set the property as required and returns the run time value of the 'key' pair
 * @version 1.0
 */

@Log4j2
public class runTimeConfig {

    ConfigurationProperties cfg = ConfigFactory.create(ConfigurationProperties.class);

    public void setEnvironmentProperties(String environment) {
        String env = System.getProperty("env");
        ConfigFactory.setProperty("env", env == null ? environment : env);
        log.info("Environment Properties set to : " + getEnvironment());
    }

    public String getEnvironment() {
        return ConfigFactory.getProperty("env");
    }

    public String getBrowserRunTimeConfiguration() {
        String targetBrowser = System.getProperty("browser");
        //override the 'default' browser value in config file with that provided at run time
        if (targetBrowser != null) {
            cfg.removeProperty("browser");
            cfg.setProperty("browser", System.getProperty("browser"));
        }
        return cfg.browser();
    }

    public String getTargetConfiguration() {
        String targetMachine = System.getProperty("target");
        //override the 'default' TARGET value in config file with that provided at run time
        if (targetMachine != null) {
            cfg.removeProperty("target");
            cfg.setProperty("target", System.getProperty("target"));
        }
        return cfg.target();
    }

    public String getheadlessRunTimeConfiguration() {
        String headlessStatus = System.getProperty("headless");
        //override the 'default' browser i.e false config file with that provided at run time
        if (headlessStatus != null) {
            cfg.removeProperty("headless");
            cfg.setProperty("headless", System.getProperty("headless"));
        }
        return cfg.headless();
    }

    public String getBrowserStackRunTimeEnvironmentConfiguration() {
        String bsRunTimeEnvironment = System.getProperty("bsenvironment");
        //override the 'default' browser i.e false config file with that provided at run time
        if (bsRunTimeEnvironment != null) {
            cfg.removeProperty("browserStackEnvironment");
            cfg.setProperty("browserStackEnvironment", bsRunTimeEnvironment);
        }
        return cfg.browserStackEnvironment();
    }
}
