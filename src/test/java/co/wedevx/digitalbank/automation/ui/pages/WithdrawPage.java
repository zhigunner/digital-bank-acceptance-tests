package co.wedevx.digitalbank.automation.ui.pages;

import co.wedevx.digitalbank.automation.ui.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import static co.wedevx.digitalbank.automation.ui.utils.Driver.getDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WithdrawPage extends BaseMenuPage {
    public WithdrawPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="selectedAccount")
    protected WebElement selectAccountDropdown;

    @FindBy(id="amount")
    protected WebElement amountTextField;

    @FindBy(xpath="//button[@class='btn btn-primary btn-sm']")
    protected WebElement submitWithdrawButton;

    @FindBy(xpath="//button[@class='btn btn-danger btn-sm']")
    protected WebElement resetButton;

    @FindBy(xpath="//div[@class='sufee-alert alert with-close alert-danger alert-dismissible fade show']")
    protected WebElement errorMessage;



    public void goToWithdrawPage() {
        withdrawMenu.click();
        assertEquals(ConfigReader.getPropertiesValue("digitalbank.withdrawurl"), getDriver().getCurrentUrl(), "Withdraw menu button didn't take to the url" + ConfigReader.getPropertiesValue("digitalbank.withdrawurl"));
    }

    public void withdraw(String accountName, String withdrawAmount) {
        Select titleSelect = new Select(selectAccountDropdown);
        titleSelect.selectByVisibleText(accountName);

        amountTextField.sendKeys(withdrawAmount);
        submitWithdrawButton.click();
    }

    public String getWithdrawalErrorMessage() {
        return errorMessage.getText().substring(errorMessage.getText().indexOf("The"), errorMessage.getText().lastIndexOf("."));
    }

    public String getWithdrawPageFieldErrorMessages(String fieldName) {
        switch (fieldName) {
            case "AccountForWithdraw":
                return selectAccountDropdown.getAttribute("validationMessage");
            case "WithdrawAmount":
                return amountTextField.getAttribute("validationMessage");
            default:
                return null;
        }
    }

    public void withdrawWithoutSelectingAnAccount(String withdrawAmount) {
        amountTextField.sendKeys(withdrawAmount);
        submitWithdrawButton.click();
    }

    public void withdrawWithoutWithdrawAmount(String accountName) {
        Select titleSelect = new Select(selectAccountDropdown);
        titleSelect.selectByVisibleText(accountName);

        submitWithdrawButton.click();
    }
}
