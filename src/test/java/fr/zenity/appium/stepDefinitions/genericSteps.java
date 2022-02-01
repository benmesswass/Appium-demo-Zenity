package fr.zenity.appium.stepDefinitions;

import PageObjects.ViewPage;
import io.cucumber.java8.En;

public class genericSteps implements En {

    public genericSteps(ViewPage viewPage){
        Given("^user is on the login page$",() -> {
            try {
                //viewPage.applicationOk();
                viewPage.clickOnContinue();
            }
            catch(Exception e){
                System.out.println("---no continue step---");
            }
            viewPage.loginPageVerif();
        });

        Given("^user is on the home page$", () -> {
            viewPage.homePageVerif();
        });
    }
}
