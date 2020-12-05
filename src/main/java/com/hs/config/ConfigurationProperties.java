package com.hs.config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Mutable;

@Config.Sources({"classpath:properties/${env}.properties"})
public interface ConfigurationProperties extends Mutable {

    @DefaultValue("local")
    String target();

    @DefaultValue("chrome")
    String browser();

    @DefaultValue("false")
    String headless();

    //    @DefaultValue("null")
    String browserStackEnvironment();

    @Key("base.url")
    @DefaultValue("https://qa-www-np.taylorwimpey.co.uk/")
    String url();

    @Key("base.url.jobs")
    @DefaultValue("https://qa-www-np.taylorwimpey.co.uk/")
    String jobsUrl();

    @Key("base.url.corporate")
    @DefaultValue("https://qa-www-np.taylorwimpey.co.uk/")
    String corporateUrl();

    @Key("base.url.newHomes")
    @DefaultValue("https://qa-www-np.taylorwimpey.co.uk/")
    String newHomesUrl();

    @Key("base.url.whychooseus")
    @DefaultValue("https://qa-www-np.taylorwimpey.co.uk/")
    String whyChooseUsUrl();

    @Key("base.url.inspireMe")
    @DefaultValue("null")
    String inspireMeUrl();

    @Key("base.url.haveyoursay")
    @DefaultValue("null")
    String haveYourSayUrl();

    @Key("base.url.waystobuy")
    @DefaultValue("null")
    String waysToBuyUrl();

    @Key("base.url.support")
    @DefaultValue("null")
    String support();

    @Key("base.url.brislingtonDownloadBrochure")
    @DefaultValue("null")
    String downloadBrochureForBrislingtonDevelopments();

    @Key("base.url.covid19hub")
    @DefaultValue("null")
    String covid19hub();

    @Key("base.url.newHomesAsTheyShouldBe")
    @DefaultValue("null")
    String newHomesAsTheyShouldBe();

    @Key("base.url.landandplanning")
    @DefaultValue("https://qa-www-np.taylorwimpey.co.uk/")
    String landAndPlanningUrl();

    @Key("base.url.docker")
    @DefaultValue("null")
    String getLocalDockerUrl();

    @Key("base.url.proposeDevelopment.OsierPoint")
    @DefaultValue("null")
    String getProposedDevelopmentForOsierPointUrl();

    @Key("base.url.proposeDevelopment.OsierPoint.registerInterest")
    @DefaultValue("null")
    String getProposedDevelopmentRegisterInterestForOsierPointUrl();

    @Key("base.url.proposeDevelopment.Bordesley")
    @DefaultValue("null")
    String getProposedDevelopmentForBordesley();

    @Key("base.url.proposeDevelopment.Bordesley.registerInterest")
    @DefaultValue("null")
    String getProposedDevelopmentRegisterInterestForBordesley();

    @Key("base.url.proposeDevelopment.Leigham")
    @DefaultValue("null")
    String getProposedDevelopmentForLeigham();

    @Key("base.url.proposeDevelopment.Leigham.registerInterest")
    @DefaultValue("null")
    String getProposedDevelopmentRegisterInterestForLeigham();

    @Key("base.url.docker.windows")
    @DefaultValue("null")
    String getLocalDockerUrlForWindows();

    @Key("user.emailaddress")
    @DefaultValue("null")
    String getTouchPointUserName();

    @Key("user.password")
    @DefaultValue("null")
    String getTouchPointUserPassword();

    String timeout();

    @Key("faker.locale")
    @DefaultValue("en_GB")
    String faker();

    @Key("hub.test.grid")
    @DefaultValue("en_GB")
    String localHub();

    @Key("database.user")
    @DefaultValue("root")
    String databaseName();

    @DefaultValue("local")
    String runenv();

    String USER();

    @Key("resources.formats.timestamp")
    @DefaultValue("yyyy.MM.dd")
    String timeStampFormat();

    @Key("errors.browser.exception")
    @DefaultValue("No data accessible")
    String errorBrowserException();

    @Key("errors.locator.exception")
    @DefaultValue("No data accessible")
    String errorLocatorException();

    @Key("errors.default.environment.exception")
    @DefaultValue("No data accessible")
    String errorWithDefaultEnvironment();

    @Key("errors.get.properties")
    @DefaultValue("No data accessible")
    String errorGettingProperties();

    @Key("errors.set.properties")
    @DefaultValue("No data accessible")
    String errorSettingProperties();

    @Key("errors.save.har.file")
    @DefaultValue("No data accessible")
    String errorSavingHarFile();

    @Key("errors.save.screenshot.file")
    @DefaultValue("No data accessible")
    String errorSavingScreenshot();

    @Key("errors.null.driver")
    @DefaultValue("No data accessible")
    String errorNullDriver();

    @Key("error.read.config")
    @DefaultValue("No data accessible")
    String errorsReadConfigFile();

    @Key("error.getting.timestamp")
    @DefaultValue("No data accessible")
    String errorsGettingTimeStamp();

    // GRID DETAILS
    @Key("grid.url")
    @DefaultValue("grid")
    String gridUrl();

    @Key("grid.port")
    @DefaultValue("4444")
    String gridPort();

    //Android Properties
    @Key("android.platform.name")
    @DefaultValue("Check Android Platform Values")
    String androidPlatformName();

    @Key("android.uuid")
    @DefaultValue("Check Android UUID Values")
    String androidUUID();

    @Key("android.device.name")
    @DefaultValue("Check Android Device Values")
    String androidDeviceName();


}
