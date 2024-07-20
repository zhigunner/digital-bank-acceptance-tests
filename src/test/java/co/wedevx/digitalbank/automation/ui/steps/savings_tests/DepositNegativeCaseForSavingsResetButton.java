package co.wedevx.digitalbank.automation.ui.steps.savings_tests;

import co.wedevx.digitalbank.automation.ui.pages.DepositPage;
import co.wedevx.digitalbank.automation.ui.utils.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DepositNegativeCaseForSavingsResetButton {
    WebDriver driver = Driver.getDriver();
    private DepositPage depositPage = new DepositPage(driver);
    @When("the user selects the {string} account and deposits it with {string} and presses the reset button")
    public void the_user_selects_the_account_and_deposits_it_with_and_presses_the_reset_button(String savingsAccountName, String depositAmount) {
        depositPage.depositAndReset(savingsAccountName, depositAmount);
    }
    @Then("the user clicks submit and sees the {string} validation message from the {string} field")
    public void the_user_clicks_submit_and_sees_the_validation_message_from_the_field(String expectedMessage, String fieldName) {
        assertEquals(expectedMessage, depositPage.getDepositPageFieldErrorMessages(fieldName), "Validation messages are not matching!");
    }
}
