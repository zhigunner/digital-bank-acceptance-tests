package co.wedevx.digitalbank.automation.ui.pages;

import co.wedevx.digitalbank.automation.ui.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static co.wedevx.digitalbank.automation.ui.utils.Driver.getDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LinkExternalAccountPage extends BaseMenuPage {

    public LinkExternalAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//div[@class='sufee-alert alert with-close alert-danger alert-dismissible fade show']")
    private WebElement linkExternalAccountErrorMessage;


    public void goToLinkExternalAccountPage() {
        externalMenu.click();
        linkExternalAccountButton.click();

        assertEquals(ConfigReader.getPropertiesValue("digitalbank.linkexternalaccounturl"), getDriver().getCurrentUrl(), "Link external account button didn't take to the url" + ConfigReader.getPropertiesValue("digitalbank.linkexternalaccounturl"));
    }



    public String getLinkExternalAccountErrorMessage() {
        return linkExternalAccountErrorMessage.getText().substring(linkExternalAccountErrorMessage.getText().indexOf("There"), linkExternalAccountErrorMessage.getText().lastIndexOf("."));
    }

}
