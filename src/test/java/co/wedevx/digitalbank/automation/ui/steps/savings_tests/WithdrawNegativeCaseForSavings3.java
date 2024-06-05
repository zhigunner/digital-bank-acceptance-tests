package co.wedevx.digitalbank.automation.ui.steps.savings_tests;

import co.wedevx.digitalbank.automation.ui.pages.WithdrawPage;
import co.wedevx.digitalbank.automation.ui.utils.Driver;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class WithdrawNegativeCaseForSavings3 {
    WebDriver driver = Driver.getDriver();
    WithdrawPage withdrawPage = new WithdrawPage(driver);

    @When("the user selects the {string} and skips the withdraw amount field")
    public void the_user_selects_the_and_skips_the_withdraw_amount_field(String savingsAccountName) {
        withdrawPage.withdrawWithoutWithdrawAmount(savingsAccountName);
    }
}
