Feature: Deposit the checking account without deposit amount

  Scenario: deposit unselected checking account
    Given the user logged in as "will@turner.com" and "Turner@1977!"
    When the user goes to the Deposit page
    And the user selects the "Regular Checking (Standard Checking)" account and deposits it with "-100"
    Then the user sees the "Please match the requested format." validation message from the "DepositAmount" field