package co.wedevx.digitalbank.automation.ui.steps.savings_tests;

import co.wedevx.digitalbank.automation.ui.models.BankTransaction;
import co.wedevx.digitalbank.automation.ui.pages.DepositPage;
import co.wedevx.digitalbank.automation.ui.pages.ViewSavingsAccountPage;
import co.wedevx.digitalbank.automation.ui.utils.Driver;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WithdrawPositiveCaseForSavings1 {
    WebDriver driver = Driver.getDriver();
    ViewSavingsAccountPage viewSavingsAccountPage = new ViewSavingsAccountPage(driver);
    DepositPage depositPage = new DepositPage(driver);

    @Then("the user confirms the new {string} account amount on the View Savings page, a fee will be charged for the overdraft transaction")
    public void the_user_confirms_the_new_account_amount_on_the_view_savings_page_a_fee_will_be_charged_for_the_overdraft_transaction(String accountName, List<BankTransaction> expectedTransactions) {
        Map<String,String> actualResultMap = viewSavingsAccountPage.newlyWithdrawedAccountTransactionInfoMap();

        BankTransaction expectedTransaction = expectedTransactions.get(0);
        assertEquals(expectedTransaction.getCategory(), actualResultMap.get("actualCategory"), "transaction category mismatch");
        assertEquals(expectedTransaction.getAmount(), Double.parseDouble(actualResultMap.get("actualAmount")), "transaction amount mismatch");
        assertEquals(expectedTransaction.getBalance(), Double.parseDouble(actualResultMap.get("actualBalance")), "transaction balance mismatch");


        depositPage.goToPage();
        depositPage.deposit(accountName, "35.00");
    }
}
