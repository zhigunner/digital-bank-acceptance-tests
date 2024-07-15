package co.wedevx.digitalbank.automation.ui.steps;

import co.wedevx.digitalbank.automation.ui.pages.BaseMenuPage;
import co.wedevx.digitalbank.automation.ui.utils.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckingUnreadMessages {
    WebDriver driver = Driver.getDriver();
    BaseMenuPage baseMenuPage = new BaseMenuPage(driver);

    @When("the user clicks on the messages icon")
    public void the_user_clicks_on_the_messages_icon() {
        baseMenuPage.messagesTab();
    }

    @Then("the user sees the following {string} message")
    public void the_user_sees_the_following_message(String expectedMessage) {
        String actualMessage = baseMenuPage.getReportAboutUnreadMessages();
        assertEquals(expectedMessage, actualMessage, "Messages reports don't match!");
    }
}
