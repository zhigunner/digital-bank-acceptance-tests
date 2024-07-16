package co.wedevx.digitalbank.automation.ui.pages;

import co.wedevx.digitalbank.automation.ui.utils.MockData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Map;

public class RegistrationPage extends BasePage {

    public RegistrationPage (WebDriver driver) {
        super(driver);
    }

    MockData mockData = new MockData();

    @FindBy(id="title")
    private WebElement titleDropDown;

    @FindBy(id="firstName")
    private WebElement firstNameTextBox;

    @FindBy(id="lastName")
    private  WebElement lastNameTextBox;

    @FindBy(xpath="//label[@for='male']//input")
    private  WebElement genderMRadioButton;

    @FindBy(xpath="//label[@for='female']//input")
    private  WebElement genderFRadioButton;

    @FindBy(id="dob")
    private WebElement dobTextBox;

    @FindBy(id="ssn")
    private WebElement ssnTextBox;

    @FindBy(id="emailAddress")
    private WebElement emailAddressTextBox;

    @FindBy(id="password")
    private WebElement passwordTextBox;

    @FindBy(id="confirmPassword")
    private WebElement confirmPasswordTextBox;

    @FindBy(xpath="//button[@class='btn btn-primary btn-flat m-b-30 m-t-30']")
    private WebElement submitButton;

    @FindBy(xpath="//button[@type='submit']")
    private WebElement nextButton;

    @FindBy(id="address")
    private WebElement addressTextBox;

    @FindBy(id="locality")
    private WebElement localityTextBox;

    @FindBy(id="region")
    private  WebElement regionTextBox;

    @FindBy(id="postalCode")
    private WebElement postalCodeTextBox;

    @FindBy(id="country")
    private WebElement countryTextBox;

    @FindBy(id="homePhone")
    private WebElement homePhoneTextBox;

    @FindBy(id="mobilePhone")
    private WebElement mobilePhoneTextBox;

    @FindBy(id="workPhone")
    private WebElement workPhoneTextBox;

    @FindBy(id="agree-terms")
    private WebElement agreeTermsCheckBox;

    @FindBy(xpath="//button[@class='btn btn-primary btn-flat m-b-30 m-t-30']")
    private WebElement registrationButton;

    @FindBy(xpath="//div[@class='sufee-alert alert with-close alert-success alert-dismissible fade show']")
    private WebElement messageLabel;


    public void fillOutRegistrationForm(List<Map<String,String>> registrationPageTestDataListOfMap) {
        Select titleSelect = new Select(titleDropDown);
        Map<String,String> firstRow = registrationPageTestDataListOfMap.get(0);

        if(firstRow.get("title") != null) {
            titleSelect.selectByVisibleText(firstRow.get("title"));
        }

        if(firstRow.get("firstName") != null) {
            firstNameTextBox.sendKeys(firstRow.get("firstName"));
        }

        if(firstRow.get("lastName") != null) {
            lastNameTextBox.sendKeys(firstRow.get("lastName"));
        }

        if(firstRow.get("gender") != null) {
            if(firstRow.get("gender").equalsIgnoreCase("M")) {
                genderMRadioButton.click();
            } else if(firstRow.get("gender").equalsIgnoreCase("F")) {
                genderFRadioButton.click();
            } else {
                System.out.println("Wrong Gender");
            }
        }

        if(firstRow.get("dateOfBirth") != null) {
            dobTextBox.sendKeys(firstRow.get("dateOfBirth"));
        }

        if(firstRow.get("ssn") != null) {
            ssnTextBox.sendKeys(firstRow.get("ssn"));
        }

        if(firstRow.get("email") != null) {
           emailAddressTextBox.sendKeys(firstRow.get("email"));
        }

        if(firstRow.get("password") != null) {
            passwordTextBox.sendKeys(firstRow.get("password"));
        }

        if(firstRow.get("confirmPassword") != null) {
            confirmPasswordTextBox.sendKeys(firstRow.get("confirmPassword"));
        }

            nextButton.click();

        if(addressTextBox.isDisplayed()) {
            if(firstRow.get("address") != null) {
                addressTextBox.sendKeys(firstRow.get("address"));
            }

            if(firstRow.get("locality") != null) {
                localityTextBox.sendKeys(firstRow.get("locality"));
            }

            if(firstRow.get("region") != null) {
                regionTextBox.sendKeys(firstRow.get("region"));
            }

            if(firstRow.get("postalCode") != null) {
                postalCodeTextBox.sendKeys(firstRow.get("postalCode"));
            }

            if(firstRow.get("country") != null) {
                countryTextBox.sendKeys(firstRow.get("country"));
            }

            if(firstRow.get("homePhone") != null) {
                homePhoneTextBox.sendKeys(firstRow.get("homePhone"));
            }

            if(firstRow.get("mobilePhone") != null) {
                mobilePhoneTextBox.sendKeys(firstRow.get("mobilePhone"));
            }

            if(firstRow.get("workPhone") != null) {
                workPhoneTextBox.sendKeys(firstRow.get("workPhone"));
            }

            if(firstRow.get("termsCheckMark") != null) {
                if(firstRow.get("termsCheckMark").equalsIgnoreCase("true")) {
                    agreeTermsCheckBox.click();
                }
            }
            registrationButton.click();
        }
        }



    public String getMessage() {
        return messageLabel.getText().substring(0, messageLabel.getText().lastIndexOf("."));
    }

    public String getRequiredFieldErrorMessage(String fieldName) {
        switch (fieldName.toLowerCase()) {
            case "title":
                return titleDropDown.getAttribute("validationMessage");
            case "firstname":
                return firstNameTextBox.getAttribute("validationMessage");
            case "lastname":
                return lastNameTextBox.getAttribute("validationMessage");
            case "gender":
                return genderMRadioButton.getAttribute("validationMessage");
            case "dateofbirth":
                return dobTextBox.getAttribute("validationMessage");
            case "ssn":
                return ssnTextBox.getAttribute("validationMessage");
            case "email":
                return emailAddressTextBox.getAttribute("validationMessage");
            case "password":
                return passwordTextBox.getAttribute("validationMessage");
            case "confirmpassword":
                return confirmPasswordTextBox.getAttribute("validationMessage");
            case "address":
                return addressTextBox.getAttribute("validationMessage");
            case "locality":
                return localityTextBox.getAttribute("validationMessage");
            case "region":
                return regionTextBox.getAttribute("validationMessage");
            case "postalcode":
                return postalCodeTextBox.getAttribute("validationMessage");
            case "country":
                return countryTextBox.getAttribute("validationMessage");
            case "homephone":
                return homePhoneTextBox.getAttribute("validationMessage");
            case "mobilephone":
                return mobilePhoneTextBox.getAttribute("validationMessage");
            case "workphone":
                return workPhoneTextBox.getAttribute("validationMessage");
            case "termscheckmark":
                return agreeTermsCheckBox.getAttribute("validationMessage");
            default:
                return null;
        }
    }
}
