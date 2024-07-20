Feature: Withdraw from the savings account without withdraw amount

  Scenario: withdraw from the checking account
    Given the user logged in as "will@turner.com" and "Turner@1977!"
    When the user goes to the Withdraw page
    And the user selects the "Business Savings (Savings)" and skips the withdraw amount field
    Then the user sees the "Please fill out this field." validation message from the "WithdrawAmount" field on the withdraw page