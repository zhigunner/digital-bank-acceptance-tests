Feature: Updating profile information

  Scenario: Update personal information
    Given user logged into the bank system as "will@turner.com" and "Turner@1977!"
    When the user sets the  "213-555-0202" number as mobile number and the "213-555-0303" number as work number
    Then user should see the "Profile Updated Successfully." message