Feature: Attempt to create a new checking account

  Scenario: Create a standard individual checking account with a small initial deposit
    Given the user logged in as "will@turner.com" and "Turner@1977!"
    When the user creates a new checking account with the following data
      | checkingAccountType | accountOwnership | accountName    | initialDepositAmount |
      | Standard Checking   | Individual       | Dummy Checking | 24.0                 |
    Then the user should see the "The initial deposit ($24.00) entered does not meet the minimum amount ($25.00) required. Please enter a valid deposit amount" error message