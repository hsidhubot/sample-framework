@smokeA
Feature: Contact US - Action bar - breadcrumb - TWW-766 - Added caveat placement text - TWW-909

  Scenario: Contact US - Validation PLOT PAGE - Brislington
    Given I am on the Taylor Wimpey website for New Homes Page
    And I accept the cookies message if available accessed via OTHER page
#    And I setup up test data for Brislington Developments scenario
    Given I setup default test data for the Development "Brislington Developments"
    And I also setup test data for Contact us details for "Brislington"
    When I enter the location and perform search
    Then I land on the search result page for the New Homes
    And I validate the breadcrumb on the search result page
    And I select view development Link for this development
    And I validate the breadcrumb on the development page
    Then I validate the number of plots available under that development
    And I select the card with required plot name
    And I am able to see the action bar on the PLOT page
    And I can see contact us details on the PLOT page
    And I can also see ASA caveat placement text under the Contact Us page on PLOT PAGE

  Scenario: Contact US - Validation DEVELOPMENT PAGE - Brislington
    Given I am on the Taylor Wimpey website for New Homes Page
    And I accept the cookies message if available accessed via OTHER page
#    And I setup up test data for Brislington Developments scenario
    Given I setup default test data for the Development "Brislington Developments"
    And I also setup test data for Contact us details for "Brislington"
    When I enter the location and perform search
    Then I land on the search result page for the New Homes
    And I validate the breadcrumb on the search result page
    And I select view development Link for this development
    And I validate the breadcrumb on the development page
    And I land on the Development page and able to see the action bar
    And I can see contact us details on the PLOT page
    And I can also see ASA caveat placement text under the Contact Us page on DEVELOPMENT PAGE

  Scenario: Contact US - Validation PLOT PAGE - NORTHWICH
    Given I am on the Taylor Wimpey website for New Homes Page
    And I accept the cookies message if available accessed via OTHER page
    Given I setup default test data for the Development "Northwich"
    And I also setup test data for Contact us details for "Northwich"
    When I enter the location and perform search
    Then I land on the search result page for the New Homes
    And I validate the breadcrumb on the search result page
    And I select view development Link for this development
    And I validate the breadcrumb on the development page
    And I select the card with required plot name
    And I am able to see the action bar on the PLOT page
    And I can see contact us details on the PLOT page
    And I can also see ASA caveat placement text under the Contact Us page on PLOT PAGE

  Scenario: Contact US - Validation DEVELOPMENT PAGE - NORTHWICH
    Given I am on the Taylor Wimpey website for New Homes Page
    And I accept the cookies message if available accessed via OTHER page
    Given I setup default test data for the Development "Northwich"
    And I also setup test data for Contact us details for "Northwich"
    When I enter the location and perform search
    Then I land on the search result page for the New Homes
    And I validate the breadcrumb on the search result page
    And I select view development Link for this development
    And I validate the breadcrumb on the development page
    And I land on the Development page and able to see the action bar
    And I can see contact us details on the PLOT page
    And I can also see ASA caveat placement text under the Contact Us page on DEVELOPMENT PAGE


#  Scenario: Contact US - Proposed Developments London Theme - Osiers Point
#    Given I am on the Taylor Wimpey website for proposed development
#    Given I am on the Taylor Wimpey website for New Homes Page
#    And I accept the cookies message if available accessed via HOME page
#    And I accept the cookies message if available accessed via OTHER page
#    And I setup up test data for Osiers Point proposed development scenario
#    When I enter the location and perform search
#    Then I land on the search result page for the New Homes
#    And I validate the breadcrumb on the search result page
#    And I validate Proposed development card details content
#    And I select view development Link for this PROPOSED development
#    And I validate the breadcrumb on the development page
#    And I validate the proposed development page with London Theme