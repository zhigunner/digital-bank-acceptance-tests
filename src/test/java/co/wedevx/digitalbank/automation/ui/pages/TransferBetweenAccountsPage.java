package co.wedevx.digitalbank.automation.ui.pages;

import co.wedevx.digitalbank.automation.ui.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import static co.wedevx.digitalbank.automation.ui.utils.Driver.getDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransferBetweenAccountsPage extends BaseMenuPage{
    public TransferBetweenAccountsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="fromAccount")
    protected WebElement selectFromAccountDropdown;

    @FindBy(id="toAccount")
    protected WebElement selectToAccountDropdown;

    @FindBy(id="amount")
    protected WebElement transferAmountField;

    @FindBy(xpath="//button[@class='btn btn-primary btn-sm']")
    protected WebElement transferSubmitButton;

    @FindBy(xpath="//div[@class='sufee-alert alert with-close alert-danger alert-dismissible fade show']")
    protected WebElement transferErrorMessage;


    public void goToTransferBetweenAccountsPage() {
        transferBetweenAccountsMenu.click();
        assertEquals(ConfigReader.getPropertiesValue("digitalbank.transferbetweenaccountsurl"), getDriver().getCurrentUrl(), "Transfer between accounts menu button didn't take to the url" + ConfigReader.getPropertiesValue("digitalbank.transferbetweenaccountsurl"));
    }

    public void transferBetweenAccounts(String fromAccount, String toAccount, String transferAmount) {
        Select fromAccountSelect = new Select(selectFromAccountDropdown);
        fromAccountSelect.selectByVisibleText(fromAccount);

        Select toAccountSelect = new Select(selectToAccountDropdown);
        toAccountSelect.selectByVisibleText(toAccount);

        transferAmountField.sendKeys(transferAmount);
        transferSubmitButton.click();
    }

    public void transferBetweenAccountWithoutAmount(String fromAccount, String toAccount) {
        Select fromAccountSelect = new Select(selectFromAccountDropdown);
        fromAccountSelect.selectByVisibleText(fromAccount);

        Select toAccountSelect = new Select(selectToAccountDropdown);
        toAccountSelect.selectByVisibleText(toAccount);

        transferSubmitButton.click();
    }

    public String getTransferPageFieldErrorMessages(String fieldName) {
        switch (fieldName) {
            case "FromAccount":
                return selectFromAccountDropdown.getAttribute("validationMessage");
            case "ToAccount":
                return selectToAccountDropdown.getAttribute("validationMessage");
            case "TransferAmount":
                return transferAmountField.getAttribute("validationMessage");
            default:
                return null;
        }
    }

    public void transferWithoutSelectingRecipientAccount(String senderAccount, String transferAmount) {
        Select toAccountSelect = new Select(selectFromAccountDropdown);
        toAccountSelect.selectByVisibleText(senderAccount);

        transferSubmitButton.click();
    }

    public void transferWithoutSelectingSenderAccount(String recipientAccount, String transferAmount) {
        Select toAccountSelect = new Select(selectToAccountDropdown);
        toAccountSelect.selectByVisibleText(recipientAccount);

        transferSubmitButton.click();
    }

    public String getTransferErrorMessage() {
        return transferErrorMessage.getText().substring(transferErrorMessage.getText().indexOf("The"), transferErrorMessage.getText().lastIndexOf("."));
    }

}
