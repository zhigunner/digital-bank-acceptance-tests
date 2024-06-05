package co.wedevx.digitalbank.automation.ui.steps.savings_tests;

import co.wedevx.digitalbank.automation.ui.models.BankTransaction;
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

    @Then("the user validates the new amount on the View Savings page the fee will be applied for the overdraft operation")
    public void the_user_validates_the_new_amount_on_the_view_savings_page_the_fee_will_be_applied_for_the_overdraft_operation(List<BankTransaction> expectedTransactions) {
        Map<String,String> actualResultMap = viewSavingsAccountPage.newlyWithdrawedAccountTransactionInfoMap();

        BankTransaction expectedTransaction = expectedTransactions.getFirst();
        assertEquals(expectedTransaction.getCategory(), actualResultMap.get("actualCategory"), "transaction category mismatch");
        assertEquals(expectedTransaction.getAmount(), Double.parseDouble(actualResultMap.get("actualAmount")), "transaction amount mismatch");
        assertEquals(expectedTransaction.getBalance(), Double.parseDouble(actualResultMap.get("actualBalance")), "transaction balance mismatch");
    }
}
