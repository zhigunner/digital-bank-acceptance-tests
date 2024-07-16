package co.wedevx.digitalbank.automation.ui.steps.checking_tests;

import co.wedevx.digitalbank.automation.ui.models.BankTransaction;
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
    @Then("the user makes sure that the operation is indicated in the transaction history")
    public void the_user_makes_sure_that_the_operation_is_indicated_in_the_transaction_history(List<BankTransaction> expectedTransactions) {
        Map<String,String> actualResultMap = viewCheckingAccountPage.newlyDepositedAccountTransactionInfoMap();

        BankTransaction expectedTransaction = expectedTransactions.get(0);
        assertEquals(expectedTransaction.getCategory(), actualResultMap.get("actualCategory"), "transaction category mismatch");
        assertEquals(expectedTransaction.getAmount(), Double.parseDouble(actualResultMap.get("actualAmount")), "transaction amount mismatch");
        assertEquals(expectedTransaction.getBalance(), Double.parseDouble(actualResultMap.get("actualBalance")), "transaction balance mismatch");
    }
}
