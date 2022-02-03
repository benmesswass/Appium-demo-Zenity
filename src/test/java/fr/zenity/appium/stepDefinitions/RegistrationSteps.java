package fr.zenity.appium.stepDefinitions;

import PageObjects.RegistrationPage;
import io.cucumber.java8.En;

public class RegistrationSteps implements En {

    public RegistrationSteps(RegistrationPage registrationPage){


        When("^user clicks on register button$", () -> {
            registrationPage.clickOnRegistered();
            /*System.out.println("registrationPage.testXLS().get(0)= "+registrationPage.testXLS(0).get(0));
            System.out.println("registrationPage.testXLS().get(1)= "+registrationPage.testXLS(0).get(1));
            System.out.println("registrationPage.testXLS().get(2)= "+registrationPage.testXLS(0).get(2));*/
        });

        And("^user enters his \"([^\"]*)\" his \"([^\"]*)\" and \"([^\"]*)\"$", (String mail, String password, String confirmPassword) -> {
            registrationPage.enterCredentialsRegistration(registrationPage.testXLS(0).get(0),registrationPage.testXLS(0).get(1),registrationPage.testXLS(0).get(2));
            registrationPage.submit();
        });

        Then("^user should be registered with his \"([^\"]*)\" and his \"([^\"]*)\"$",(String mail, String password) -> {
            //registrationPage.checkErrorMsgRegistration(mail, password);
            //registrationPage.checkErrorMsg2(mail, password);
            registrationPage.successMsgClick(mail, password);
            System.out.println("before home page Verif");
            registrationPage.homePageVerif();
        });

    }
}