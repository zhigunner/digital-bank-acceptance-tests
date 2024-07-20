Feature: Creating a new savings account

  Scenario: Create a standard individual savings account
    Given user logged in as "will@turner.com" and "Turner@1977!"
    When user creates a new savings account with the following data
      | savingsAccountType | accountOwnership | accountName      | initialDepositAmount |
      | Savings            | Individual       | Business Savings | 380000.0             |
    Then user should see the green "Successfully created new Savings account named Business Savings" message
    And user should see newly added account card
      | accountName      | accountType | ownership  | accountNumber | interestRate | balance  |
      | Business Savings | Savings     | Individual | 486136091     | 1.85%        | 380000.0 |
    And user should see the following transactions
      | date             | category | description               | amount    | balance   |
      | 2024-05-01 15:17 | Income   | 845327759 (DPT) - Deposit | 380000.00 | 380000.00 |