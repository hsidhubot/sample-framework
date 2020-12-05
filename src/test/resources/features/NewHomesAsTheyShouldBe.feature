@regression @smokeC
Feature: New Homes As They Should Be

  Background: Not all housebuilders are equal page
    Given I am on the Taylor Wimpey website for New Homes As They Should Be
    And I accept the cookies message if available accessed via OTHER page
    Then I should see New Homes As They Should Be page header

  Scenario: Dedicated customer service
    When I click on Dedicated customer service
    Then I should see Dedicated customer service page

  Scenario: Our Trustpilot score
    When I click on Our Trustpilot score
    Then I should see Our Trustpilot score page

  Scenario: Building a better world
    When I click on Building a better world
    Then I should see Building a better world

  Scenario: Creating better communities
    When I click on Creating better communities
    Then I should see Creating better communities

