package co.wedevx.digitalbank.automation.ui.steps.checking_tests;

import co.wedevx.digitalbank.automation.ui.models.BankTransaction;
import co.wedevx.digitalbank.automation.ui.models.DepositBankTransaction;
import co.wedevx.digitalbank.automation.ui.pages.DepositPage;
import co.wedevx.digitalbank.automation.ui.pages.ViewCheckingAccountPage;
import co.wedevx.digitalbank.automation.ui.utils.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DepositPositiveCaseForChecking {
    WebDriver driver = Driver.getDriver();
    private DepositPage depositPage = new DepositPage(driver);
    private ViewCheckingAccountPage viewCheckingAccountPage = new ViewCheckingAccountPage(driver);

    @When("the user goes to the Deposit page")
    public void the_user_goes_to_the_deposit_page() {
        depositPage.goToPage();
    }
    @When("the user selects the {string} account and deposits it with {string}")
    public void the_user_selects_the_account_and_deposits_it_with(String accountName, String depositAmount) {
        depositPage.deposit(accountName, depositAmount);
    }

    @Then("the user makes sure that the checking deposit transaction with the account {string} is indicated in the transaction history")
    public void the_user_makes_sure_that_the_checking_deposit_transaction_with_the_account_is_indicated_in_the_transaction_history(String checkingAccount, List<DepositBankTransaction> expectedTransactions) {
        DepositBankTransaction expectedTransaction = expectedTransactions.get(0);
        double depositAmount = expectedTransaction.getAmount();

        double currentBalance = viewCheckingAccountPage.getAccountBalance(checkingAccount) - depositAmount;

        double expectedBalance = currentBalance + depositAmount;

        Map<String, String> actualResultMap = viewCheckingAccountPage.newlyDepositedAccountTransactionInfoMap();

        assertEquals(expectedTransaction.getCategory(), actualResultMap.get("actualCategory"), "Transaction category mismatch");
        assertEquals(depositAmount, Double.parseDouble(actualResultMap.get("actualAmount")), "Transaction amount mismatch");
        assertEquals(expectedBalance, Double.parseDouble(actualResultMap.get("actualBalance")), "Transaction balance mismatch");
    }
}
