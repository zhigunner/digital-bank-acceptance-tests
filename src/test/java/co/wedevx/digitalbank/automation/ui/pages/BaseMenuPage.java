package co.wedevx.digitalbank.automation.ui.pages;

import co.wedevx.digitalbank.automation.ui.utils.ConfigReader;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static co.wedevx.digitalbank.automation.ui.utils.Driver.getDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BaseMenuPage extends BasePage {

    public BaseMenuPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(id="home-menu-item")
    protected WebElement homeButton;

    @FindBy(id="checking-menu")
    protected WebElement checkingMenu;
    @FindBy(id="view-checking-menu-item")
    protected WebElement viewCheckingButton;
    @FindBy(id="new-checking-menu-item")
    protected WebElement newCheckingButton;

    @FindBy(id="savings-menu")
    protected WebElement savingsMenu;
    @FindBy(id="view-savings-menu-item")
    protected WebElement viewSavingsButton;
    @FindBy(id="new-savings-menu-item")
    protected WebElement newSavingsButton;

    @FindBy(id="external-accounts-menu")
    protected WebElement externalMenu;
    @FindBy(id="link-external-menu-item")
    protected WebElement linkExternalAccountButton;
    @FindBy(id="view-external-menu-item")
    protected WebElement viewExternalAccounts;

    @FindBy(id="deposit-menu-item")
    protected WebElement depositMenu;

    @FindBy(id="withdraw-menu-item")
    protected WebElement withdrawMenu;

    @FindBy(id="transfer-menu-item")
    protected WebElement transferBetweenAccountsMenu;

    @FindBy(id="visa-transfer-menu-item")
    protected WebElement visaDirectTransferMenu;

    @FindBy(id="searchLocations")
    protected WebElement searchButton;

    @FindBy(id="notification")
    protected WebElement notificationsButton;

    @FindBy(id="message")
    protected WebElement messagesButton;

    @FindBy(xpath="//div[@class='dropdown-menu show']/p[@style='width: max-content']")
    protected WebElement messageReport;

    @FindBy(id="aboutLink")
    protected WebElement aboutLink;
    @FindBy(xpath="//div[@class='modal-body']/p")
    protected WebElement modalBodyParagraph;

    @FindBy(id="language-select")
    protected WebElement languageSelectButton;

    @FindBy(xpath="//div[@class='user-area dropdown']")
    protected WebElement userAreaMenu;
    @FindBy(xpath="//a[@href='/bank/user/profile']")
    protected WebElement myProfileButton;
    @FindBy(xpath="//a[@href='/bank/user/password']")
    protected WebElement changePasswordButton;
    @FindBy(xpath="//a[@href='/bank/logout']")
    protected WebElement logoutButton;

    public void goToHomePage() {
        homeButton.click();
    }

    public void userAreaOptions(String option) {
        userAreaMenu.click();

        if(option.equalsIgnoreCase("My Profile")) {
            myProfileButton.click();
        } else if(option.equalsIgnoreCase("Change Password")) {
            changePasswordButton.click();
        } else if(option.equalsIgnoreCase("Logout")) {
            logoutButton.click();
            assertEquals(ConfigReader.getPropertiesValue("digitalbank.logouturl"), getDriver().getCurrentUrl(), "Logout button didn't take to the url" + ConfigReader.getPropertiesValue("digitalbank.logouturl"));
        }
    }

    public void messagesTab() {
        messagesButton.click();
    }

    public String getReportAboutUnreadMessages() {
        return messageReport.getText();
    }

    public void aboutTab() {
        aboutLink.click();
    }

}
