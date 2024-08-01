Feature: Deposit the checking account without deposit amount

  Scenario: deposit the checking account without deposit amount
    Given the user logged in as "will@turner.com" and "Turner@1977!"
    When the user goes to the Deposit page
    And the user selects the "Regular Checking (Standard Checking)" and skips the deposit amount field
    Then the user sees the "Please fill out this field." validation message from the "DepositAmount" field