Feature: Transfer between accounts

  Scenario: Transfer between accounts without sender
    Given the user logged in as "will@turner.com" and "Turner@1977!"
    When the user goes to the Transfer Between Accounts page
    And the user firstly skips the sender account then skips the recipient account then selects "Family Checking (Standard Checking)" account and transfers "1000" dollars
    Then the user sees the "Please select an item in the list." validation message from the "FromAccount" field on the internal transfer page