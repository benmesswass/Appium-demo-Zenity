package fr.zenity.appium.listeners;

import fr.zenity.appium.Utils.Utils;
import fr.zenity.appium.drivers.MobileDriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class Hooks {

    @After(order = 1000)
    public void screenshot(Scenario scenario) throws IOException {
        File file = ((TakesScreenshot)  MobileDriverManager.getInstance().getDriver()).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("Screenshot.jpg"));
    }
}
