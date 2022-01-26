package fr.zenity.appium.Runner;

import fr.zenity.appium.config.Properties;
import fr.zenity.appium.drivers.MobileDriverManager;
import fr.zenity.appium.drivers.utils.LocalDriver;
import fr.zenity.appium.listeners.AllureListeners;
import fr.zenity.appium.server.AppiumServer;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.qameta.allure.Allure;
import io.qameta.allure.AllureLifecycle;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.core.config.Order;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.UUID;

public class BaseRunner extends AbstractTestNGCucumberTests {

    @BeforeSuite
    public void setUp() {
        if (!AppiumServer.isRunning()) AppiumServer.start();
        MobileDriverManager
                .getInstance()
                .setDriver(
                        Properties.configuration.getDevice(),
                        Properties.configuration.getMobileOS()
                );
    }


    @AfterSuite
    public void tearDown(){
        MobileDriverManager.driver().quit();
        if(AppiumServer.isRunning()) AppiumServer.Stop();
    }

}