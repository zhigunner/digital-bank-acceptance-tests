Feature: Creating a new checking account

  Scenario: Create a standard individual checking account
    Given the user logged in as "coach@arsenal.com" and "Emirates2004"
    When the user creates a new checking account with the following data
      | checkingAccountType | accountOwnership | accountName                          | initialDepositAmount |
      | Standard Checking   | Individual       | Mikel Arteta Second Checking Account | 100000.0             |
    Then the user should see the green "Successfully created new Standard Checking account named Mikel Arteta Second Checking Account" message
    And the user should see newly added account card
      | accountName                          | accountType       | ownership  | accountNumber | interestRate | balance   |
      | Mikel Arteta Second Checking Account | Standard Checking | Individual | 486136091     | 0.0%         | 100000.00 |
    And the user should see the following transactions
      | date             | category | description               | amount    | balance   |
      | 2024-05-01 15:17 | Income   | 845327759 (DPT) - Deposit | 100000.00 | 100000.00 |