package fr.zenity.appium.stepDefinitions;

import PageObjects.DisconnectionPage;
import io.cucumber.java8.En;

public class DisconnectSteps implements En {

    public DisconnectSteps(DisconnectionPage disconnectionPage) {
        Given("^user is logged in$", () -> {
            disconnectionPage.disconnect();
        });
        When("^user wants to disconnect from his account$", () -> {
            System.out.println("user wants to disconnect from his account");
        });
        Then("^user should be able to disconnect$", () -> {
            System.out.println("user should be able to disconnect");
        });
    }
}
