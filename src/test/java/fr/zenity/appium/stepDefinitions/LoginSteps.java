package fr.zenity.appium.stepDefinitions;

import PageObjects.LoginPage;
import io.cucumber.java8.En;

public class LoginSteps implements En {

    public LoginSteps(LoginPage loginPage) {

        /*Given("^user is on the login page$", () -> {
            loginPage.clickOnContinue();
            loginPage.ConnectionPageVerif();
        });*/

        When("^user tries to connect with his \"([^\"]*)\" and his \"([^\"]*)\"$", (String mail, String password) -> {
            loginPage.enterCredentialsLogin(mail, password);
        });

        Then("^user should be logged in with his \"([^\"]*)\" and his \"([^\"]*)\"$",(String mail, String password)  -> {
            loginPage.checkErrorMsg(mail, password);
            loginPage.checkErrorMsg2(mail, password);
            loginPage.successMsgClick(mail, password);
            System.out.println("before home page Verif");
            loginPage.homePageVerif();
        });

    }

}
