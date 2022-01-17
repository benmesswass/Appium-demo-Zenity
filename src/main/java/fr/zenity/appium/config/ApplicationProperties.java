package fr.zenity.appium.config;


import java.util.Objects;
import java.util.Optional;

public class ApplicationProperties {

    private static final ApplicationProperties INSTANCE = new ApplicationProperties();

    private PropertiesLoader prop = PropertiesLoader.of("application");

    ApplicationProperties(){ }

    public String getAndroidApplicationPath(){
        return Optional
                .ofNullable(prop.getProperty("androidApplicationPath"))
                .orElseThrow(()->new NullPointerException("androidApplicationPath property cannot be null !"));
    }

    public String getAppiumServerHost(){
        return Optional
                .ofNullable(prop.getProperty("appium.server.host"))
                .orElseThrow(()->new NullPointerException("appium.server.host property cannot be null !"));
    }

    public Integer getAppiumServerPort(){
        return Integer.parseInt(Objects.requireNonNull(prop.getProperty("appium.server.port"),"appium.server.port property cannot be null !"));
    }

    public String getProxy( ){ return prop.getProperty("appium.server.proxy"); }
    /***
     *
     * @return
     */
    public static ApplicationProperties getInstance(){ return INSTANCE; }
}
