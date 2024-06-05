Feature: Withdrawal of money from existing savings account

  Scenario: Select and withdraw money from savings account
    Given the user logged in as "coach@arsenal.com" and "Emirates2004"
    When the user goes to the Withdraw page
    And the user selects the "League (Savings)" account and withdraws "1000.00"
    Then the user makes sure that the operation is indicated in the transaction history on the View Savings Accounts page
      | category | amount   | balance |
      | Misc     | -1000.00 | 7000.00 |