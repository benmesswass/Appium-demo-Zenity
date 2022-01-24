package fr.zenity.appium.listeners;

import fr.zenity.appium.Utils.Utils;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;

public class Hooks {

    @After(order = 1000)
    public void screenshot(Scenario scenario){
        if(scenario.isFailed()){
            Utils.takeScreenShot(scenario.getName());
        }
        System.out.println("---------- After method");
    }

}
