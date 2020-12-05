@smokeB
Feature: Validate floor plans for a particular plots - TWW-655

  Scenario: Validate Floor Plans for Brislington DEVELOPMENT - PLOT 1
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
    And I should be able to validate floor plan details for the selected PLOT or APARTMENT

  Scenario: Validate Floor Plans for Brislington DEVELOPMENT - PLOT 2
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
    And I should be able to validate floor plan details for the selected PLOT or APARTMENT

  Scenario: Validate Floor Plans for Brislington DEVELOPMENT - PLOT 3
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
    And I should be able to validate floor plan details for the selected PLOT or APARTMENT

  Scenario: Validate Floor Plans for Brislington DEVELOPMENT - PLOT 4
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
    And I should be able to validate floor plan details for the selected PLOT or APARTMENT

  Scenario: Validate Floor Plans for Battersea Exchange developments - APARTMENT 1
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
    And I should be able to validate floor plan details for the selected PLOT or APARTMENT

  Scenario: Validate Floor Plans for Battersea Exchange developments - APARTMENT 3
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
    And I should be able to validate floor plan details for the selected PLOT or APARTMENT

  Scenario: Validate Floor Plans Access directly from Brislington DEVELOPMENT PAGE - PLOT 2
    Given I am on the Taylor Wimpey website for New Homes Page
    And I accept the cookies message if available accessed via OTHER page
    And I setup up test data for Brislington Developments scenario for PLOT2
    When I enter the location and perform search
    Then I land on the search result page for the New Homes
    And I validate the breadcrumb on the search result page
    And I select view development Link for this development
    And I validate the breadcrumb on the development page
    Then I validate the number of plots available under that development
    And I select the FLOOR ICON on the selected PLOT
    And I should be able to validate floor plan details for the selected PLOT or APARTMENT

  Scenario: Validate Floor Plans for Battersea Exchange developments - APARTMENT 3
    Given I am on the Taylor Wimpey website for New Homes Page
    And I accept the cookies message if available accessed via OTHER page
    And I setup up test data for Battersea Exchange for APARTMENT3
    When I enter the location and perform search
    Then I land on the search result page for the New Homes
    And I validate the breadcrumb on the search result page
    And I select view development Link for this development
    And I validate the breadcrumb on the development page
    Then I validate the number of plots available under that development
    And I select the FLOOR ICON on the selected APARTMENT
    And I should be able to validate floor plan details for the selected PLOT or APARTMENT

#    TWW-655 : Floor Plan Components