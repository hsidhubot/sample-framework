@londonTheme
#  NO LONGER REQUIRED
Feature: London Theme test in QA - Breadcrumb

  Background:
    Given I am on the Taylor Wimpey website for New Homes Page
    And I accept the cookies message if available accessed via OTHER page
    And I setup up test data for London Theme scenario
    When I enter the location and perform search
    Then I land on the search result page for the New Homes
    And I validate the breadcrumb on the search result page

  Scenario: Validate London Theme for Development and Plot Page breadcrumb validation - TWW-842
    And I select view development Link for this development
    And I land on the Development page and able to see the action bar
    And I validate the breadcrumb on the development page
    And I validate the London Theme for DEVELOPMENT page
    And I also validate the number of plots title contains APARTMENTS on development page
    Then I validate the number of plots available under that development
#    And I select the card with required plot name
    And I select the card with required APARTMENT NAME
#    And I validate the breadcrumb on the plot page
    And I validate the breadcrumb on the plot page for the said APARTMENT
    And I validate the London Theme for PLOT page
    And I land on the PLOT page and able to validate header and key stats with London Theme
#    And I also validate the number of plots title contains APARTMENTS
    And I validate page source details for the APARTMENT


#    TWW-842 : TWCL Theming For Plot & Development Pages
#    TWW-833 : Central London 'Plots at this Development' - Where we change Plots to Apartments