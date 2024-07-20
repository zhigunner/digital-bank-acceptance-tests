Feature: Transfer between accounts

  Scenario: Transfer between existing accounts with the invalid amount
    Given the user logged in as "will@turner.com" and "Turner@1977!"
    When the user goes to the Transfer Between Accounts page
    And the user firstly selects the "Empty Savings (Savings)" account then selects "Business Savings (Savings)" account and transfers "10" dollars
    Then the user sees the "The amount ($10.00) requested for transfer is more than the available balance ($0.00)" error message on the transfer page


