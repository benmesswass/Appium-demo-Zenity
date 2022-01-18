package fr.zenity.appium.drivers.utils;

import fr.zenity.appium.config.Properties;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public interface DriversImpl {

    void close();

    void quit();

    AppiumDriver<MobileElement> getDriver();

    default DesiredCapabilities getAndroidCapabilities(){
        DesiredCapabilities cap = new DesiredCapabilities();

        cap.setCapability(MobileCapabilityType.APP, Properties.appConfig.getAndroidApplicationPath());
        cap.setCapability(AndroidMobileCapabilityType.UNICODE_KEYBOARD, true);
        cap.setCapability(AndroidMobileCapabilityType.RESET_KEYBOARD, true);
        cap.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
        cap.setCapability(MobileCapabilityType.NO_RESET, false);

        return cap;
    }

}
