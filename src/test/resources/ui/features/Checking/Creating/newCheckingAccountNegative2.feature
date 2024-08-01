Feature: Attempt to create a new checking account

  Scenario: Create a standard individual checking account without specifying the account type
    Given the user logged in as "will@turner.com" and "Turner@1977!"
    When the user tries to create a new checking account with the following data without an account type
      | accountOwnership | accountName    | initialDepositAmount |
      | Individual       | Dummy Checking | 100.0                |
    Then the user should see the "Please select one of these options" validation message