package co.wedevx.digitalbank.automation.ui.steps.savings_tests;

import co.wedevx.digitalbank.automation.ui.pages.WithdrawPage;
import co.wedevx.digitalbank.automation.ui.utils.Driver;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WithdrawNegativeCaseForSavings1 {
    WebDriver driver = Driver.getDriver();
    WithdrawPage withdrawPage = new WithdrawPage(driver);

    @Then("the user sees the {string} error message")
    public void the_user_sees_the_error_message(String expectedErrorMessage) {
        String actualErrorMessage = withdrawPage.getWithdrawalErrorMessage();
        expectedErrorMessage = expectedErrorMessage.trim();
        assertEquals(expectedErrorMessage, actualErrorMessage, "Error messages don't match");
    }
}
