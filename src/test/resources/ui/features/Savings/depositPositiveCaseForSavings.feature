Feature: Deposit of existing savings account

  Scenario: Select and deposit savings account
    Given the user logged in as "coach@arsenal.com" and "Emirates2004"
    When the user goes to the Deposit page
    And the user selects the "League (Savings)" account and deposits it with "50.00"
    Then the user makes sure that the operation is indicated in the transaction history on the View Savings Accounts page
      | category | amount | balance  |
      | Income   | 50.00  | 10300.00 |