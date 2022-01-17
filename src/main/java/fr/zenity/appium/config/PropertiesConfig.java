package fr.zenity.appium.config;

import fr.zenity.appium.Enum.Device;
import fr.zenity.appium.Enum.Plateform;

import java.util.Locale;
import java.util.Objects;

public class PropertiesConfig {

    private static PropertiesConfig INSTANCE = new PropertiesConfig();

    private PropertiesLoader prop = PropertiesLoader.of("configuration");

    private Device device;
    private Plateform mos;

    public PropertiesConfig(){
        String tmp;

        //tmp = System.getProperty("overrideDevice", prop.getProperty("overrideDevice"));
       // if(!Objects.isNull(tmp)){
        //    device = Device.parse("custom"+tmp);
        //}else {
            tmp = System.getProperty("device", prop.getProperty("device", "samsumg"));
            device = Device.parse(tmp.toUpperCase());
       // }

        System.out.println("Devince "+ device.getName()+" "+ device.toString());
        tmp     = System.getProperty("mos", prop.getProperty("mos","android"));
        mos     = Plateform.valueOf(tmp.toUpperCase());

    }

    public Device getDevice(){ return device; }

    public Plateform getMobileOS(){ return mos; }

    public static PropertiesConfig getInstance(){ return INSTANCE; }
}
