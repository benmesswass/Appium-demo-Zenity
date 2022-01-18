package fr.zenity.appium.Enum;

import java.util.Objects;

public enum Device {

    SAMSUMG("Pixel2"),
    IPHONE(null),
    CUSTOM(null);

    private String name;

    Device(String name){this.name = name;}

    public static Device parse(String name){
        if(name.contains("custom")) return Device.valueOf("CUSTOM").setName(name.replace("custom",""));
        return Device.valueOf(name);
    }

    private Device setName(String name){this.name = name; return this;}

    public String getName() {return name;}

    @Override
    public String toString() {return Objects.requireNonNull(name);}

}
