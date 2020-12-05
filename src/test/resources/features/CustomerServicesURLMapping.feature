@smokeB
Feature: Customer Services URL mapping on NewHomes - validate page source and other details

  Scenario: Customer Services URL mapping on NewHomes-SearchResult-Development-Plot Pages - Brislington - PENS 814 - 815
    Given I am on the Taylor Wimpey website for New Homes Page
    And I validate New Home Page title
    And I accept the cookies message if available accessed via OTHER page
    And I setup up test data for Brislington Developments scenario
    Then I validate page source details for NEW HOMES
    When I enter the location and perform search
    And I land on the search result page for the New Homes
    And I validate New Home Search Result page title for Brislington
    Then I validate page source details for NEW HOME SEARCH RESULT
    And I select view development Link for this development
    And I validate Development Page title for Brislington Development
    And I validate page source details for DEVELOPMENT
    And I select the card with required plot name
    And I validate Plot Page title for Brislington Development Plot 3
#    And I land on the PLOT page
    And I validate page source details for PLOT

  Scenario: Customer Services URL mapping - Bordesley - Register Interest - PENS 814 - 815
    Given I am on the Taylor Wimpey website for Bordesley proposed development for Register Interest
    And I setup up test data for Bordesley proposed development scenario
    Then I validate Register Interest Page title for Bordesley proposed development
    And I validate the breadcrumb on the register interest page
    And I validate page source details for REGISTER INTEREST

  Scenario:Validate BreadCrumb Formatting for - Brislington - New Homes - Search - Development - Plot - small case URL's and First Letter upper case for BreadCrumb
    Given I am on the Taylor Wimpey website for New Homes Page
    And I accept the cookies message if available accessed via OTHER page
    And I setup up test data for Brislington Developments scenario for checking url cases
    When I enter the location and perform search
    Then I land on the search result page for the New Homes
    And I validate the breadcrumb on the search result page
    And I select view development Link for this development
    And I validate the breadcrumb on the development page
    Then I validate the number of plots available under that development
    And I select the card with required plot name
    And I validate the breadcrumb on the plot page

  Scenario:Validate BreadCrumb Formatting for Northwich Developments- New Homes - Search - Development - Plot - small case URL's and First Letter upper case for BreadCrumb
    Given I am on the Taylor Wimpey website for New Homes Page
    And I accept the cookies message if available accessed via OTHER page
    And I setup up test data for Northwich Developments scenario for checking url cases
    When I enter the location and perform search
    Then I land on the search result page for the New Homes
    And I validate the breadcrumb on the search result page
    And I select view development Link for this development
    And I validate the breadcrumb on the development page
    Then I validate the number of plots available under that development
    And I select the card with required plot name
    And I validate the breadcrumb on the plot page


#    Test The breadCrumbs

