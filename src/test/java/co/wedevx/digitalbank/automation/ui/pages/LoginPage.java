package co.wedevx.digitalbank.automation.ui.pages;

import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "username")
    private WebElement usernameTxtBox;

    @FindBy(id = "password")
    private WebElement passwordTxtBox;

    @FindBy(id = "remember-me")
    private  WebElement remember_meCheckBox;

    @FindBy(xpath = "//button")
    private WebElement submitButton;

    @FindBy(xpath = "//a[contains(text(), 'Sign Up Here')]")
    private WebElement signUpPage;

    @FindBy(xpath="//div[@class='sufee-alert alert with-close alert-success alert-dismissible fade show']")
    private WebElement logoutConfirmationAlertDiv;

    //crate action methods
    public void login(String username, String password) {
        usernameTxtBox.sendKeys(username);
        passwordTxtBox.sendKeys(password);
        remember_meCheckBox.click();
        submitButton.click();
    }

    public String getLogoutConfirmationMessage() {
        return logoutConfirmationAlertDiv.getText();
    }


}
