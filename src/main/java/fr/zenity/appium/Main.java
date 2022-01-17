package fr.zenity.appium;

import fr.zenity.appium.Enum.Device;
import fr.zenity.appium.Enum.Plateform;
import fr.zenity.appium.drivers.MobileDriverManager;
import fr.zenity.appium.server.AppiumServer;

public class Main {

    public static void main(String[] args){

        if(AppiumServer.isRunning())AppiumServer.Stop();
        AppiumServer.start();
        MobileDriverManager
                .getInstance()
                .setDriver(Device.SAMSUMG, Plateform.ANDROID);
        try{ Thread.sleep(5000); }
        catch (Exception e){
            MobileDriverManager.getInstance()
                    .getDriver()
                    .quit();
        }
        MobileDriverManager.getInstance()
                .getDriver()
                .quit();
        AppiumServer.Stop();
    }
}
