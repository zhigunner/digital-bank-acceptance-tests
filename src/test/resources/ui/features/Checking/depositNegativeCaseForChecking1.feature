Feature: Deposit unselected checking account

  Scenario: deposit unselected checking account
    Given the user logged in as "coach@arsenal.com" and "Emirates2004"
    When the user goes to the Deposit page
    And the user skips the account name field and deposits "10000.00"
    Then the user sees the "Please select an item in the list." validation message from the "AccountForDeposit" field