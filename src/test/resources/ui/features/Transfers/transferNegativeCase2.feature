Feature: Transfer between accounts

  Scenario: Transfer between accounts without recipient
    Given the user logged in as "will@turner.com" and "Turner@1977!"
    When the user goes to the Transfer Between Accounts page
    And the user firstly selects the "Regular Checking (Standard Checking)" account then skips the recipient account and transfers "1000" dollars
    Then the user sees the "Please select an item in the list." validation message from the "ToAccount" field on the internal transfer page