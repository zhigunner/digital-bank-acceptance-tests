package co.wedevx.digitalbank.automation.ui.steps.savings_tests;

import co.wedevx.digitalbank.automation.ui.pages.WithdrawPage;
import co.wedevx.digitalbank.automation.ui.utils.Driver;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class WithdrawPositiveCaseForSavings {
    WebDriver driver = Driver.getDriver();
    WithdrawPage withdrawPage = new WithdrawPage(driver);

    @When("the user goes to the Withdraw page")
    public void the_user_goes_to_the_withdraw_page() {
        withdrawPage.goToWithdrawPage();
    }

    @When("the user selects the {string} account and withdraws {string}")
    public void the_user_selects_the_account_and_withdraws(String accountName, String withdrawAmount) {
        withdrawPage.withdraw(accountName, withdrawAmount);
    }
}
