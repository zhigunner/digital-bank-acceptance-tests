Feature: Withdrawal from the savings account with unacceptable withdraw amount

  Scenario: Withdrawal from the savings account with alphabetic characters withdraw amount
    Given the user logged in as "coach@arsenal.com" and "Emirates2004"
    When the user goes to the Withdraw page
    And the user selects the "Vacation (Savings)" account and withdraws "OneHundred"
    Then the user sees the "Please match the requested format." validation message from the "WithdrawAmount" field on the withdraw page

  Scenario: Withdrawal from the savings account with numeric values mixed with special characters withdraw amount
    Given the user logged in as "coach@arsenal.com" and "Emirates2004"
    When the user goes to the Withdraw page
    And the user selects the "Vacation (Savings)" account and withdraws "100,99"
    Then the user sees the "Please match the requested format." validation message from the "WithdrawAmount" field on the withdraw page


