@smokeB
Feature: New Homes - Action bar - breadcrumb - Image validation

  Background:
    Given I am on the Taylor Wimpey website for New Homes Page
    And I accept the cookies message if available accessed via OTHER page
    And I setup up test data for Brislington Developments scenario
#    And I setup up test data for this scenario
    When I enter the location and perform search
    Then I land on the search result page for the New Homes
    And I validate the breadcrumb on the search result page


  Scenario: Development Page Action bar validation - TWW-753-762
    And I select view development Link for this development
    And I land on the Development page and able to see the action bar

  Scenario: Plot page Action Bar Validation - TWW-753
    And I select click on the first available plot
    And I am able to see the action bar on the PLOT page

  Scenario: Development and Plot Page breadcrumb validation - TWW-856
    And I select view development Link for this development
    And I validate the breadcrumb on the development page
    Then I validate the number of plots available under that development
    And I select the card with required plot name
    And I validate the breadcrumb on the plot page
    And I land on the PLOT page and able to validate header and key stats

  Scenario: Development page image validation - TWW-761
    And I select view development Link for this development
    And I validate the breadcrumb on the development page
    Then I validate the number of plots available under that development
    And I also validate that image gallery is displayed on the Development Page

  Scenario: Plot page image validation - TWW-754
    And I select view development Link for this development
    And I validate the breadcrumb on the development page
    Then I validate the number of plots available under that development
    And I select the card with required plot name
    And I also validate that image gallery is displayed on the PLOT Page


#  Scenario: Plot page Key stats and header validations
#    And I select click on the first available plot
#    And I land on the PLOT page and able to validate header and key stats

#  Scenario: Development Page Validations
#
#  Scenario: New Homes Search Result Page
#
#  Scenario: New Homes Book and Appointment - TWW-836










