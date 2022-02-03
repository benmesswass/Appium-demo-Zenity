package fr.zenity.appium.Runner;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {
                "./src/test/resources/BasicTCs",
                "./src/test/resources/Scenario1",
                "./src/test/resources/Scenario2",
                "./src/test/resources/Scenario3",
                "./src/test/resources/ScenarioGreg"
        },
        monochrome = true,
        glue = {"fr.zenity.appium.stepDefinitions", "fr/zenity/academy/pageObjects", "fr/zenity/academy/listeners"},
        plugin = {
                "pretty",
                "html:target/reports/html/htmlreport",
                "json:target/reports/jsonreports/index.json",
                "junit:target/reports/xmlreport.xml",
                "io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm"
        }
)
public class TestRunner extends BaseRunner{
}