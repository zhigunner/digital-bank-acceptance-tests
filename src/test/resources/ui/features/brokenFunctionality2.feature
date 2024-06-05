Feature: Transfer via Visa Direct Transfer

  Scenario: Update personal information
    Given user logged into the bank system as "coach@arsenal.com" and "Emirates2004"
    When user goes to the VISA Direct Transfer page
    And user selects "------ Account Ending in 123 ------" and transfers "100" dollars
    Then user is transferred to the VISA Transfer Results page and there he sees the "The VISA API service is temporarily unavailable. We applogize for any inconvenience this may cause. Please try again at a later time" error message
