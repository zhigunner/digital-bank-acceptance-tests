Feature: Transfer between accounts

  Scenario: Transfer between existing accounts
    Given the user logged in as "coach@arsenal.com" and "Emirates2004"
    When the user goes to the Transfer Between Accounts page
    And the user firstly selects the "Mikel Arteta First Checking Account (Standard Checking)" account then selects "Test (Savings)" account and transfers "1000" dollars
    Then the user makes sure that the operation is indicated in the transaction history on the View Savings Accounts page
      | category | amount | balance |
      | Income   | 1000   | 4100    |


