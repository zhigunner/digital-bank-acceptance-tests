Feature: Login and Logout

  Scenario: Login and Logout of user's bank account
    Given user logged into the bank system as "coach@arsenal.com" and "Emirates2004"
    When user clicks on the "Logout" button
    Then user sees the "Logout completed" message