@legacy
Feature: Have your say

  Scenario: Validate Error messages on the page when submitted without any data
    Given I am on the Taylor Wimpey Have Your Say Page
    And I accept the cookies message if available accessed via OTHER page
    When I enter submit without answering any question
    Then I should be able to see all the errors

  Scenario: Validate successful submission of all questions on Have your say page
    Given I am on the Taylor Wimpey Have Your Say Page
    And I accept the cookies message if available accessed via OTHER page
    When I enter all questions on the page
    And I enter valid name email postcode and phone number
    Then I am able to submit the feedback successfully

# Notes:
# Not Available in QA
# Access the URL Directly - https://www.taylorwimpey.co.uk/proposed-developments/england/cornwall/wadebridge/bridge-view/have-your-say