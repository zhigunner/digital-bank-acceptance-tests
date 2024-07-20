@skip
Feature: Checking the number of transactions

  Scenario: Checking the number of transactions on the View Checking page
    Given the user logged in as "coach@arsenal.com" and "Emirates2004"
    When the user goes to the View Checking page
    Then the user sees the "Showing 1 to 10 of 22 entries" table information

  Scenario: Checking the number of transactions on the View Checking page
    Given the user logged in as "coach@arsenal.com" and "Emirates2004"
    When the user goes to the View Checking page
    And the user selects "25" in the show field
    Then the user sees the "Showing 1 to 22 of 22 entries" table information