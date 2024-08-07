package co.wedevx.digitalbank.automation.ui.pages;

import co.wedevx.digitalbank.automation.ui.models.CheckingAccountInfo;
import co.wedevx.digitalbank.automation.ui.models.CheckingAccountWithoutAnAccountTypeInfo;
import co.wedevx.digitalbank.automation.ui.steps.checking_tests.NewCheckingAccountNegative1;
import co.wedevx.digitalbank.automation.ui.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.NoSuchElementException;

import static co.wedevx.digitalbank.automation.ui.utils.Driver.getDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateCheckingPage extends BaseMenuPage {

    public CreateCheckingPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "Standard Checking")
    private WebElement standardCheckingAccountTypeRadioButton;

    @FindBy(id = "Interest Checking")
    WebElement interestCheckingAccountTypeRadioButton;

    @FindBy(id = "Individual")
    WebElement individualOwnershipRadioButton;

    @FindBy(id = "Joint")
    WebElement jointOwnershipRadioButton;

    @FindBy(id = "name")
    WebElement accountNameTextBox;

    @FindBy(id = "openingBalance")
    WebElement openingBalanceBox;

    @FindBy(id = "newCheckingSubmit")
    WebElement submitButton;

    @FindBy(id = "new-account-error-alert")
    WebElement newCheckingAccountErrorBox;

    public void createNewChecking(List<CheckingAccountInfo> checkingAccountInfoList) {
        CheckingAccountInfo testDataCheckingAccount = checkingAccountInfoList.get(0);

        checkingMenu.click();

        newCheckingButton.click();

        assertEquals(ConfigReader.getPropertiesValue("digitalbank.createnewcheckingurl"), getDriver().getCurrentUrl(), "New Checking Button didn't take to the url" + ConfigReader.getPropertiesValue("digitalbank.createnewcheckingurl"));

        if (testDataCheckingAccount.getCheckingAccountType().equalsIgnoreCase("Standard Checking")) {
            standardCheckingAccountTypeRadioButton.click();
        } else if (testDataCheckingAccount.getCheckingAccountType().equalsIgnoreCase("Interest Checking")) {
            interestCheckingAccountTypeRadioButton.click();
        } else {
            throw new NoSuchElementException("Invalid checking account type option provided. Only supports Standard Checking and Interest Checking");
        }

        if (testDataCheckingAccount.getAccountOwnership().equalsIgnoreCase("Individual")) {
            individualOwnershipRadioButton.click();
        } else if (testDataCheckingAccount.getAccountOwnership().equalsIgnoreCase("Joint")) {
            jointOwnershipRadioButton.click();
        } else {
            throw new NoSuchElementException("Invalid account ownership type option provided. Only supports Individual and Joint");
        }

        accountNameTextBox.sendKeys(testDataCheckingAccount.getAccountName());

        openingBalanceBox.sendKeys(String.valueOf(testDataCheckingAccount.getInitialDepositAmount()));

        submitButton.click();
    }

    public void createNewCheckingWithoutAnAccountType(List<CheckingAccountWithoutAnAccountTypeInfo> checkingAccountWithoutAnAccountTypeInfoList) {
        CheckingAccountWithoutAnAccountTypeInfo testDataCheckingAccount = checkingAccountWithoutAnAccountTypeInfoList.get(0);

        checkingMenu.click();
        newCheckingButton.click();

        assertEquals(ConfigReader.getPropertiesValue("digitalbank.createnewcheckingurl"), getDriver().getCurrentUrl(), "New Checking Button didn't take to the url" + ConfigReader.getPropertiesValue("digitalbank.createnewcheckingurl"));

        if (testDataCheckingAccount.getAccountOwnership().equalsIgnoreCase("Individual")) {
            individualOwnershipRadioButton.click();
        } else if (testDataCheckingAccount.getAccountOwnership().equalsIgnoreCase("Joint")) {
            jointOwnershipRadioButton.click();
        } else {
            throw new NoSuchElementException("Invalid account ownership type option provided. Only supports Individual and Joint");
        }

        accountNameTextBox.sendKeys(testDataCheckingAccount.getAccountName());

        openingBalanceBox.sendKeys(String.valueOf(testDataCheckingAccount.getInitialDepositAmount()));

        submitButton.click();
    }

    public String getErrorMessage() {
        return newCheckingAccountErrorBox.getText().substring(newCheckingAccountErrorBox.getText().indexOf("The"), newCheckingAccountErrorBox.getText().lastIndexOf('.'));
    }

    public String getAccountTypeErrorMessage() {
        return standardCheckingAccountTypeRadioButton.getAttribute("validationMessage").substring(0, standardCheckingAccountTypeRadioButton.getAttribute("validationMessage").lastIndexOf('.'));
    }
}
