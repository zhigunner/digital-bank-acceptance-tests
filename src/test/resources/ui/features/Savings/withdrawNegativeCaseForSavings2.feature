Feature: Withdrawal from an unselected savings account

  Scenario: withdrawal from an unselected savings account
    Given the user logged in as "coach@arsenal.com" and "Emirates2004"
    When the user goes to the Withdraw page
    And the user skips the account name field and withdraw "10000.00"
    Then the user sees the "Please select an item in the list." validation message from the "AccountForWithdraw" field on the withdraw page