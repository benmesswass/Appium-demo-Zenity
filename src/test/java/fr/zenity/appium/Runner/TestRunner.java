package fr.zenity.appium.Runner;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "./src/test/resources/features",
        monochrome = true,
        glue = {"fr.zenity.appium.stepDefinitions"},
        plugin = {
                "pretty"
        }
)
public class TestRunner extends BaseRunner{
}