package fr.zenity.appium.stepDefinitions;

import fr.zenity.appium.PageObjects.RegistrationPage;
import io.cucumber.java8.En;

public class RegistrationSteps implements En {

    public RegistrationSteps(RegistrationPage registrationPage){

        Given("^user is on the home page$",() -> {
            registrationPage.applicationOk();
        });

        When("^user clicks on register button$", () -> {
            registrationPage.clickOnContinue();
            registrationPage.clickOnRegistered();
        });

        And("^user enters his \"([^\"]*)\" and his \"([^\"]*)\"$",(String mail, String password) -> {
            registrationPage.enterCredentials(mail,password);
        });

        Then("^user should be registered$",() -> {
            registrationPage.registrationConfirmation();
        });


    }
}