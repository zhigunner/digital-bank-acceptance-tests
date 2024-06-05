Feature: Transfer between accounts

  Scenario: Transfer between existing accounts without a transfer amount
    Given the user logged in as "coach@arsenal.com" and "Emirates2004"
    When the user goes to the Transfer Between Accounts page
    And the user firstly selects the "Mikel Arteta First Checking Account (Standard Checking)" account then selects "Test (Savings)" account and skips the transfer amount field
    Then the user sees the "Please fill out this field." validation message from the "TransferAmount" field on the internal transfer page