package co.wedevx.digitalbank.automation.ui.pages;

import co.wedevx.digitalbank.automation.ui.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import static co.wedevx.digitalbank.automation.ui.utils.Driver.getDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class VISADirectTransferPage extends BaseMenuPage{
    public VISADirectTransferPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="extAccount")
    protected WebElement selectVISAAccountNumberDropdown;

    @FindBy(id="extAmount")
    protected WebElement transferAmountTextField;

    @FindBy(xpath="//button[@class='btn btn-primary btn-sm']")
    protected WebElement submitToVISAButton;

    public void goToVISADirectTransferPage() {
        visaDirectTransferMenu.click();
        assertEquals(ConfigReader.getPropertiesValue("digitalbank.visadirecttransferurl"), getDriver().getCurrentUrl(), "VISA Direct transfer menu button didn't take to the url" + ConfigReader.getPropertiesValue("digitalbank.visadirecttransferurl"));
    }

    public void VISA_transfer(String accountNumber, String transferAmount) {
        Select titleSelect = new Select(selectVISAAccountNumberDropdown);
        titleSelect.selectByVisibleText(accountNumber);

        transferAmountTextField.sendKeys(transferAmount);
        submitToVISAButton.click();
    }

}
