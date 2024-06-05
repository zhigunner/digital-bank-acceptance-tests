Feature: Transfer between accounts

  Scenario: Transfer between existing accounts with the invalid amount
    Given the user logged in as "coach@arsenal.com" and "Emirates2004"
    When the user goes to the Transfer Between Accounts page
    And the user firstly selects the "Test (Savings)" account then selects "Vacation (Savings)" account and transfers "4200" dollars
    Then the user sees the "The amount ($4200.00) requested for transfer is more than the available balance ($4100.00)" error message on the transfer page

  Scenario: Transfer between existing accounts with the negative amount
    Given the user logged in as "coach@arsenal.com" and "Emirates2004"
    When the user goes to the Transfer Between Accounts page
    And the user firstly selects the "Mikel Arteta First Checking Account (Standard Checking)" account then selects "Test (Savings)" account and transfers "-100" dollars
    Then the user sees the "Please match the requested format." validation message from the "TransferAmount" field on the internal transfer page

  Scenario: Transfer between existing accounts with the negative amount
    Given the user logged in as "coach@arsenal.com" and "Emirates2004"
    When the user goes to the Transfer Between Accounts page
    And the user firstly selects the "Mikel Arteta First Checking Account (Standard Checking)" account then selects "Test (Savings)" account and transfers "one hundred dollars" dollars
    Then the user sees the "Please match the requested format." validation message from the "TransferAmount" field on the internal transfer page

  Scenario: Transfer between existing accounts with the negative amount
    Given the user logged in as "coach@arsenal.com" and "Emirates2004"
    When the user goes to the Transfer Between Accounts page
    And the user firstly selects the "Mikel Arteta First Checking Account (Standard Checking)" account then selects "Test (Savings)" account and transfers "100!" dollars
    Then the user sees the "Please match the requested format." validation message from the "TransferAmount" field on the internal transfer page


