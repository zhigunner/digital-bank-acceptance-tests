Feature: Transfer between accounts

  Scenario: Transfer between existing accounts with the negative amount
    Given the user logged in as "will@turner.com" and "Turner@1977!"
    When the user goes to the Transfer Between Accounts page
    And the user firstly selects the "Regular Checking (Standard Checking)" account then selects "Family Checking (Standard Checking)" account and transfers "one hundred dollars" dollars
    Then the user sees the "Please match the requested format." validation message from the "TransferAmount" field on the internal transfer page