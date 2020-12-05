@smokeA
Feature: Validate Active Inactive Status with Launch date for Developments - Coming soon tag

  Scenario: Active Development with no Launch date - Clifton : Development StateLabel- Launch Date
    Given I am on the Taylor Wimpey website for New Homes Page
    And I accept the cookies message if available accessed via OTHER page
    And I setup up test data for Clifton Development
    When I enter the location and perform search
    Then I land on the search result page for the New Homes
    And I validate the breadcrumb on the search result page
    And I coming soon tag is available on the Clifton Development

  Scenario: Active Development with Future Launch date -- Keynsham : Development StateLabel- Launch Date
    Given I am on the Taylor Wimpey website for New Homes Page
    And I accept the cookies message if available accessed via OTHER page
    And I setup up test data for Keynsham Developments
    When I enter the location and perform search
    Then I land on the search result page for the New Homes
    And I validate the breadcrumb on the search result page
    And I coming soon tag is available on the Keynsham Development


  Scenario: Active Development with PAST Launch date -- Winsford : Display as normal no  Development StateLabel
    Given I am on the Taylor Wimpey website for New Homes Page
    And I accept the cookies message if available accessed via OTHER page
    And I setup up test data for Winsford Developments
    When I enter the location and perform search
    Then I land on the search result page for the New Homes
    And I validate the breadcrumb on the search result page
    And I coming soon tag is NOT available on the Winsford Development















