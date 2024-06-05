package co.wedevx.digitalbank.automation.ui.steps.profile_test;

import co.wedevx.digitalbank.automation.ui.pages.LoginPage;
import co.wedevx.digitalbank.automation.ui.pages.ProfilePage;
import co.wedevx.digitalbank.automation.ui.utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UpdatingProfileSteps {
    WebDriver driver = Driver.getDriver();
    private LoginPage loginPage = new LoginPage(driver);
    private ProfilePage profilePage = new ProfilePage(driver);

    @Given("user logged into the bank system as {string} and {string}")
    public void user_logged_into_the_bank_system_as_and(String username, String password) {
        loginPage.login(username, password);
    }
    @When("the user sets the  {string} number as mobile number and the {string} number as work number")
    public void the_user_sets_the_number_as_mobile_number_and_the_number_as_work_number(String mobilePhone, String workPhone) {
        profilePage.updateMobileAndWorkPhoneNumbers(mobilePhone, workPhone);
    }
    @Then("user should see the {string} message")
    public void user_should_see_the_message(String expectedConfMessage) {
        expectedConfMessage = "Success " + expectedConfMessage + "\n×";
        assertEquals(expectedConfMessage, profilePage.getProfileUpdatedConfirmationMessage());
    }
}
