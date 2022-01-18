package fr.zenity.appium.Runner;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "./src/test/resources/features",
        monochrome = true,
        glue = {"fr.zenity.appium.stepDefinitions"},
        plugin = {
                "pretty",
                "html:target/reports/html/htmlreport",
                "json:target/reports/jsonreports/index.json",
                "junit:target/reports/xmlreport.xml"
                //"io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm"
        }
)
public class TestRunner extends BaseRunner{
}