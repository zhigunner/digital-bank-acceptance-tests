Feature: Deposit of existing checking account

  Scenario: Select and deposit checking account
    Given the user logged in as "coach@arsenal.com" and "Emirates2004"
    When the user goes to the Deposit page
    And the user selects the "Mikel Arteta First Checking Account (Standard Checking)" account and deposits it with "10000"
    Then the user makes sure that the operation is indicated in the transaction history
      | category | amount   | balance   |
      | Income   | 10000.00 | 250000.00 |