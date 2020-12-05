package com.hs.runners;

import com.hs.config.runTimeConfig;
import com.hs.driver.BaseWebDriver;
import com.hs.shared.SharedMethods;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.*;

@Log4j2
public class BaseRunner extends BaseWebDriver {

    private static final ThreadLocal<TestNGCucumberRunner> testNGCucumberRunner = new ThreadLocal<>();

    public static TestNGCucumberRunner getRunner() {
        return testNGCucumberRunner.get();
    }

    private static void setRunner(TestNGCucumberRunner testNGCucumberRunner1) {
        testNGCucumberRunner.set(testNGCucumberRunner1);
    }


    @BeforeSuite
    @Parameters({"environment", "appiumServer", "bsLocalInstance"})
    public void setConfiguration(@Optional("local") String environment
            , @Optional("no") String appiumServer
            , @Optional("no") String bsLocalInstance) throws Exception {
        new runTimeConfig().setEnvironmentProperties(environment);
//        BrowserStackStartStop.getInstance().runRequiredServers(appiumServer, bsLocalInstance);
        log.info("Testing in Environment : " + new runTimeConfig().getEnvironment());
        System.out.println("****************************");
        System.out.println("You are testing in :- " + new runTimeConfig().getEnvironment());
        System.out.println("****************************");
    }

    @BeforeClass(alwaysRun = true)
    @Parameters({"browser", "bsEnvironment"})
    public void setup(@Optional("chrome") String browser,
                      @Optional("no-environment") String bsEnvironment) {
        setupWebDriver(browser, bsEnvironment);
//        BasePageInstance.init(); // Initiate all the class instances
        setRunner(new TestNGCucumberRunner(this.getClass()));
    }

    @Test(groups = "cucumber", description = "Runs Cucumber Scenarios", dataProvider = "scenarios")
    public void scenario(PickleWrapper pickle, FeatureWrapper cucumberFeature) throws Throwable {
        getRunner().runScenario(pickle.getPickle());
    }

    @DataProvider()
    public Object[][] scenarios() {
        return getRunner().provideScenarios();
    }


    @AfterClass(alwaysRun = true)
    @Parameters({"appiumServer", "bsLocalInstance"})
    public void teardown(@Optional("no") String appiumServer
            , @Optional("no") String bsLocalInstance) throws Exception {
        getRunner().finish();
//        BrowserStackStartStop.getInstance().stopRequiredServers(appiumServer, bsLocalInstance);
        quitBrowser();
//        new SharedMethods().generateMavenReport();
        log.info("Test Completed");
    }

    @AfterSuite
    public void teardown() {
        new SharedMethods().generateMavenReport();
        log.info("Report Created");
    }

}
