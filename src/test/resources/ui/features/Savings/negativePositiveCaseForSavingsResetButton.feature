Feature: Deposit of existing savings account and reset

  Scenario: Deposit savings account and reset
    Given the user logged in as "will@turner.com" and "Turner@1977!"
    When the user goes to the Deposit page
    And the user selects the "Business Savings (Savings)" account and deposits it with "50.00" and presses the reset button
    Then the user clicks submit and sees the "Please select an item in the list." validation message from the "AccountForDeposit" field