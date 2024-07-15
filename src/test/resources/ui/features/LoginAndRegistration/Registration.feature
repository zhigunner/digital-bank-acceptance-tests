@Registration
Feature: Digital Bank Registration Page

  Background:
    Given The user with "dwight@office.com" is not in DB
    And User navigates to Digital bank signup page

  @Test
  Scenario: Positive Case. As a user, I want to successfully create Digital Bank account
    When User creates account with following fields
      | title | firstName | lastName | gender | dateOfBirth | ssn         | email              | password  | confirmPassword | address                 | locality | region | postalCode | country | homePhone    | mobilePhone  | workPhone    | termsCheckMark |
      | Mr.   | Dwight    | Schrute  | M      | 01/20/1966  | 123-44-2235 | dwight@schrute.com | Dwight66! | Dwight66!       | 1725 Schrute Farms Road | Scranton | PA     | 18509      | US      | 645-747-4576 | 736-746-9124 | 943-645-9283 | true           |
    Then User should be displayed with the message "Success Registration Successful. Please Login"
    Then The following user info should be saved in the db
      | title | firstName | lastName | gender | dateOfBirth | ssn         | email              | password  | confirmPassword | address                 | locality | region | postalCode | country | homePhone    | mobilePhone  | workPhone    | accountNonExpired | accountNonLocked | credentialsNonExpired | enabled |
      | Mr.   | Dwight    | Schrute  | M      | 01/20/1966  | 123-44-2235 | dwight@schrute.com | Dwight66! | Dwight66!       | 1725 Schrute Farms Road | Scranton | PA     | 18509      | US      | 645-747-4576 | 736-746-9124 | 943-645-9283 | true              | true             | true                  | true    |

  @NegativeRegistrationCases
  Scenario Outline: Negative Test Cases. As a Digital Bank Administrator I want to make sure users can not register without providing all valid data
    When User creates account with following fields
      | title   | firstName   | lastName   | gender   | dateOfBirth   | ssn   | email   | password   | confirmPassword   | address   | locality   | region   | postalCode   | country   | homePhone   | mobilePhone   | workPhone   | termsCheckMark   |
      | <title> | <firstName> | <lastName> | <gender> | <dateOfBirth> | <ssn> | <email> | <password> | <confirmPassword> | <address> | <locality> | <region> | <postalCode> | <country> | <homePhone> | <mobilePhone> | <workPhone> | <termsCheckMark> |
    Then User should see the "<fieldWithError>" required field error message "<errorMessage>"

    Examples:
      | title | firstName | lastName | gender | dateOfBirth | ssn         | email             | password  | confirmPassword | address       | locality | region | postalCode | country | homePhone     | mobilePhone   | workPhone     | termsCheckMark | fieldWithError  | errorMessage                                  |
      |       |           |          |        |             |             |                   |           |                 |               |          |        |            |         |               |               |               |                | title           | Please select an item in the list.            |
      | Mr.   |           |          |        |             |             |                   |           |                 |               |          |        |            |         |               |               |               |                | firstName       | Please fill out this field.                   |
      | Mr.   | Dwight    |          |        |             |             |                   |           |                 |               |          |        |            |         |               |               |               |                | lastName        | Please fill out this field.                   |
      | Mr.   | Dwight    | Schrute  |        |             |             |                   |           |                 |               |          |        |            |         |               |               |               |                | gender          | Please select one of these options.           |
      | Mr.   | Dwight    | Schrute  | M      |             |             |                   |           |                 |               |          |        |            |         |               |               |               |                | dateOfBirth     | Please fill out this field.                   |
      | Mr.   | Dwight    | Schrute  | M      | 01/20/1966  |             |                   |           |                 |               |          |        |            |         |               |               |               |                | ssn             | Please fill out this field.                   |
      | Mr.   | Dwight    | Schrute  | M      | 01/20/1966  | 123-44-2235 |                   |           |                 |               |          |        |            |         |               |               |               |                | email           | Please fill out this field.                   |
      | Mr.   | Dwight    | Schrute  | M      | 01/20/1966  | 123-44-2235 | dwight@office.com |           |                 |               |          |        |            |         |               |               |               |                | password        | Please fill out this field.                   |
      | Mr.   | Dwight    | Schrute  | M      | 01/20/1966  | 123-44-2235 | dwight@office.com | Dwight66! |                 |               |          |        |            |         |               |               |               |                | confirmPassword | Passwords Do Not Match                        |
      | Mr.   | Dwight    | Schrute  | M      | 01/20/1966  | 123-44-2235 | dwight@office.com | Dwight66! | Dwight66!       |               |          |        |            |         |               |               |               |                | address         | Please fill out this field.                   |
      | Mr.   | Dwight    | Schrute  | M      | 01/20/1966  | 123-44-2235 | dwight@office.com | Dwight66! | Dwight66!       | 234 W Ohio St |          |        |            |         |               |               |               |                | locality        | Please fill out this field.                   |
      | Mr.   | Dwight    | Schrute  | M      | 01/20/1966  | 123-44-2235 | dwight@office.com | Dwight66! | Dwight66!       | 234 W Ohio St | Scranton |        |            |         |               |               |               |                | region          | Please fill out this field.                   |
      | Mr.   | Dwight    | Schrute  | M      | 01/20/1966  | 123-44-2235 | dwight@office.com | Dwight66! | Dwight66!       | 234 W Ohio St | Scranton | PA     |            |         |               |               |               |                | postalCode      | Please fill out this field.                   |
      | Mr.   | Dwight    | Schrute  | M      | 01/20/1966  | 123-44-2235 | dwight@office.com | Dwight66! | Dwight66!       | 234 W Ohio St | Scranton | PA     | 18509      |         |               |               |               |                | country         | Please fill out this field.                   |
      | Mr.   | Dwight    | Schrute  | M      | 01/20/1966  | 123-44-2235 | dwight@office.com | Dwight66! | Dwight66!       | 234 W Ohio St | Scranton | PA     | 18509      | USA     |               |               |               |                | homePhone       | Please fill out this field.                   |
      | Mr.   | Dwight    | Schrute  | M      | 01/20/1966  | 123-44-2235 | dwight@office.com | Dwight66! | Dwight66!       | 234 W Ohio St | Scranton | PA     | 18509      | USA     | (645)747-4576 | (736)746-9124 | (943)645-9283 |                | termsCheckMark  | Please check this box if you want to proceed. |