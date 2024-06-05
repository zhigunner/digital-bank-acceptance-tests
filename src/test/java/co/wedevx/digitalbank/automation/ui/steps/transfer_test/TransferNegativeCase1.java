package co.wedevx.digitalbank.automation.ui.steps.transfer_test;

import co.wedevx.digitalbank.automation.ui.pages.TransferBetweenAccountsPage;
import co.wedevx.digitalbank.automation.ui.utils.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransferNegativeCase1 {
    WebDriver driver = Driver.getDriver();
    TransferBetweenAccountsPage transferBetweenAccountsPage = new TransferBetweenAccountsPage(driver);

    @When("the user firstly selects the {string} account then selects {string} account and skips the transfer amount field")
    public void the_user_firstly_selects_the_account_then_selects_account_and_skips_the_transfer_amount_field(String fromAccount, String toAccount) {
        transferBetweenAccountsPage.transferBetweenAccountWithoutAmount(fromAccount, toAccount);
    }

    @Then("the user sees the {string} validation message from the {string} field on the internal transfer page")
    public void the_user_sees_the_validation_message_from_the_field_on_the_internal_transfer_page(String expectedMessage, String fieldName) {
        assertEquals(expectedMessage, transferBetweenAccountsPage.getTransferPageFieldErrorMessages(fieldName), "Validation messages don't match!");
    }
}
