package fr.zenity.appium.server;

import fr.zenity.appium.config.Properties;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.apache.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.ServerSocket;

public final class AppiumServer {
    /***
     *
     */
    private static Logger LOG = Logger.getLogger(AppiumServer.class);

    private static AppiumDriverLocalService localDaemon;

    public static void start(){
        DesiredCapabilities cap = new DesiredCapabilities();

        AppiumServiceBuilder serviceBuilder = new AppiumServiceBuilder()
                .withIPAddress(Properties.appConfig.getAppiumServerHost())
                .usingPort(Properties.appConfig.getAppiumServerPort())
                .withArgument(GeneralServerFlag.LOG_LEVEL, "debug")
                .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
                .withArgument(GeneralServerFlag.RELAXED_SECURITY);


        localDaemon = AppiumDriverLocalService.buildService(serviceBuilder);
        localDaemon.start();
        LOG.info(" Starting Appium Server");
    }

    public static void Stop(){
        try{
            localDaemon.stop();
            LOG.info("Appium server has been stopped");
        }catch (Exception e){
            LOG.info("Stopping Appium server has failed");
        }
    }

    public static boolean isRunning(){
        try{
            new ServerSocket(Properties.appConfig.getAppiumServerPort()).close();
        }catch (Exception e){
            return true;
        }

        return false;
    }
}
