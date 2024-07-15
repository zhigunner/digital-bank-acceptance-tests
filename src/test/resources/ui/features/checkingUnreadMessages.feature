Feature: Checking for unread messages

  Scenario: checking that there are no unread messages
    Given the user logged in as "coach@arsenal.com" and "Emirates2004"
    When the user clicks on the messages icon
    Then the user sees the following "You have 0 Unread Mail[s]" message
