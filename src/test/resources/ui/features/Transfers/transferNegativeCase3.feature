Feature: Transfer between accounts

  Scenario: Transfer between accounts without recipient
    Given the user logged in as "coach@arsenal.com" and "Emirates2004"
    When the user goes to the Transfer Between Accounts page
    And the user firstly selects the "Mikel Arteta First Checking Account (Standard Checking)" account then skips the recipient account and transfers "1000" dollars
    Then the user sees the "Please select an item in the list." validation message from the "ToAccount" field on the internal transfer page

  Scenario: Transfer between accounts without sender
    Given the user logged in as "coach@arsenal.com" and "Emirates2004"
    When the user goes to the Transfer Between Accounts page
    And the user firstly skips the sender account then skips the recipient account then selects "Test (Savings)" account and transfers "1000" dollars
    Then the user sees the "Please select an item in the list." validation message from the "FromAccount" field on the internal transfer page