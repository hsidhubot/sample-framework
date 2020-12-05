@smokeC
Feature: Validate Offers available on the Development Pages

  Scenario: National and Domestic Offers - Brislington developments
    Given I am on the Taylor Wimpey website for New Homes Page
    And I accept the cookies message if available accessed via OTHER page
    And I setup up test data for Brislington Developments scenario
    When I enter the location and perform search
    Then I land on the search result page for the New Homes
    And I validate the breadcrumb on the search result page
    And I select view development Link for this development
    And I validate the breadcrumb on the development page
    Then I able to see all the required offers listed on this DEVELOPMENT

  Scenario: National and Domestic Offers - Battersea Exchange
    Given I am on the Taylor Wimpey website for New Homes Page
    And I accept the cookies message if available accessed via OTHER page
    And I setup up test data for London Theme scenario
    When I enter the location and perform search
    Then I land on the search result page for the New Homes
    And I validate the breadcrumb on the search result page
    And I select view development Link for this development
    And I validate the breadcrumb on the development page
    Then I able to see all the required offers listed on this DEVELOPMENT
    And I validate that offer details are compatible to London theme for this DEVELOPMENT

  Scenario: National and Domestic Offers - Clifton Developments
    Given I am on the Taylor Wimpey website for New Homes Page
    And I accept the cookies message if available accessed via OTHER page
    And I setup up test data for Clifton Development
    When I enter the location and perform search
    Then I land on the search result page for the New Homes
    And I validate the breadcrumb on the search result page
    And I select view development Link for this development
    And I validate the breadcrumb on the development page
    Then I able to see all the required offers listed on this DEVELOPMENT

  Scenario: National and Domestic Offers - Keynsham Developments
    Given I am on the Taylor Wimpey website for New Homes Page
    And I accept the cookies message if available accessed via OTHER page
    And I setup up test data for Keynsham Developments
    When I enter the location and perform search
    Then I land on the search result page for the New Homes
    And I validate the breadcrumb on the search result page
    And I select view development Link for this development
    And I validate the breadcrumb on the development page
    Then I able to see all the required offers listed on this DEVELOPMENT