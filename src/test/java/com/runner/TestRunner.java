package com.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(tags = "@login",
        features = "src/test/resources/Features",
        glue = "com.stepdefination",
        dryRun = false,
        monochrome = true,
        plugin = {"pretty","html:target\\reports\\reports.html",
        "json:target/jsonReports/reports.json"})
public class TestRunner {


}
