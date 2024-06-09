package co.wedevx.digitalbank.automation.ui.steps.profile_test;

import co.wedevx.digitalbank.automation.ui.pages.RegistrationPage;
import co.wedevx.digitalbank.automation.ui.utils.ConfigReader;
import co.wedevx.digitalbank.automation.ui.utils.DB_Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static co.wedevx.digitalbank.automation.ui.utils.Driver.getDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegistrationSteps {
    RegistrationPage registrationPage = new RegistrationPage(getDriver());
    List<Map<String, Object>> nextValueList = new ArrayList<>();

    @Given("The user with {string} is not in DB")
    public void the_user_with_is_not_in_db(String email) {
        String queryForUserProfile = String.format("DELETE from user_profile WHERE email_address = '%s'", email);
        String queryForUsers = String.format("DELETE from users WHERE username = '%s'", email);

        String queryToGetNextValInHibernateSeqTable = String.format("SELECT * FROM hibernate_sequence");
        nextValueList = DB_Utils.runSQLSelectQuery(queryToGetNextValInHibernateSeqTable);


        DB_Utils.runSQLUpdateQuery(queryForUserProfile);
        DB_Utils.runSQLUpdateQuery(queryForUsers);
    }

    @Given("User navigates to Digital bank signup page")
    public void user_navigates_to_digital_bank_signup_page() {
        getDriver().get(ConfigReader.getPropertiesValue("digitalbank.registrationpageurl"));
        assertEquals("Digital Bank", getDriver().getTitle(), "Registration page Title mismatch!");
    }
    @When("User creates account with following fields")
    public void user_creates_account_with_following_fields(List<Map<String,String>> registrationTestDataListOfMap) {
        registrationPage.fillOutRegistrationForm(registrationTestDataListOfMap);


    }
    @Then("User should be displayed with the message {string}")
    public void user_should_be_displayed_with_the_message(String expectedSuccessMessage) {
        assertEquals(expectedSuccessMessage, registrationPage.getMessage(),"Success message mismatch!");

    }

    @Then("The following user info should be saved in the db")
    public void the_following_user_info_should_be_saved_in_the_db(List<Map<String, String>> expectedUserProfileInfoINDBList) {
        Map<String, String> expectedUserInfoMap = expectedUserProfileInfoINDBList.getFirst();
        String queryUserTable = String.format("SELECT * FROM users WHERE username='%s'", expectedUserInfoMap.get("email"));
        String queryUserProfile = String.format("SELECT * FROM user_profile WHERE email_address='%s'", expectedUserInfoMap.get("email"));

        List<Map<String, Object>> actualUserInfoList = DB_Utils.runSQLSelectQuery(queryUserTable);
        List<Map<String, Object>> actualUserProfileInfoList = DB_Utils.runSQLSelectQuery(queryUserProfile);

        assertEquals(1, actualUserInfoList.size(), "registration generated unexpected number of users");
        assertEquals(1, actualUserProfileInfoList.size(), "registration generated unexpected number of user profiles");

        Map<String, Object> actualUserInfoMap = actualUserInfoList.getFirst();
        Map<String, Object> actualUserProfileInfoMap = actualUserProfileInfoList.getFirst();

        assertEquals(expectedUserInfoMap.get("title"), actualUserProfileInfoMap.get("title"), "registration generated wrong title");
        assertEquals(expectedUserInfoMap.get("firstName"), actualUserProfileInfoMap.get("first_name"), "registration generated wrong first name");
        assertEquals(expectedUserInfoMap.get("lastName"), actualUserProfileInfoMap.get("last_name"), "registration generated wrong last name");
        assertEquals(expectedUserInfoMap.get("gender"), actualUserProfileInfoMap.get("gender"), "registration generated wrong gender");
        //assertEquals(expectedUserInfoMap.get("dateOfBirth"), actualUserProfileInfoMap.get("dob"), "registration generated wrong date of birth");
        assertEquals(expectedUserInfoMap.get("ssn"), actualUserProfileInfoMap.get("ssn"), "registration generated wrong ssn");
        assertEquals(expectedUserInfoMap.get("email"), actualUserProfileInfoMap.get("email_address"), "registration generated wrong email");
        assertEquals(expectedUserInfoMap.get("address"), actualUserProfileInfoMap.get("address"), "registration generated wrong address");
        assertEquals(expectedUserInfoMap.get("locality"), actualUserProfileInfoMap.get("locality"), "registration generated wrong locality");
        assertEquals(expectedUserInfoMap.get("region"), actualUserProfileInfoMap.get("region"), "registration generated wrong region");
        assertEquals(expectedUserInfoMap.get("postalCode"), actualUserProfileInfoMap.get("postal_code"), "registration generated wrong postal code");
        assertEquals(expectedUserInfoMap.get("country"), actualUserProfileInfoMap.get("country"), "registration generated wrong country");
        assertEquals(expectedUserInfoMap.get("homePhone"), actualUserProfileInfoMap.get("home_phone"), "registration generated wrong home phone");
        assertEquals(expectedUserInfoMap.get("mobilePhone"), actualUserProfileInfoMap.get("mobile_phone"), "registration generated wrong mobile phone");
        assertEquals(expectedUserInfoMap.get("workPhone"), actualUserProfileInfoMap.get("work_phone"), "registration generated wrong work phone");

        //validate users table
        assertEquals(expectedUserInfoMap.get("accountNonExpired"), String.valueOf(actualUserInfoMap.get("account_non_expired")), "accountNonExpired mismatch upon registration");
        assertEquals(expectedUserInfoMap.get("accountNonLocked"), String.valueOf(actualUserInfoMap.get("account_non_locked")), "accountNonLocked mismatch upon registration");
        assertEquals(expectedUserInfoMap.get("credentialsNonExpired"), String.valueOf(actualUserInfoMap.get("credentials_non_expired")), "credentialsNonExpired mismatch upon registration");
        assertEquals(expectedUserInfoMap.get("enabled"), String.valueOf(actualUserInfoMap.get("enabled")), "account enabled mismatch upon registration");
        assertEquals(expectedUserInfoMap.get("email"), actualUserInfoMap.get("username"), "account username mismatch upon registration");

        assertEquals((nextValueList.getFirst().get("next_val")), actualUserInfoMap.get("id"), "ID mismatch");

        long expectedUserProfileId = Integer.parseInt(String.valueOf(nextValueList.getFirst().get("next_val")));
        assertEquals(++expectedUserProfileId, actualUserProfileInfoMap.get("id"), "ID mismatch");


    }

    @Then("User should see the {string} required field error message {string}")
    public void user_should_see_the_required_field_error_message(String fieldName, String expectedErrorMessage) {
       String actualErrorMessage = registrationPage.getRequiredFieldErrorMessage(fieldName);
       assertEquals(expectedErrorMessage, actualErrorMessage, "the error message of required " + fieldName + " mismatch");
    }
}
