package co.wedevx.digitalbank.automation.ui.steps.savings_tests;

import co.wedevx.digitalbank.automation.ui.models.DepositBankTransaction;
import co.wedevx.digitalbank.automation.ui.models.WithdrawBankTransaction;
import co.wedevx.digitalbank.automation.ui.pages.ViewSavingsAccountPage;
import co.wedevx.digitalbank.automation.ui.pages.WithdrawPage;
import co.wedevx.digitalbank.automation.ui.utils.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WithdrawPositiveCaseForSavings {
    WebDriver driver = Driver.getDriver();
    WithdrawPage withdrawPage = new WithdrawPage(driver);
    ViewSavingsAccountPage viewSavingsAccountPage = new ViewSavingsAccountPage(driver);

    @When("the user goes to the Withdraw page")
    public void the_user_goes_to_the_withdraw_page() {
        withdrawPage.goToWithdrawPage();
    }

    @When("the user selects the {string} account and withdraws {string}")
    public void the_user_selects_the_account_and_withdraws(String accountName, String withdrawAmount) {
        withdrawPage.withdraw(accountName, withdrawAmount);
    }

    @Then("the user makes sure that the savings withdraw transaction with the account {string} is indicated in the transaction history")
    public void the_user_makes_sure_that_the_savings_withdraw_transaction_with_the_account_is_indicated_in_the_transaction_history(String checkingAccount, List<WithdrawBankTransaction> expectedTransactions) {
        WithdrawBankTransaction expectedTransaction = expectedTransactions.get(0);
        double withdrawAmount = expectedTransaction.getAmount();

        double currentBalance = viewSavingsAccountPage.getAccountBalance(checkingAccount) + withdrawAmount;

        double expectedBalance = currentBalance - withdrawAmount;

        Map<String, String> actualResultMap = viewSavingsAccountPage.newlyDepositedAccountTransactionInfoMap();

        assertEquals(expectedTransaction.getCategory(), actualResultMap.get("actualCategory"), "Transaction category mismatch");
        assertEquals(withdrawAmount, Double.parseDouble(actualResultMap.get("actualAmount")), "Transaction amount mismatch");
        assertEquals(expectedBalance, Double.parseDouble(actualResultMap.get("actualBalance")), "Transaction balance mismatch");
    }
}
