package co.wedevx.digitalbank.automation.ui.steps.checking_tests;

import co.wedevx.digitalbank.automation.ui.pages.CreateCheckingPage;
import co.wedevx.digitalbank.automation.ui.pages.LoginPage;
import co.wedevx.digitalbank.automation.ui.utils.Driver;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NewCheckingAccountNegative1 {
    WebDriver driver = Driver.getDriver();
    private CreateCheckingPage createCheckingPage = new CreateCheckingPage(driver);

    @Then("the user should see the {string} error message")
    public void the_user_should_see_the_error_message(String expectedErrorMessage) {
        String actualErrorMessage = createCheckingPage.getErrorMessage();
        assertEquals(expectedErrorMessage, actualErrorMessage, "Error messages don't match!");
    }
}
