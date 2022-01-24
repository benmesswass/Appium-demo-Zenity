package fr.zenity.appium.Utils;

import fr.zenity.appium.drivers.MobileDriverManager;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Utils {

    @Attachment(value = "Screenshot after {name}", type = "image/png")
    public static byte[] takeScreenShot(String methodName) {
        return ((TakesScreenshot) MobileDriverManager.getInstance().getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
