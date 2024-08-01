package co.wedevx.digitalbank.automation.ui.steps.checking_tests;


import co.wedevx.digitalbank.automation.ui.models.CheckingAccountInfo;
import co.wedevx.digitalbank.automation.ui.models.CheckingAccountWithoutAnAccountTypeInfo;
import co.wedevx.digitalbank.automation.ui.pages.CreateCheckingPage;
import co.wedevx.digitalbank.automation.ui.utils.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NewCheckingAccountNegative2 {
    WebDriver driver = Driver.getDriver();
    private CreateCheckingPage createCheckingPage = new CreateCheckingPage(driver);

    @When("the user tries to create a new checking account with the following data without an account type")
    public void the_user_tries_to_create_a_new_checking_account_with_the_following_data_without_an_account_type(List<CheckingAccountWithoutAnAccountTypeInfo> checkingAccountWithoutAnAccountTypeInfoList) {
        createCheckingPage.createNewCheckingWithoutAnAccountType(checkingAccountWithoutAnAccountTypeInfoList);
    }

    @Then("the user should see the {string} validation message")
    public void the_user_should_see_the_validation_message(String expectedValidationMessage) {
        String actualValidationMessage = createCheckingPage.getAccountTypeErrorMessage();
        assertEquals(expectedValidationMessage, actualValidationMessage, "Validation messages don't match!");
    }
}
