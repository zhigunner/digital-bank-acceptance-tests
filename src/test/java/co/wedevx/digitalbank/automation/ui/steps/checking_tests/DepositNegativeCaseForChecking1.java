package co.wedevx.digitalbank.automation.ui.steps.checking_tests;

import co.wedevx.digitalbank.automation.ui.pages.DepositPage;
import co.wedevx.digitalbank.automation.ui.utils.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DepositNegativeCaseForChecking1 {
    WebDriver driver = Driver.getDriver();
    private DepositPage depositPage = new DepositPage(driver);

    @When("the user skips the account name field and deposits {string}")
    public void the_user_skips_the_account_name_field_and_deposits(String depositAmount) {
        depositPage.depositWithoutSelectingAnAccount(depositAmount);
    }

    @Then("the user sees the {string} validation message from the {string} field")
    public void the_user_sees_the_validation_message_from_the_field(String expectedMessage, String fieldName) {
        assertEquals(expectedMessage, depositPage.getDepositPageFieldErrorMessages(fieldName), "Validation messages are not matching!");
    }
}
