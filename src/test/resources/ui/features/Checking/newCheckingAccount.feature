Feature: Creating a new checking account

  Scenario: Create a standard individual checking account
    Given the user logged in as "will@turner.com" and "Turner@1977!"
    When the user creates a new checking account with the following data
      | checkingAccountType | accountOwnership | accountName    | initialDepositAmount |
      | Standard Checking   | Individual       | Dummy Checking | 75000.0              |
    Then the user should see the green "Successfully created new Standard Checking account named Dummy Checking" message
    And the user should see newly added account card
      | accountName    | accountType       | ownership  | accountNumber | interestRate | balance  |
      | Dummy Checking | Standard Checking | Individual | 486136091     | 0.0%         | 75000.00 |
    And the user should see the following transactions
      | date             | category | description               | amount   | balance  |
      | 2024-05-01 15:17 | Income   | 845327759 (DPT) - Deposit | 75000.00 | 75000.00 |