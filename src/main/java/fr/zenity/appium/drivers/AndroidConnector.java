package fr.zenity.appium.drivers;

import fr.zenity.appium.Enum.Device;
import fr.zenity.appium.Enum.Plateform;
import fr.zenity.appium.drivers.utils.LocalDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Objects;

public class AndroidConnector extends LocalDriver {


    public AndroidConnector(Device device, Plateform platform){
        super();
        Objects.requireNonNull(device);
        Objects.requireNonNull(platform);

        DesiredCapabilities cap = this.getAndroidCapabilities();

        // avd
        cap.setCapability("deviceName",device.toString());
        cap.setCapability("platformName",platform.toLowerCase());
        // other
        cap.setCapability("appPackage","com.example.shop_app");
        cap.setCapability("automationName","UiAutomator2");

        driver = new AndroidDriver<>( super.getWebDriveRemoteUrl(), cap);
    }

}
