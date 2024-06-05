package co.wedevx.digitalbank.automation.ui.steps.profile_test;

import co.wedevx.digitalbank.automation.ui.pages.ProfilePage;
import co.wedevx.digitalbank.automation.ui.utils.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class incorrectPhoneNumberSteps {

    WebDriver driver = Driver.getDriver();
    private ProfilePage profilePage = new ProfilePage(driver);


    @When("the user sets the  {string} number as mobile number")
    public void the_user_sets_the_number_as_mobile_number(String mobilePhoneNumber) {
        profilePage.updateMobilePhoneNumber(mobilePhoneNumber);
    }
    @Then("user should see the {string} warning message")
    public void user_should_see_the_warning_message(String expectedValidationMessage) {
        String actualValidationMessage = profilePage.getMobilePhoneFieldErrorMessage().replaceAll("\\s+", "");
        assertEquals(expectedValidationMessage.replaceAll("\\s+", ""), actualValidationMessage, "Validation messages are not matching!");
    }
}
