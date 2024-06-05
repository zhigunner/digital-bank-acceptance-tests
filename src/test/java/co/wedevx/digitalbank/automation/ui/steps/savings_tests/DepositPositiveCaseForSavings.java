package co.wedevx.digitalbank.automation.ui.steps.savings_tests;

import co.wedevx.digitalbank.automation.ui.models.BankTransaction;
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

    @Then("the user makes sure that the operation is indicated in the transaction history on the View Savings Accounts page")
    public void the_user_makes_sure_that_the_operation_is_indicated_in_the_transaction_history_on_the_view_savings_accounts_page(List<BankTransaction> expectedTransactions) {
        Map<String,String> actualResultMap = viewSavingsAccountPage.newlyDepositedAccountTransactionInfoMap();

        BankTransaction expectedTransaction = expectedTransactions.getFirst();
        assertEquals(expectedTransaction.getCategory(), actualResultMap.get("actualCategory"), "transaction category mismatch");
        assertEquals(expectedTransaction.getAmount(), Double.parseDouble(actualResultMap.get("actualAmount")), "transaction amount mismatch");
        assertEquals(expectedTransaction.getBalance(), Double.parseDouble(actualResultMap.get("actualBalance")), "transaction balance mismatch");
    }

}
