@smokeA
Feature: Search by COUNTY

  Scenario: Search by COUNTY - With results - TWW-715
    Given I am on the Taylor Wimpey website for New Homes Page
    And I accept the cookies message if available accessed via OTHER page
    And I setup default test data for the Development for the county "Bristol"
    When I enter the location and perform search
    Then I land on the search result page for the New Homes
    And I select "ALL" option from the search page Filter
    Then I land on the search result page for the New Homes
    And I validate the breadcrumb on the search result page
    And I validate all the Developments listed under that county "Bristol"

  Scenario: Search by COUNTY - With results - TWW-715
    Given I am on the Taylor Wimpey website for New Homes Page
    And I accept the cookies message if available accessed via OTHER page
    And I setup default test data for the Development for the county "Derbyshire"
    When I enter the location and perform search
    And I select "ALL" option from the search page Filter
    And I validate the breadcrumb on the search result page
    And I validate all the Developments listed under that county "Derbyshire"



#    TWW-715 - Search by county