Feature: Withdrawal of an amount more than 25$ than the current balance

  Scenario: Select and withdraw money from savings account
    Given the user logged in as "coach@arsenal.com" and "Emirates2004"
    When the user goes to the Withdraw page
    And the user selects the "Test (Savings)" account and withdraws "125.00"
    Then the user validates the new amount on the View Savings page the fee will be applied for the overdraft operation
      | category       | amount | balance |
      | Fees & Charges | -10.00 | -35.00  |