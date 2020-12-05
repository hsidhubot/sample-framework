@smokeC
Feature: Validate Offers available on PLOT Pages

  Scenario: National and Domestic Offers - Brislington developments - Plot1
    Given I am on the Taylor Wimpey website for New Homes Page
    And I accept the cookies message if available accessed via OTHER page
    And I setup up test data for Brislington Developments scenario for PLOT1
    When I enter the location and perform search
    Then I land on the search result page for the New Homes
    And I validate the breadcrumb on the search result page
    And I select view development Link for this development
    And I validate the breadcrumb on the development page
    Then I validate the number of plots available under that development
    When I select the card with required plot name
    Then I able to see all the required offers listed on this PLOT

  Scenario: National and Domestic Offers - Brislington developments - Plot2
    Given I am on the Taylor Wimpey website for New Homes Page
    And I accept the cookies message if available accessed via OTHER page
    And I setup up test data for Brislington Developments scenario for PLOT2
    When I enter the location and perform search
    Then I land on the search result page for the New Homes
    And I validate the breadcrumb on the search result page
    And I select view development Link for this development
    And I validate the breadcrumb on the development page
    Then I validate the number of plots available under that development
    When I select the card with required plot name
    Then I able to see all the required offers listed on this PLOT

  Scenario: National and Domestic Offers - Brislington developments - Plot3
    Given I am on the Taylor Wimpey website for New Homes Page
    And I accept the cookies message if available accessed via OTHER page
    And I setup up test data for Brislington Developments scenario for PLOT3
    When I enter the location and perform search
    Then I land on the search result page for the New Homes
    And I validate the breadcrumb on the search result page
    And I select view development Link for this development
    And I validate the breadcrumb on the development page
    Then I validate the number of plots available under that development
    When I select the card with required plot name
    Then I able to see all the required offers listed on this PLOT

  Scenario: NO National and Domestic Offers - Brislington developments - Plot4
    Given I am on the Taylor Wimpey website for New Homes Page
    And I accept the cookies message if available accessed via OTHER page
    And I setup up test data for Brislington Developments scenario for PLOT4
    When I enter the location and perform search
    Then I land on the search result page for the New Homes
    And I validate the breadcrumb on the search result page
    And I select view development Link for this development
    And I validate the breadcrumb on the development page
    Then I validate the number of plots available under that development
    When I select the card with required plot name
    Then I able to see all the required offers listed on this PLOT

  Scenario: National and Domestic Offers - Battersea Exchange developments - APARTMENT 1
    Given I am on the Taylor Wimpey website for New Homes Page
    And I accept the cookies message if available accessed via OTHER page
    And I setup up test data for Battersea Exchange for APARTMENT1
    When I enter the location and perform search
    Then I land on the search result page for the New Homes
    And I validate the breadcrumb on the search result page
    And I select view development Link for this development
    And I validate the breadcrumb on the development page
    Then I validate the number of plots available under that development
    And I select the card with required APARTMENT NAME
    Then I able to see all the required offers listed on this PLOT
    And I validate that offer details are compatible to London theme for said APARTMENT

  Scenario: National and Domestic Offers - Battersea Exchange developments - APARTMENT 2
    Given I am on the Taylor Wimpey website for New Homes Page
    And I accept the cookies message if available accessed via OTHER page
    And I setup up test data for Battersea Exchange for APARTMENT2
    When I enter the location and perform search
    Then I land on the search result page for the New Homes
    And I validate the breadcrumb on the search result page
    And I select view development Link for this development
    And I validate the breadcrumb on the development page
    Then I validate the number of plots available under that development
    And I select the card with required APARTMENT NAME
    Then I able to see all the required offers listed on this PLOT
    And I validate that offer details are compatible to London theme for said APARTMENT

  Scenario: National and Domestic Offers - Battersea Exchange developments - APARTMENT 3
    Given I am on the Taylor Wimpey website for New Homes Page
    And I accept the cookies message if available accessed via OTHER page
    And I setup up test data for Battersea Exchange for APARTMENT3
    When I enter the location and perform search
    Then I land on the search result page for the New Homes
    And I validate the breadcrumb on the search result page
    And I select view development Link for this development
    And I validate the breadcrumb on the development page
    Then I validate the number of plots available under that development
    And I select the card with required APARTMENT NAME
    Then I able to see all the required offers listed on this PLOT
    And I validate that offer details are compatible to London theme for said APARTMENT

  Scenario: National and Domestic Offers - Battersea Exchange developments - APARTMENT 4
    Given I am on the Taylor Wimpey website for New Homes Page
    And I accept the cookies message if available accessed via OTHER page
    And I setup up test data for Battersea Exchange for APARTMENT4
    When I enter the location and perform search
    Then I land on the search result page for the New Homes
    And I validate the breadcrumb on the search result page
    And I select view development Link for this development
    And I validate the breadcrumb on the development page
    Then I validate the number of plots available under that development
    And I select the card with required APARTMENT NAME
    Then I able to see all the required offers listed on this PLOT