Feature: Transfer between accounts

  Scenario: Transfer between existing accounts
    Given the user logged in as "will@turner.com" and "Turner@1977!"
    When the user goes to the Transfer Between Accounts page
    And the user firstly selects the "Family Checking (Standard Checking)" account then selects "Regular Checking (Standard Checking)" account and transfers "1000" dollars
    Then the user makes sure that the transfer transaction with the account "Regular Checking" is indicated in the transaction history
      | category | amount |
      | Income   | 1000   |


