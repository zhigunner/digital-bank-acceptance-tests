package co.wedevx.digitalbank.automation.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VISATransferResultsPage extends BaseMenuPage{
    public VISATransferResultsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//div[@class='sufee-alert alert with-close alert-danger alert-dismissible fade show']")
    private WebElement visaTransferResultsErrorMessage;

    public String getVISATransferResultsErrorMessage() {
        return visaTransferResultsErrorMessage.getText().substring(visaTransferResultsErrorMessage.getText().indexOf("The"), visaTransferResultsErrorMessage.getText().lastIndexOf("."));
    }
}
