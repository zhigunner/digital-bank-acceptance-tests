Feature: Deposit of existing checking account

  Scenario: Select and deposit checking account
    Given the user logged in as "will@turner.com" and "Turner@1977!"
    When the user goes to the Deposit page
    And the user selects the "Family Checking (Standard Checking)" account and deposits it with "135000"
    Then the user makes sure that the checking deposit transaction with the account "Family Checking" is indicated in the transaction history
      | category | amount    |
      | Income   | 135000.00 |