package co.wedevx.digitalbank.automation.ui.pages;

import co.wedevx.digitalbank.automation.ui.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static co.wedevx.digitalbank.automation.ui.utils.Driver.getDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProfilePage extends BaseMenuPage {

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="mobilePhone")
    protected WebElement mobilePhoneTextField;

    @FindBy(id="workPhone")
    protected WebElement workPhoneTextField;

    @FindBy(xpath="//button[@class='btn btn-primary btn-sm']")
    protected WebElement submitProfileButton;

    @FindBy(xpath="//div[@class='sufee-alert alert with-close alert-success alert-dismissible fade show']")
    protected WebElement profileUpdatedConfirmationAlertDiv;

    public void updateMobileAndWorkPhoneNumbers(String mobilePhone, String workPhone) {
        userAreaMenu.click();
        myProfileButton.click();

        assertEquals(ConfigReader.getPropertiesValue("digitalbank.usersprofileurl"), getDriver().getCurrentUrl(), "My profile button didn't take to the url" + ConfigReader.getPropertiesValue("digitalbank.usersprofileurl"));

        mobilePhoneTextField.sendKeys(mobilePhone);
        workPhoneTextField.sendKeys(workPhone);

        submitProfileButton.click();
    }

    public String getProfileUpdatedConfirmationMessage() {
        return profileUpdatedConfirmationAlertDiv.getText();
    }

    public void updateMobilePhoneNumber(String mobilePhoneNumber) {
        userAreaMenu.click();
        myProfileButton.click();

        assertEquals(ConfigReader.getPropertiesValue("digitalbank.usersprofileurl"), getDriver().getCurrentUrl(), "My profile button didn't take to the url" + ConfigReader.getPropertiesValue("digitalbank.usersprofileurl"));
        mobilePhoneTextField.clear();
        mobilePhoneTextField.sendKeys(mobilePhoneNumber);

        submitProfileButton.click();
    }

    public String getMobilePhoneFieldErrorMessage() {
        return mobilePhoneTextField.getAttribute("validationMessage");
    }
}
