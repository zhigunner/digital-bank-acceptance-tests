package co.wedevx.digitalbank.automation.ui.steps.profile_test;

import co.wedevx.digitalbank.automation.ui.pages.BaseMenuPage;
import co.wedevx.digitalbank.automation.ui.pages.LoginPage;
import co.wedevx.digitalbank.automation.ui.utils.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Logout {
    WebDriver driver = Driver.getDriver();
    BaseMenuPage baseMenuPage = new BaseMenuPage(driver);

    LoginPage loginPage = new LoginPage(driver);


    @When("user clicks on the {string} button")
    public void user_clicks_on_the_button(String option) {
        baseMenuPage.userAreaOptions(option);
    }

    @Then("user sees the {string} message")
    public void user_sees_the_message(String expectedMessage) {
        String actualMessage = loginPage.getLogoutConfirmationMessage().substring(loginPage.getLogoutConfirmationMessage().indexOf("Logout"), loginPage.getLogoutConfirmationMessage().lastIndexOf("."));
        assertEquals(expectedMessage, actualMessage, "Messages do not match!");
    }
}
