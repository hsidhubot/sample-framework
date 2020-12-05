@legacy
Feature: Legacy System- Request a call back form

  Scenario Outline: Request a call back - On the Legacy System
    Given I am on the Taylor Wimpey website
    And I accept the cookies message if available accessed via HOME page
    And I enter a "<City>" name
    And I select Price range
    And I select bedroom size
    When I click cta Search
    And I click cta View home details
    Then user lands on the selected Plot Details page
    And I click on cta Request a call back
    And I select Call back date for the appointment
    And I select the AFTERNOON option
    And I provide all the FORM Details for requesting call back
    And submit the request

    Examples:
      | City             |
      | Bristol, England |