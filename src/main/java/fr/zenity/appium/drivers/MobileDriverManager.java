package fr.zenity.appium.drivers;

import fr.zenity.appium.Enum.Device;
import fr.zenity.appium.Enum.Plateform;
import fr.zenity.appium.drivers.utils.DriversImpl;
import org.apache.log4j.Logger;

import java.util.Locale;

public final class MobileDriverManager {
    /***
     *
     */
    private static MobileDriverManager INSTANCE = new MobileDriverManager();
    /***
     *
     */
    private static Logger LOG = Logger.getLogger(MobileDriverManager.class);

    private ThreadLocal<DriversImpl> driver = new ThreadLocal<>();

    private MobileDriverManager(){}

    public DriversImpl getDriver(){return driver.get(); }

    public void setDriver(Device device, Plateform platform){
        //
        LOG.info("Platform selected :"+platform.toString().toUpperCase(Locale.ROOT));
        LOG.info("Device selected :"+device.getName());
        switch (platform){
            case ANDROID: driver.set(new AndroidConnector(device,platform)); break;
            case WINDOWS_PHONE:
            case IOS:
            default:
                throw new UnsupportedOperationException(String.format("Mobile Platform '%s' not supported",platform));
        }

    }

    public static DriversImpl driver(){ return INSTANCE.getDriver(); }

    public static MobileDriverManager getInstance(){ return INSTANCE; }

}
