Feature: Withdrawal of inaccessible amount from a Saving account

  Scenario: Withdrawal of inaccessible amount
    Given the user logged in as "coach@arsenal.com" and "Emirates2004"
    When the user goes to the Withdraw page
    And the user selects the "Test (Savings)" account and withdraws "26.00"
    Then the user sees the "The withdraw amount ($26.00) is greater than the available balance ($0.00) and overdraft limit ($25.00)" error message