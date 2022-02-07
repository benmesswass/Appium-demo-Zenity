package fr.zenity.appium.stepDefinitions;

import PageObjects.AccountModifyPage;
import io.cucumber.java8.En;

public class AccountModifySteps implements En {
    public AccountModifySteps(AccountModifyPage accountModifyPage) {

        And("^user wants to modify his \"([^\"]*)\" or his \"([^\"]*)\" or his \"([^\"]*)\" or his \"([^\"]*)\"$", (String firstName, String lastName, String mobileNbre, String adress) -> {
            accountModifyPage.accountModify(firstName, lastName, mobileNbre, adress);
        });

        Then("^the information \"([^\"]*)\" or his \"([^\"]*)\" or his \"([^\"]*)\" or his \"([^\"]*)\" should be successfully modified in his account$", (String firstName, String lastName, String mobileNbre, String adress) -> {
            accountModifyPage.accountModifVerif(firstName, lastName, mobileNbre, adress);
        });

    }
}
