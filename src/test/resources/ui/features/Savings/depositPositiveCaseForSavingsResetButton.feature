Feature: Deposit of existing savings account and reset

  Scenario: Deposit savings account and reset
    Given the user logged in as "coach@arsenal.com" and "Emirates2004"
    When the user goes to the Deposit page
    And the user selects the "League (Savings)" account and deposits it with "50.00" and presses the reset button
    Then the user sees the "Please select an item in the list." validation message from the "AccountForDeposit" field