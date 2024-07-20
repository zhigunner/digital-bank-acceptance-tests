Feature: Withdrawal from the savings account with unacceptable withdraw amount

  Scenario: Withdrawal from the savings account with alphabetic characters withdraw amount
    Given the user logged in as "will@turner.com" and "Turner@1977!"
    When the user goes to the Withdraw page
    And the user selects the "Business Savings (Savings)" account and withdraws "OneHundred"
    Then the user sees the "Please match the requested format." validation message from the "WithdrawAmount" field on the withdraw page

  Scenario: Withdrawal from the savings account with numeric values mixed with special characters withdraw amount
    Given the user logged in as "will@turner.com" and "Turner@1977!"
    When the user goes to the Withdraw page
    And the user selects the "Business Savings (Savings)" account and withdraws "100,99"
    Then the user sees the "Please match the requested format." validation message from the "WithdrawAmount" field on the withdraw page


