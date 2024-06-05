package co.wedevx.digitalbank.automation.ui.steps;

import co.wedevx.digitalbank.automation.ui.pages.VISADirectTransferPage;
import co.wedevx.digitalbank.automation.ui.pages.VISATransferResultsPage;
import co.wedevx.digitalbank.automation.ui.utils.ConfigReader;
import co.wedevx.digitalbank.automation.ui.utils.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import static co.wedevx.digitalbank.automation.ui.utils.Driver.getDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BrokenFunctionality2 {
    WebDriver driver = Driver.getDriver();
    VISADirectTransferPage visaDirectTransferPage = new VISADirectTransferPage(driver);
    VISATransferResultsPage visaTransferResultsPage = new VISATransferResultsPage(driver);

    @When("user goes to the VISA Direct Transfer page")
    public void user_goes_to_the_visa_direct_transfer_page() {
        visaDirectTransferPage.goToVISADirectTransferPage();
    }
    @When("user selects {string} and transfers {string} dollars")
    public void user_selects_and_transfers_dollars(String accountNumber, String transferAmount) {
        visaDirectTransferPage.VISA_transfer(accountNumber, transferAmount);
    }
    @Then("user is transferred to the VISA Transfer Results page and there he sees the {string} error message")
    public void user_is_transferred_to_the_visa_transfer_results_page_and_there_he_sees_the_error_message(String expectedMessage) {
        assertEquals(ConfigReader.getPropertiesValue("digitalbank.visatransferresultsurl"), getDriver().getCurrentUrl(), "You're not on the VISA Transfer page!");
        String actualErrorMessage = visaTransferResultsPage.getVISATransferResultsErrorMessage();
        assertEquals(expectedMessage, actualErrorMessage, "Error messages don't match");
    }

}
