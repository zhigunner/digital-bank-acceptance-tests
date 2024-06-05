Feature: Deposit the checking account with unacceptable deposit amount

  Scenario: deposit the checking account with unacceptable deposit amount
    Given the user logged in as "coach@arsenal.com" and "Emirates2004"
    When the user goes to the Deposit page
    And the user selects the "Mikel Arteta First Checking Account (Standard Checking)" account and deposits it with "100!"
    Then the user sees the "Please match the requested format." validation message from the "DepositAmount" field