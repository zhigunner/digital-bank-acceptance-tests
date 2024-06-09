package co.wedevx.digitalbank.automation.ui.steps;

import co.wedevx.digitalbank.automation.ui.pages.RegistrationPage;
import co.wedevx.digitalbank.automation.ui.utils.DB_Utils;
import co.wedevx.digitalbank.automation.ui.utils.Driver;
import io.cucumber.java.*;

import static co.wedevx.digitalbank.automation.ui.utils.Driver.getDriver;

public class Hooks {
    @Before ("@Registration")
    public static void establishConnectionToDB() {
        DB_Utils.establishConnection();
    }

    @Before ("not @Registration")
    public void the_user_is_on_dbank_homepage() {
        getDriver().get("https://dbank-qa.wedevx.co/bank/login");
    }

    @After("not @NegativeRegistrationCases")
    public void afterEachScenario(Scenario scenario) {
        Driver.takeScreenShot(scenario);
        Driver.closeDriver();
    }

    @After
    public static void closeConnectionToDB() {
        DB_Utils.closeConnection();
    }
    @AfterAll
    public static void tearDown() {
        Driver.closeDriver();
    }
}
