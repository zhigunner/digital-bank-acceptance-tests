@skip
@Registration
Feature: Digital Bank Registration Page

  Background:
    Given The user with "lautaro@martinez.com" is not in DB
    And User navigates to Digital bank signup page

  @Test
  Scenario: Positive Case. As a user, I want to successfully create Digital Bank account
    When User creates account with following fields
      | title | firstName | lastName | gender | dateOfBirth | ssn         | email                | password            | confirmPassword     | address          | locality | region    | postalCode | country | homePhone    | mobilePhone  | workPhone    | termsCheckMark |
      | Mr.   | Lautaro   | Martinez | M      | 08/22/1997  | 349-28-7156 | lautaro@martinez.com | Inter@Martinez1997! | Inter@Martinez1997! | 789 Victory Lane | Milan    | Lombardia | 20121      | Italy   | 305-555-0142 | 305-555-0234 | 305-555-0345 | true           |
    Then User should be displayed with the message "Success Registration Successful. Please Login"
    Then The following user info should be saved in the db
      | title | firstName | lastName | gender | dateOfBirth | ssn         | email                | password            | confirmPassword     | address          | locality | region    | postalCode | country | homePhone    | mobilePhone  | workPhone    | accountNonExpired | accountNonLocked | credentialsNonExpired | enabled |
      | Mr.   | Lautaro   | Martinez | M      | 08/22/1997  | 349-28-7156 | lautaro@martinez.com | Inter@Martinez1997! | Inter@Martinez1997! | 789 Victory Lane | Milan    | Lombardia | 20121      | Italy   | 305-555-0142 | 305-555-0234 | 305-555-0345 | true              | true             | true                  | true    |

  @NegativeRegistrationCases
  Scenario Outline: Negative Test Cases. As a Digital Bank Administrator I want to make sure users can not register without providing all valid data
    When User creates account with following fields
      | title   | firstName   | lastName   | gender   | dateOfBirth   | ssn   | email   | password   | confirmPassword   | address   | locality   | region   | postalCode   | country   | homePhone   | mobilePhone   | workPhone   | termsCheckMark   |
      | <title> | <firstName> | <lastName> | <gender> | <dateOfBirth> | <ssn> | <email> | <password> | <confirmPassword> | <address> | <locality> | <region> | <postalCode> | <country> | <homePhone> | <mobilePhone> | <workPhone> | <termsCheckMark> |
    Then User should see the "<fieldWithError>" required field error message "<errorMessage>"

    Examples:
      | title | firstName | lastName | gender | dateOfBirth | ssn         | email                | password            | confirmPassword     | address          | locality | region    | postalCode | country | homePhone    | mobilePhone  | workPhone    | termsCheckMark | fieldWithError  | errorMessage                                  |
      |       |           |          |        |             |             |                      |                     |                     |                  |          |           |            |         |              |              |              |                | title           | Please select an item in the list.            |
      | Mr.   |           |          |        |             |             |                      |                     |                     |                  |          |           |            |         |              |              |              |                | firstName       | Please fill out this field.                   |
      | Mr.   | Lautaro   |          |        |             |             |                      |                     |                     |                  |          |           |            |         |              |              |              |                | lastName        | Please fill out this field.                   |
      | Mr.   | Lautaro   | Martinez |        |             |             |                      |                     |                     |                  |          |           |            |         |              |              |              |                | gender          | Please select one of these options.           |
      | Mr.   | Lautaro   | Martinez | M      |             |             |                      |                     |                     |                  |          |           |            |         |              |              |              |                | dateOfBirth     | Please fill out this field.                   |
      | Mr.   | Lautaro   | Martinez | M      | 08/22/1997  |             |                      |                     |                     |                  |          |           |            |         |              |              |              |                | ssn             | Please fill out this field.                   |
      | Mr.   | Lautaro   | Martinez | M      | 08/22/1997  | 349-28-7156 |                      |                     |                     |                  |          |           |            |         |              |              |              |                | email           | Please fill out this field.                   |
      | Mr.   | Lautaro   | Martinez | M      | 08/22/1997  | 349-28-7156 | lautaro@martinez.com |                     |                     |                  |          |           |            |         |              |              |              |                | password        | Please fill out this field.                   |
      | Mr.   | Lautaro   | Martinez | M      | 08/22/1997  | 349-28-7156 | lautaro@martinez.com | Inter@Martinez1997! |                     |                  |          |           |            |         |              |              |              |                | confirmPassword | Passwords Do Not Match                        |
      | Mr.   | Lautaro   | Martinez | M      | 08/22/1997  | 349-28-7156 | lautaro@martinez.com | Inter@Martinez1997! | Inter@Martinez1997! |                  |          |           |            |         |              |              |              |                | address         | Please fill out this field.                   |
      | Mr.   | Lautaro   | Martinez | M      | 08/22/1997  | 349-28-7156 | lautaro@martinez.com | Inter@Martinez1997! | Inter@Martinez1997! | 789 Victory Lane |          |           |            |         |              |              |              |                | locality        | Please fill out this field.                   |
      | Mr.   | Lautaro   | Martinez | M      | 08/22/1997  | 349-28-7156 | lautaro@martinez.com | Inter@Martinez1997! | Inter@Martinez1997! | 789 Victory Lane | Milan    |           |            |         |              |              |              |                | region          | Please fill out this field.                   |
      | Mr.   | Lautaro   | Martinez | M      | 08/22/1997  | 349-28-7156 | lautaro@martinez.com | Inter@Martinez1997! | Inter@Martinez1997! | 789 Victory Lane | Milan    | Lombardia |            |         |              |              |              |                | postalCode      | Please fill out this field.                   |
      | Mr.   | Lautaro   | Martinez | M      | 08/22/1997  | 349-28-7156 | lautaro@martinez.com | Inter@Martinez1997! | Inter@Martinez1997! | 789 Victory Lane | Milan    | Lombardia | 20121      |         |              |              |              |                | country         | Please fill out this field.                   |
      | Mr.   | Lautaro   | Martinez | M      | 08/22/1997  | 349-28-7156 | lautaro@martinez.com | Inter@Martinez1997! | Inter@Martinez1997! | 789 Victory Lane | Milan    | Lombardia | 20121      | Italy   |              |              |              |                | homePhone       | Please fill out this field.                   |
      | Mr.   | Lautaro   | Martinez | M      | 08/22/1997  | 349-28-7156 | lautaro@martinez.com | Inter@Martinez1997! | Inter@Martinez1997! | 789 Victory Lane | Milan    | Lombardia | 20121      | Italy   | 305-555-0142 | 305-555-0234 | 305-555-0345 |                | termsCheckMark  | Please check this box if you want to proceed. |