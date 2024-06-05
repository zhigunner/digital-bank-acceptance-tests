package co.wedevx.digitalbank.automation.ui.steps.transfer_test;

import co.wedevx.digitalbank.automation.ui.pages.TransferBetweenAccountsPage;
import co.wedevx.digitalbank.automation.ui.utils.Driver;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransferNegativeCase4 {
    WebDriver driver = Driver.getDriver();
    TransferBetweenAccountsPage transferBetweenAccountsPage = new TransferBetweenAccountsPage(driver);

    @Then("the user sees the {string} error message on the transfer page")
    public void the_user_sees_the_error_message_on_the_transfer_page(String expectedErrorMessage) {
        String actualErrorMessage = transferBetweenAccountsPage.getTransferErrorMessage();
        assertEquals(expectedErrorMessage, actualErrorMessage, "Error messages don't match");
    }
}
