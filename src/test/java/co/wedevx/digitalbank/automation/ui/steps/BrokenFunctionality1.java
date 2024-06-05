package co.wedevx.digitalbank.automation.ui.steps;

import co.wedevx.digitalbank.automation.ui.pages.LinkExternalAccountPage;
import co.wedevx.digitalbank.automation.ui.utils.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BrokenFunctionality1 {
    WebDriver driver = Driver.getDriver();
    LinkExternalAccountPage linkExternalAccountPage = new LinkExternalAccountPage(driver);

    @When("user goes to the Link External Account page")
    public void user_goes_to_the_link_external_account_page() {
        linkExternalAccountPage.goToLinkExternalAccountPage();
    }

    @Then("user sees the {string} error message")
    public void user_sees_the_error_message(String expectedErrorMessage) {
        String actualErrorMessage = linkExternalAccountPage.getLinkExternalAccountErrorMessage();
        assertEquals(expectedErrorMessage, actualErrorMessage, "Error messages don't match");
    }
}
