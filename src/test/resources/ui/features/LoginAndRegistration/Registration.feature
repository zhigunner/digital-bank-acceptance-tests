@Registration
Feature: Digital Bank Registration Page

  Background:
    Given User navigates to Digital bank signup page


  Scenario: Positive Case. As a user, I want to successfully create Digital Bank account
    When User creates account with following fields with mocked email and ssn
      | title | firstName | lastName | gender | dateOfBirth | ssn    | email  | password  | confirmPassword | address       | locality | region | postalCode | country | homePhone     | mobilePhone   | workPhone     |
      | Mr.   | Dwight    | Schrute  | M      | 01/20/1966  | random | random | Dwight66! | Dwight66!       | 234 W Ohio St | Scranton | PA     | 18509      | USA     | (645)747-4576 | (736)746-9124 | (943)645-9283 |
    Then User should be displayed with the message "Success Registration Successful. Please Login"

  @NegativeRegistrationCases
  Scenario Outline: Negative Test Cases. As a Digital Bank Administrator I want to make sure users can not register without providing all valid data
    When User creates account with following fields with mocked email and ssn
      | title   | firstName   | lastName   | gender   | dateOfBirth   | ssn   | email   | password   | confirmPassword   | address   | locality   | region   | postalCode   | country   | homePhone   | mobilePhone   | workPhone   | termsCheckMark   |
      | <title> | <firstName> | <lastName> | <gender> | <dateOfBirth> | <ssn> | <email> | <password> | <confirmPassword> | <address> | <locality> | <region> | <postalCode> | <country> | <homePhone> | <mobilePhone> | <workPhone> | <termsCheckMark> |
    Then User should see the "<fieldWithError>" required field error message "<errorMessage>"

    Examples:
      | title | firstName | lastName | gender | dateOfBirth | ssn | email | password | confirmPassword | address | locality | region | postalCode | country | homePhone | mobilePhone | workPhone | termsCheckMark | fieldWithError  | errorMessage                        |
      |       |           |          |        |             |     |       |          |                 |         |          |        |            |         |           |             |           |                | title           | Please select an item in the list.  |
      | Mr.   |           |          |        |             |     |       |          |                 |         |          |        |            |         |           |             |           |                | firstName       | Please fill out this field.         |
      | Mr.   | Jim       |          |        |             |     |       |          |                 |         |          |        |            |         |           |             |           |                | lastName        | Please fill out this field.         |
      | Mr.   | Jim       | Halpert  |        |             |     |       |          |                 |         |          |        |            |         |           |             |           |                | gender          | Please select one of these options. |
      | Mr.   | Jim       | Halpert  | M      |             |     |       |          |                 |         |          |        |            |         |           |             |           |                | dateOfBirth     | Please fill out this field.         |
      | Mr.   | Jim       | Halpert  | M      | 01/01/1990  |     |       |          |                 |         |          |        |            |         |           |             |           |                | ssn             | Please fill out this field.         |

