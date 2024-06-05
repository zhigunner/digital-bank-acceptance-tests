package co.wedevx.digitalbank.automation.ui.pages;

import co.wedevx.digitalbank.automation.ui.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import static co.wedevx.digitalbank.automation.ui.utils.Driver.getDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DepositPage extends BaseMenuPage {
    public DepositPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="selectedAccount")
    protected WebElement selectAccountDropdown;

    @FindBy(id="amount")
    protected WebElement amountTextField;

    @FindBy(xpath="//button[@class='btn btn-primary btn-sm']")
    protected WebElement submitDepositButton;

    @FindBy(xpath="//button[@class='btn btn-danger btn-sm']")
    protected WebElement resetButton;

    public void goToPage() {
        depositMenu.click();
        assertEquals(ConfigReader.getPropertiesValue("digitalbank.depositurl"), getDriver().getCurrentUrl(), "Deposit menu button didn't take to the url" + ConfigReader.getPropertiesValue("digitalbank.depositurl"));
    }

    public void deposit(String accountName, String depositAmount) {
        Select titleSelect = new Select(selectAccountDropdown);
        titleSelect.selectByVisibleText(accountName);

        amountTextField.sendKeys(depositAmount);
        submitDepositButton.click();
    }

    public String getDepositPageFieldErrorMessages(String fieldName) {
        switch (fieldName) {
            case "AccountForDeposit":
                return selectAccountDropdown.getAttribute("validationMessage");
            case "DepositAmount":
                return amountTextField.getAttribute("validationMessage");
            default:
                return null;
        }
    }

    public void depositWithoutSelectingAnAccount(String depositAmount) {
        amountTextField.sendKeys(depositAmount);
        submitDepositButton.click();
    }

    public void depositWithoutDepositAmount(String accountName) {
        Select titleSelect = new Select(selectAccountDropdown);
        titleSelect.selectByVisibleText(accountName);

        submitDepositButton.click();
    }

    public void depositAndReset(String accountName, String depositAmount) {
        Select titleSelect = new Select(selectAccountDropdown);
        titleSelect.selectByVisibleText(accountName);

        amountTextField.sendKeys(depositAmount);
        resetButton.click();
        submitDepositButton.click();
    }
}
