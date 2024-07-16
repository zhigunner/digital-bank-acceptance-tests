package co.wedevx.digitalbank.automation.ui.steps;

import co.wedevx.digitalbank.automation.ui.pages.BaseMenuPage;
import co.wedevx.digitalbank.automation.ui.utils.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankingAppInfo {
    WebDriver driver = Driver.getDriver();
    BaseMenuPage baseMenuPage = new BaseMenuPage(driver);

    @When("the user clicks on the about button")
    public void the_user_clicks_on_the_about_button() {
        baseMenuPage.aboutTab();
    }
    @Then("the user sees the following {string} data")
    public void the_user_sees_the_following_data(String expectedModalBody) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement modalBodyParagraph = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal-body']/p")));

        String actualModalBody = modalBodyParagraph.getText().trim().replace("\n", "\\n").replace("\r", "");
        assertEquals(expectedModalBody, actualModalBody, "Modal Bodies don't match!");

        System.out.println(actualModalBody);
    }
}
