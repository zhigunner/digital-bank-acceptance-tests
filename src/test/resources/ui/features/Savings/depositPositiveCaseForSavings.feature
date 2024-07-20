Feature: Deposit of existing savings account

  Scenario: Select and deposit savings account
    Given the user logged in as "will@turner.com" and "Turner@1977!"
    When the user goes to the Deposit page
    And the user selects the "Business Savings (Savings)" account and deposits it with "250.00"
    Then the user makes sure that the savings deposit transaction with the account "Business Savings" is indicated in the transaction history
      | category | amount |
      | Income   | 250.00 |