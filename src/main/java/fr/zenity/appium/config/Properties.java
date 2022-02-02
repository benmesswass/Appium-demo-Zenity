package fr.zenity.appium.config;

import fr.zenity.appium.manager.ManagerXLS;

public interface Properties {
    /***
     *
     */
    ApplicationProperties appConfig = ApplicationProperties.getInstance();
    /***
     *
     */
    PropertiesConfig configuration = PropertiesConfig.getInstance();

    ManagerXLS managerXLS = new ManagerXLS();

}
