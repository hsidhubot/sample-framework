@regression @smokeA
Feature: Covid-19 Hub

  Background: Covid-19 Hub page
    Given I am on the Taylor Wimpey website for Covid19 Hub
    And I accept the cookies message if available accessed via OTHER page
    And I click on Covid19 Hub nav
    Then I should see Covid19 Hub page header

  Scenario: Staying safe
    When I click on How to visit us safely
    Then I should see How to visit us safely page

  Scenario: Buy a new home online
    When I click on Buy a new home online
    Then I should see Buy a new home online page

  Scenario: Our safety procedures
    When I click on Our safety procedures
    Then I should see Our safety procedures page

