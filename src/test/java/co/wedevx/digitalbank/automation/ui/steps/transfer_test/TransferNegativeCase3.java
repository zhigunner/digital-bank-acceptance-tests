package co.wedevx.digitalbank.automation.ui.steps.transfer_test;

import co.wedevx.digitalbank.automation.ui.pages.TransferBetweenAccountsPage;
import co.wedevx.digitalbank.automation.ui.utils.Driver;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class TransferNegativeCase3 {
    WebDriver driver = Driver.getDriver();
    TransferBetweenAccountsPage transferBetweenAccountsPage = new TransferBetweenAccountsPage(driver);

    @When("the user firstly selects the {string} account then skips the recipient account and transfers {string} dollars")
    public void the_user_firstly_selects_the_account_then_skips_the_recipient_account_and_transfers_dollars(String senderAccount, String transferAmount) {
        transferBetweenAccountsPage.transferWithoutSelectingRecipientAccount(senderAccount, transferAmount);
    }

    @When("the user firstly skips the sender account then skips the recipient account then selects {string} account and transfers {string} dollars")
    public void the_user_firstly_skips_the_sender_account_then_skips_the_recipient_account_then_selects_account_and_transfers_dollars(String recipientAccount, String transferAmount) {
        transferBetweenAccountsPage.transferWithoutSelectingSenderAccount(recipientAccount, transferAmount);
    }

}
