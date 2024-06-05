package co.wedevx.digitalbank.automation.ui.steps.transfer_test;

import co.wedevx.digitalbank.automation.ui.pages.ViewCheckingAccountPage;
import co.wedevx.digitalbank.automation.ui.utils.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransactionsTable1 {
    WebDriver driver = Driver.getDriver();
    ViewCheckingAccountPage viewCheckingAccountPage = new ViewCheckingAccountPage(driver);

    @When("the user goes to the View Checking page")
    public void the_user_goes_to_the_view_checking_page() {
        viewCheckingAccountPage.goToViewCheckingPage();
    }

    @When("the user selects {string} in the show field")
    public void the_user_selects_in_the_show_field(String numberOfTransactions) {
        viewCheckingAccountPage.selectionNumberOfTransactions(numberOfTransactions);
    }

    @Then("the user sees the {string} table information")
    public void the_user_sees_the_table_information(String expectedTableInfo) {
        String actualTableInfoText = viewCheckingAccountPage.getTableInfoText();
        assertEquals(expectedTableInfo, actualTableInfoText, "Table information messages do not match!");
    }
}
