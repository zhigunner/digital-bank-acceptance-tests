package co.wedevx.digitalbank.automation.ui.steps.savings_tests;

import co.wedevx.digitalbank.automation.ui.models.AccountCard;
import co.wedevx.digitalbank.automation.ui.models.BankTransaction;
import co.wedevx.digitalbank.automation.ui.models.SavingsAccountInfo;
import co.wedevx.digitalbank.automation.ui.pages.CreateSavingsPage;
import co.wedevx.digitalbank.automation.ui.pages.LoginPage;
import co.wedevx.digitalbank.automation.ui.pages.ViewSavingsAccountPage;
import co.wedevx.digitalbank.automation.ui.utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SavingsSteps {

    WebDriver driver = Driver.getDriver();
    private LoginPage loginPage = new LoginPage(driver);
    private CreateSavingsPage createSavingsPage = new CreateSavingsPage(driver);
    private ViewSavingsAccountPage viewSavingsAccountPage = new ViewSavingsAccountPage(driver);

    @Given("user logged in as {string} and {string}")
    public void user_logged_in_as_and(String username, String password) {
        loginPage.login(username, password);
    }

    @When("user creates a new savings account with the following data")
    public void user_creates_a_new_savings_account_with_the_following_data(List<SavingsAccountInfo> savingsAccountInfoList) {
        createSavingsPage.createNewSavings(savingsAccountInfoList);
    }

    @Then("user should see the green {string} message")
    public void user_should_see_the_green_message(String expectedConfirmationMessage) {
        expectedConfirmationMessage = "Confirmation " + expectedConfirmationMessage + "\n×";
        assertEquals(expectedConfirmationMessage, viewSavingsAccountPage.getActualCreateAccountConfirmationMessage(), "Confirmation messages are not matching!");
    }

    @Then("user should see newly added account card")
    public void user_should_see_newly_added_account_card(List<AccountCard> accountCardList) {
        Map<String,String> actualResultMap = viewSavingsAccountPage.newlyAddedSavingsAccountMap();
        AccountCard expectedResult = accountCardList.getFirst();

        assertEquals(expectedResult.getAccountName(), actualResultMap.get("actualAccountName"));
        assertEquals("Account: " + expectedResult.getAccountType(), actualResultMap.get("actualAccountType"));
        assertEquals("Ownership: " + expectedResult.getOwnership(), actualResultMap.get("actualOwnership"));
        assertEquals("Interest Rate: " + expectedResult.getInterestRate(), actualResultMap.get("actualInterestRate"));

        String expectedBalance = String.format("%.2f", expectedResult.getBalance());
        assertEquals("Balance: $" + expectedBalance, actualResultMap.get("actualBalance"));
    }

    @Then("user should see the following transactions")
    public void user_should_see_the_following_transactions(List<BankTransaction> expectedTransactions) {
        Map<String,String> actualResultMap = viewSavingsAccountPage.newlyAddedSavingsAccountTransactionInfoMap();

        BankTransaction expectedTransaction = expectedTransactions.getFirst();
        assertEquals(expectedTransaction.getCategory(), actualResultMap.get("actualCategory"), "transaction category mismatch");
        assertEquals(expectedTransaction.getAmount(), Double.parseDouble(actualResultMap.get("actualAmount")), "transaction amount mismatch");
        assertEquals(expectedTransaction.getBalance(), Double.parseDouble(actualResultMap.get("actualBalance")), "transaction balance mismatch");
    }
}
