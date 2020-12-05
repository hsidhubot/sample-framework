package com.hs.runners;


import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        glue = {"com.hs.stepDefinition"},
        features = {"src/test/resources/features/"},
//        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
//                , "json:target/cucumber-report.json"},
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
                , "json:target/cucumber-report/cucumber.json"},
        tags = {"@smokeA or @smokeB or @smokeC"}
)
public class SmokeTestRunner extends BaseRunner {
}
