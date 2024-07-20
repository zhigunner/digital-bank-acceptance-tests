package co.wedevx.digitalbank.automation.ui.steps.savings_tests;

import co.wedevx.digitalbank.automation.ui.models.BankTransaction;
import co.wedevx.digitalbank.automation.ui.models.DepositBankTransaction;
import co.wedevx.digitalbank.automation.ui.pages.ViewSavingsAccountPage;
import co.wedevx.digitalbank.automation.ui.utils.Driver;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DepositPositiveCaseForSavings {
    WebDriver driver = Driver.getDriver();
    private ViewSavingsAccountPage viewSavingsAccountPage = new ViewSavingsAccountPage(driver);

    @Then("the user makes sure that the savings deposit transaction with the account {string} is indicated in the transaction history")
    public void the_user_makes_sure_that_the_savings_deposit_transaction_with_the_account_is_indicated_in_the_transaction_history(String checkingAccount, List<DepositBankTransaction> expectedTransactions) {
        DepositBankTransaction expectedTransaction = expectedTransactions.get(0);
        double depositAmount = expectedTransaction.getAmount();

        double currentBalance = viewSavingsAccountPage.getAccountBalance(checkingAccount) - depositAmount;

        double expectedBalance = currentBalance + depositAmount;

        Map<String, String> actualResultMap = viewSavingsAccountPage.newlyDepositedAccountTransactionInfoMap();

        assertEquals(expectedTransaction.getCategory(), actualResultMap.get("actualCategory"), "Transaction category mismatch");
        assertEquals(depositAmount, Double.parseDouble(actualResultMap.get("actualAmount")), "Transaction amount mismatch");
        assertEquals(expectedBalance, Double.parseDouble(actualResultMap.get("actualBalance")), "Transaction balance mismatch");
    }
}
