package fr.zenity.appium.Runner;

import fr.zenity.appium.config.Properties;
import fr.zenity.appium.drivers.MobileDriverManager;
import fr.zenity.appium.drivers.utils.LocalDriver;
import fr.zenity.appium.listeners.AllureListeners;
import fr.zenity.appium.server.AppiumServer;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Listeners({AllureListeners.class})
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

    @Attachment(value="Page screenshot" , type="image/png")
    public byte[] saveScreenshot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
    public void allureSaveDeviceScreenshot() {
        Allure.addAttachment("screenshot", new ByteArrayInputStream(((TakesScreenshot) MobileDriverManager.getInstance().getDriver()).getScreenshotAs(OutputType.BYTES)));
    }
    @AfterSuite
    public void tearDown(){
        MobileDriverManager.driver().quit();
        if(AppiumServer.isRunning()) AppiumServer.Stop();
    }

}