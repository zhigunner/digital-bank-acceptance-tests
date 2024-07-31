Feature: Withdrawal of money from existing savings account

  Scenario: Select and withdraw money from savings account
    Given the user logged in as "will@turner.com" and "Turner@1977!"
    When the user goes to the Withdraw page
    And the user selects the "Business Savings (Savings)" account and withdraws "1000.00"
    Then the user makes sure that the savings withdraw transaction with the account "Business Savings" is indicated in the transaction history
      | category | amount   |
      | Misc     | -1000.00 |