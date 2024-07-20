Feature: Inputting an incorrect mobile number

  Scenario: Inputting an incorrect mobile number in personal information
    Given user logged into the bank system as "will@turner.com" and "Turner@1977!"
    When the user sets the  "mobile phone" number as mobile number
    Then user should see the "Please  match the requested format." warning message