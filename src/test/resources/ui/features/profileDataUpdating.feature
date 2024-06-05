Feature: Updating profile information

  Scenario: Update personal information
    Given user logged into the bank system as "coach@arsenal.com" and "Emirates2004"
    When the user sets the  "+44 7799 888777" number as mobile number and the "+44 20 7123 4567" number as work number
    Then user should see the "Profile Updated Successfully." message