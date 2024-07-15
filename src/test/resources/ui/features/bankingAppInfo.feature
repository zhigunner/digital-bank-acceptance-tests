Feature: Checking application information

  Scenario: checking the actual and expected results
    Given the user logged in as "coach@arsenal.com" and "Emirates2004"
    When the user clicks on the about button
    Then the user sees the following "Version: 2.1.0.7\nDate: Dec 18, 2020" data