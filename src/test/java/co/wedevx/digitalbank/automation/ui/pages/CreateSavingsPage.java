package co.wedevx.digitalbank.automation.ui.pages;

import co.wedevx.digitalbank.automation.ui.models.CheckingAccountInfo;
import co.wedevx.digitalbank.automation.ui.models.SavingsAccountInfo;
import co.wedevx.digitalbank.automation.ui.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.NoSuchElementException;

import static co.wedevx.digitalbank.automation.ui.utils.Driver.getDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateSavingsPage extends BaseMenuPage {

    public CreateSavingsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="Savings")
    private WebElement savingsAccountTypeRadioButton;

    @FindBy(id="Money Market")
    private WebElement moneyMarketAccountTypeRadioButton;

    @FindBy(id="Individual")
    private WebElement individualAccountOwnershipRadioButton;

    @FindBy(id="Joint")
    private WebElement jointAccountOwnershipRadioButton;

    @FindBy(id="name")
    private WebElement accountNameTextField;

    @FindBy(id="openingBalance")
    private WebElement initialDepositTextField;

    @FindBy(id="newSavingsSubmit")
    private WebElement newSavingsSubmitButton;

    public void createNewSavings (List<SavingsAccountInfo> savingsAccountInfoList) {
        SavingsAccountInfo testDataSavingsAccount = savingsAccountInfoList.get(0);
        savingsMenu.click();
        newSavingsButton.click();

        assertEquals(ConfigReader.getPropertiesValue("digitalbank.createnewsavingsurl"), getDriver().getCurrentUrl(), "New Savings Button didn't take to the url" + ConfigReader.getPropertiesValue("digitalbank.createnewsavingsurl"));

        if(testDataSavingsAccount.getSavingsAccountType().equalsIgnoreCase("Savings")) {
            savingsAccountTypeRadioButton.click();
        } else if(testDataSavingsAccount.getSavingsAccountType().equalsIgnoreCase("Money Market")) {
            moneyMarketAccountTypeRadioButton.click();
        } else {
            throw new NoSuchElementException("Invalid savings account type option provided. Only supports Savings and Money Market");
        }

        if(testDataSavingsAccount.getAccountOwnership().equalsIgnoreCase("Individual")) {
            individualAccountOwnershipRadioButton.click();
        } else if(testDataSavingsAccount.getAccountOwnership().equalsIgnoreCase("Joint")) {
            jointAccountOwnershipRadioButton.click();
        } else {
            throw new NoSuchElementException("Invalid savings account ownership type option provided. Only supports Individual and Joint");
        }

        accountNameTextField.sendKeys(testDataSavingsAccount.getAccountName());
        initialDepositTextField.sendKeys(String.valueOf(testDataSavingsAccount.getInitialDepositAmount()));
        newSavingsSubmitButton.click();
    }
}
