package fr.zenity.appium.stepDefinitions;

import PageObjects.DisconnectionPage;
import io.cucumber.java8.En;

public class DisconnectSteps implements En {

    public DisconnectSteps(DisconnectionPage disconnectionPage) {
        When("^user wants to disconnect from his account$", () -> {
            System.out.println("user wants to disconnect from his account");
            disconnectionPage.disconnect();
            //Thread.sleep(10000);
        });
        Then("^user should be able to disconnect$", () -> {
            disconnectionPage.loginPageVerif();
        });
    }
}
