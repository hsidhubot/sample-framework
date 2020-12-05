package com.hs.controller;

import com.hs.config.ConfigurationProperties;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.aeonbits.owner.ConfigCache;

@Data
@Log4j2
public class ConfigRunSetup {

    private static ThreadLocal<ConfigRunSetup> baseContext = new ThreadLocal<>();

    private String target;
    private String headless;
    private String environment;
    private String browserStackRunEnvironment;
    private String baseUrl;
    private String baseUrlForJobs;
    private String baseUrlForCorporate;
    private String baseUrlHaveYourSay;
    private String baseUrlForNewHomes;
    private String baseUrlForDocker;
    private String baseUrlForDockerWindows;
    private String baseUrlForInspireMe;
    private String baseUrlForLandAndPlanning;
    private String baseUrlForWhyChooseUs;
    private String baseUrlForWaysToBuy;
    private String baseUrlForSupport;
    private String baseUrlForCovid19Hub;
    private String baseUrlForNewHomesAsTheyShouldBe;
    private String baseUrlDownloadBrochurePageForBrislingtonDevelopments;
    private String baseUrlProposedDevelopmentOsiersPoint;
    private String baseUrlProposedDevelopmentOsiersPointRegisterInterest;
    private String baseUrlProposedDevelopmentForBordesley;
    private String baseUrlProposedDevelopmentBordesleyRegisterInterest;
    private String baseUrlProposedDevelopmentForLeigham;
    private String baseUrlProposedDevelopmentLeighamRegisterInterest;
    private String touchPointUserName;
    private String touchPointPassword;
    private String browser;
    private String timestamp;
    private String gridUrl;
    private String gridPort;
    private String localHub;
    private String databaseName;
    private String errorBrowserException;
    private String errorLocatorException;
    private String errorWithDefaultEnvironment;
    private String errorGettingProperties;
    private String errorSettingProperties;
    private String errorSavingHarFile;
    private String errorSavingScreenshot;
    private String errorNullDriver;
    private String errorsReadConfigFile;
    private String errorsGettingTimeStamp;


    static ConfigurationProperties configuration = ConfigCache.getOrCreate(
            ConfigurationProperties.class,
            System.getProperties(),
            System.getenv());

    public ConfigRunSetup() {
        init();
    }

    private void init() {
        try {
            target = configuration.target();
            headless = configuration.headless();
            baseUrl = configuration.url();
            baseUrlForJobs = configuration.jobsUrl();
            baseUrlForCorporate = configuration.corporateUrl();
            baseUrlHaveYourSay = configuration.haveYourSayUrl();
            baseUrlForNewHomes = configuration.newHomesUrl();
            baseUrlForDocker = configuration.getLocalDockerUrl();
            baseUrlForDockerWindows = configuration.getLocalDockerUrlForWindows();
            baseUrlForInspireMe = configuration.inspireMeUrl();
            baseUrlForLandAndPlanning = configuration.landAndPlanningUrl();
            baseUrlForWhyChooseUs = configuration.whyChooseUsUrl();
            baseUrlForWaysToBuy = configuration.waysToBuyUrl();
            baseUrlForSupport = configuration.support();
            baseUrlForCovid19Hub = configuration.covid19hub();
            baseUrlDownloadBrochurePageForBrislingtonDevelopments = configuration.downloadBrochureForBrislingtonDevelopments();
            baseUrlForNewHomesAsTheyShouldBe = configuration.newHomesAsTheyShouldBe();
            baseUrlProposedDevelopmentOsiersPoint = configuration.getProposedDevelopmentForOsierPointUrl();
            baseUrlProposedDevelopmentOsiersPointRegisterInterest = configuration.getProposedDevelopmentRegisterInterestForOsierPointUrl();
            baseUrlProposedDevelopmentBordesleyRegisterInterest = configuration.getProposedDevelopmentRegisterInterestForBordesley();
            baseUrlProposedDevelopmentForBordesley = configuration.getProposedDevelopmentForBordesley();
            baseUrlProposedDevelopmentForLeigham = configuration.getProposedDevelopmentForLeigham();
            baseUrlProposedDevelopmentLeighamRegisterInterest = configuration.getProposedDevelopmentRegisterInterestForLeigham();
            touchPointUserName = configuration.getTouchPointUserName();
            touchPointPassword = configuration.getTouchPointUserPassword();
            browserStackRunEnvironment = configuration.browserStackEnvironment();
            browser = configuration.browser();
            timestamp = configuration.errorsGettingTimeStamp();
            environment = configuration.runenv();
            gridUrl = configuration.gridUrl();
            gridPort = configuration.gridPort();
            localHub = configuration.localHub();
            databaseName = configuration.databaseName();
            errorBrowserException = configuration.errorBrowserException();
            errorLocatorException = configuration.errorLocatorException();
            errorWithDefaultEnvironment = configuration.errorWithDefaultEnvironment();
            errorGettingProperties = configuration.errorGettingProperties();
            errorSettingProperties = configuration.errorSettingProperties();
            errorSavingHarFile = configuration.errorSavingHarFile();
            errorSavingScreenshot = configuration.errorSavingScreenshot();
            errorNullDriver = configuration.errorNullDriver();
            errorsReadConfigFile = configuration.errorsReadConfigFile();
            errorsGettingTimeStamp = configuration.errorsGettingTimeStamp();
        } catch (Exception e) {
            log.error(configuration.errorsReadConfigFile() + "----" + e);
            log.info(e.getMessage());
        }
    }

}




