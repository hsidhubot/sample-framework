@regression @smokeC
Feature: Support Nav

  Background: Support page
    Given I am on the Taylor Wimpey website for Support
    And I accept the cookies message if available accessed via OTHER page
    And I click on Support nav
    Then I should see Support page header

  Scenario: Settling in
    When I click on Settling in nav
    Then I should see Settling in page header

  Scenario: Our approach to quality
    When I click on Our approach to quality nav
    Then I should see Our approach to quality page header

  Scenario: Troubleshooting
    When I click on Troubleshooting nav
    Then I should see Troubleshooting page header

  Scenario: Warranty
    When I click on Warranty nav
    Then I should see Warranty page header

  Scenario: Contact us
    When I click on Contact us nav
    Then I should see Contact us page header




    