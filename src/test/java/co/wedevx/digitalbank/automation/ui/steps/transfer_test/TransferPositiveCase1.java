package co.wedevx.digitalbank.automation.ui.steps.transfer_test;

import co.wedevx.digitalbank.automation.ui.pages.TransferBetweenAccountsPage;
import co.wedevx.digitalbank.automation.ui.utils.Driver;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class TransferPositiveCase1 {
    WebDriver driver = Driver.getDriver();
    TransferBetweenAccountsPage transferBetweenAccountsPage = new TransferBetweenAccountsPage(driver);

    @When("the user goes to the Transfer Between Accounts page")
    public void the_user_goes_to_the_transfer_between_accounts_page() {
        transferBetweenAccountsPage.goToTransferBetweenAccountsPage();
    }
    @When("the user firstly selects the {string} account then selects {string} account and transfers {string} dollars")
    public void the_user_firstly_selects_the_account_then_selects_account_and_transfers_dollars(String fromAccount, String toAccount, String transferAmount) {
        transferBetweenAccountsPage.transferBetweenAccounts(fromAccount, toAccount, transferAmount);
    }
}
