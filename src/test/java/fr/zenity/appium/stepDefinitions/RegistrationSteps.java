package fr.zenity.appium.stepDefinitions;

import PageObjects.RegistrationPage;
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

        And("^user enters his \"([^\"]*)\" his \"([^\"]*)\" and \"([^\"]*)\"$", (String mail, String password, String confirmPassword) -> {
            registrationPage.enterCredentialsRegistration(mail,password, confirmPassword);
            registrationPage.submit();
        });
        /*And("^user enters his \"([^\"]*)\" and his \"([^\"]*)\"$",(String mail, String password) -> {
            registrationPage.enterCredentials(mail,password);
            registrationPage.submit();
        });*/

        Then("^user should be registered with his \"([^\"]*)\" and his \"([^\"]*)\"$",(String mail, String password) -> {
            registrationPage.checkErrorMsg(mail, password);
            registrationPage.successMsgClick();
        });

    }
}