@smokeC
Feature: Validate Active Inactive PLOT Re-directions - TWW-951 - Also refer TWW-879

  Scenario: Validate Number of ACTIVE PLOTS for Brislington DEVELOPMENT - 4 active - 1 Inactive - 1 Reserved
    Given I am on the Taylor Wimpey website for New Homes Page
    And I accept the cookies message if available accessed via OTHER page
    And I setup up test data for Brislington Developments scenario
    When I enter the location and perform search
    Then I land on the search result page for the New Homes
    And I validate the breadcrumb on the search result page
    And I select view development Link for this development
    And I validate the breadcrumb on the development page
    Then I validate the number of plots available under that development

  Scenario: Validate Number of ACTIVE PLOTS for Bedminster - 0 active - 1 Inactive - 1 Reserved
    Given I am on the Taylor Wimpey website for New Homes Page
    And I accept the cookies message if available accessed via OTHER page
    And I setup up test data for Bedminister Development
    When I enter the location and perform search
    Then I land on the search result page for the New Homes
    And I validate the breadcrumb on the search result page
    Then I validate the Bedminister development is available under search results with no available plots
    And I select view development Link for this development
    And I validate the breadcrumb on the development page
    Then I validate the plots component is not available under that development

  Scenario: Validate Active Inactive PLOT Re-directions - Brislington Developments
    Given I setup up test data for Brislington Developments scenario
    Then I validate the Redirection for Active and In Active PLOTS

  Scenario: Validate Active Inactive PLOT Re-directions - Wilmslow Developments
    Given I setup up test data for Wilmslow Developments scenario
    And I validate the Redirection for Active and In Active PLOTS

  Scenario: Validate Active Inactive PLOT Re-directions - Bedminister Developments
    Given I setup up test data for Bedminister Development
    And I validate the Redirection for Active and In Active PLOTS

#   Validate Active Inactive Status of PLOTS - TWW-951