package fr.zenity.appium.Runner;

import fr.zenity.appium.config.Properties;
import fr.zenity.appium.drivers.MobileDriverManager;
import fr.zenity.appium.drivers.utils.LocalDriver;
import fr.zenity.appium.server.AppiumServer;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseRunner extends AbstractTestNGCucumberTests {

    @BeforeSuite
    public void setUp(){
        if(!AppiumServer.isRunning()) AppiumServer.start();
        MobileDriverManager
                .getInstance()
                .setDriver(
                    Properties.configuration.getDevice(),
                    Properties.configuration.getMobileOS()
                );
    }


    @AfterSuite
    public void tearDown() {
        MobileDriverManager.driver().quit();
        if (AppiumServer.isRunning()) AppiumServer.Stop();
    }

}