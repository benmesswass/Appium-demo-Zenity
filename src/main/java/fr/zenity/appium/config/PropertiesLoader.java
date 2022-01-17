package fr.zenity.appium.config;


import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Objects;
import java.util.Properties;

public class PropertiesLoader{

    private final static String CONFIG_DIR = "config/%s.properties";

    private Properties prop = new Properties();

    public PropertiesLoader(String propertiesFileName){
        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader(String.format(CONFIG_DIR, propertiesFileName)));
            prop.load(bufferedReader);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public String getProperty(String key){ return prop.getProperty(key); }

    public String getProperty(String key, String defaultValue ){
        String tmp;
        return Objects.isNull( ( tmp = getProperty(key) )) ? defaultValue : tmp;
    }

    public static PropertiesLoader of(String path){ return new PropertiesLoader(path); }
}
