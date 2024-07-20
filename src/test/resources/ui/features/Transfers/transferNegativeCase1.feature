Feature: Transfer between accounts

  Scenario: Transfer between existing accounts without a transfer amount
    Given the user logged in as "will@turner.com" and "Turner@1977!"
    When the user goes to the Transfer Between Accounts page
    And the user firstly selects the "Regular Checking (Standard Checking)" account then selects "Family Checking (Standard Checking)" account and skips the transfer amount field
    Then the user sees the "Please fill out this field." validation message from the "TransferAmount" field on the internal transfer page