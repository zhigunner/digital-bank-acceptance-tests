Feature: Withdrawal of an amount more than 25$ than the current balance

  Scenario: Select and withdraw money from savings account
    Given the user logged in as "will@turner.com" and "Turner@1977!"
    When the user goes to the Withdraw page
    And the user selects the "Empty Savings (Savings)" account and withdraws "25.00"
    Then the user confirms the new "Empty Savings (Savings)" account amount on the View Savings page, a fee will be charged for the overdraft transaction
      | category       | amount | balance |
      | Fees & Charges | -10.00 | -35.00  |