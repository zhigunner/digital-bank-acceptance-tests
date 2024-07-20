package co.wedevx.digitalbank.automation.ui.steps.transfer_test;

import co.wedevx.digitalbank.automation.ui.models.DepositBankTransaction;
import co.wedevx.digitalbank.automation.ui.models.TransferBankTransaction;
import co.wedevx.digitalbank.automation.ui.pages.TransferBetweenAccountsPage;
import co.wedevx.digitalbank.automation.ui.pages.ViewCheckingAccountPage;
import co.wedevx.digitalbank.automation.ui.utils.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransferPositiveCase1 {
    WebDriver driver = Driver.getDriver();
    TransferBetweenAccountsPage transferBetweenAccountsPage = new TransferBetweenAccountsPage(driver);
    ViewCheckingAccountPage viewCheckingAccountPage = new ViewCheckingAccountPage(driver);

    @When("the user goes to the Transfer Between Accounts page")
    public void the_user_goes_to_the_transfer_between_accounts_page() {
        transferBetweenAccountsPage.goToTransferBetweenAccountsPage();
    }
    @When("the user firstly selects the {string} account then selects {string} account and transfers {string} dollars")
    public void the_user_firstly_selects_the_account_then_selects_account_and_transfers_dollars(String fromAccount, String toAccount, String transferAmount) {
        transferBetweenAccountsPage.transferBetweenAccounts(fromAccount, toAccount, transferAmount);
    }
    @Then("the user makes sure that the transfer transaction with the account {string} is indicated in the transaction history")
    public void the_user_makes_sure_that_the_transfer_transaction_with_the_account_is_indicated_in_the_transaction_history(String checkingAccountName, List<TransferBankTransaction> expectedTransactions) {
        TransferBankTransaction expectedTransaction = expectedTransactions.get(0);
        double transferAmount = expectedTransaction.getAmount();

        double currentBalance = viewCheckingAccountPage.getAccountBalance(checkingAccountName) - transferAmount;

        double expectedBalance = currentBalance + transferAmount;

        Map<String, String> actualResultMap = viewCheckingAccountPage.newlyDepositedAccountTransactionInfoMap();

        assertEquals(expectedTransaction.getCategory(), actualResultMap.get("actualCategory"), "Transaction category mismatch");
        assertEquals(transferAmount, Double.parseDouble(actualResultMap.get("actualAmount")), "Transaction amount mismatch");
        assertEquals(expectedBalance, Double.parseDouble(actualResultMap.get("actualBalance")), "Transaction balance mismatch");
    }
}
