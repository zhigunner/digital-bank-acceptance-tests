Feature: Working with external accounts

  Scenario: Update personal information
    Given user logged into the bank system as "will@turner.com" and "Turner@1977!"
    When user goes to the Link External Account page
    Then user sees the "There are no banking providers available" error message