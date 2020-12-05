@newhomelondonthemeUAT @uat
@londonTheme
#  NO LONGER REQUIRED
Feature: London Theme test for UAT environment

  Background:
    Given I am on the Taylor Wimpey website for New Homes Page
    And I accept the cookies message if available accessed via OTHER page
    And I setup up test data for London Theme scenario for UAT
    When I enter the location and perform search
    Then I land on the search result page for the New Homes
    And I validate the breadcrumb on the search result page

  @842UAT
  Scenario: Validate London Theme for Development and Plot Page breadcrumb validation - TWW-842
    And I select view development Link for this development
    And I land on the Development page and able to see the action bar
    And I validate the breadcrumb on the development page
    And I validate the London Theme for DEVELOPMENT page
    Then I validate the number of plots available under that development
    And I select the card with required plot name
    And I validate the breadcrumb on the plot page
    And I validate the London Theme for PLOT page
    And I land on the PLOT page and able to validate header and key stats




#   This feature is specifically done to cater for the UAT. Test Data has also been configured to match as it was in QA
#   Example
#