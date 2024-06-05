package co.wedevx.digitalbank.automation.ui.steps.checking_tests;

import co.wedevx.digitalbank.automation.ui.pages.DepositPage;
import co.wedevx.digitalbank.automation.ui.utils.Driver;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class DepositNegativeCaseForChecking2 {
    WebDriver driver = Driver.getDriver();
    private DepositPage depositPage = new DepositPage(driver);

    @When("the user selects the {string} and skips the deposit amount field")
    public void the_user_selects_the_and_skips_the_deposit_amount_field(String checkingAccountName) {
        depositPage.depositWithoutDepositAmount(checkingAccountName);
    }
}
