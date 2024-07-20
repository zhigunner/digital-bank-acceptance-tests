Feature: Checking application information

  Scenario: checking the actual and expected results
    Given the user logged in as "will@turner.com" and "Turner@1977!"
    When the user clicks on the about button
    Then the user sees the following "Version: 2.1.0.7\nDate: Dec 18, 2020" data