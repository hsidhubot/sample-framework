@smokeA
Feature: Sales Info Centre opening hours 'closed' field  to reflect on appointment booking form - New Development

  Scenario: Sales Centre closing day - Validate that no appointments are available for the day sales center is closed
    Given I am on the Taylor Wimpey website for New Homes Page
    And I accept the cookies message if available accessed via OTHER page
    And I setup up test data for Brislington Developments scenario
    And I also setup test data for Contact us details for "Brislington"
    When I enter the location and perform search
    Then I land on the search result page for the New Homes
    And I validate the breadcrumb on the search result page
    And I select view development Link for this development
    And I validate the breadcrumb on the development page
    Then I validate check the availability of the Appointment Feature
    And I validate that that no appointments are available for the day "Brislington Development" sales center is closed

  Scenario: Sales Centre closing day - Validate that no appointments are available for the day sales center is closed
    Given I am on the Taylor Wimpey website for New Homes Page
    And I accept the cookies message if available accessed via OTHER page
    Given I setup default test data for the Development "Northwich"
    And I also setup test data for Contact us details for "Northwich"
    When I enter the location and perform search
    Then I land on the search result page for the New Homes
    And I validate the breadcrumb on the search result page
    And I select view development Link for this development
    And I validate the breadcrumb on the development page
    Then I validate check the availability of the Appointment Feature
    And I validate that that no appointments are available for the day "Northwich Development" sales center is closed


#    TWW-972 - Sales Info Centre opening hours 'closed' field not reflected on appointment booking form






















