@smokeA
Feature: Filter by Development Status

  Background:
    Given I am on the Taylor Wimpey website for New Homes Page
    And I accept the cookies message if available accessed via OTHER page
    And I setup default test data for the Development for the county "Bristol"
    When I enter the location and perform search
    Then I land on the search result page for the New Homes

  Scenario: DEFAULT OPTIONS
    And I select "DEFAULT" option from the search page Filter
    Then I land on the search result page for the New Homes
    And I validate that URL for "DEFAULT" option is as expected
    And I validate the breadcrumb on the search result page
    And I validate "CURRENT AND COMING SOON" Developments listed under that county "<County>"

  Scenario: ALL OPTIONS SELECTED
    And I select "ALL" option from the search page Filter
    Then I land on the search result page for the New Homes
    And I validate that URL for "ALL" option is as expected
    And I validate the breadcrumb on the search result page
    And I validate "ALL" Developments listed under that county "<County>"

  Scenario: NO OPTIONS SELECTED
    And I select "NO" option from the search page Filter
    Then I land on the search result page for the New Homes
    And I validate that URL for "NO" option is as expected
    And I validate the breadcrumb on the search result page
    And I validate "CURRENT AND COMING SOON" Developments listed under that county "<County>"

  Scenario: Current Developments
    And I select "CURRENT DEVELOPMENTS ONLY" option from the search page Filter
    Then I land on the search result page for the New Homes
    And I validate that URL for "CURRENT DEVELOPMENTS ONLY" option is as expected
    And I validate the breadcrumb on the search result page
    And I validate "CURRENT DEVELOPMENTS" Developments listed under that county "<County>"

  Scenario: Coming soon Developments
    And I select "COMING SOON DEVELOPMENTS ONLY" option from the search page Filter
    Then I land on the search result page for the New Homes
    And I validate that URL for "COMING SOON DEVELOPMENTS ONLY" option is as expected
    And I validate the breadcrumb on the search result page
    And I validate "COMING SOON DEVELOPMENTS" Developments listed under that county "<County>"

  Scenario: PROPOSED DEVELOPMENTS ONLY
    And I select "PROPOSED DEVELOPMENTS ONLY" option from the search page Filter
    Then I land on the search result page for the New Homes
    And I validate that URL for "PROPOSED DEVELOPMENTS ONLY" option is as expected
    And I validate the breadcrumb on the search result page
    And I validate "PROPOSED DEVELOPMENTS" Developments listed under that county "<County>"

  Scenario: PROPOSED And COMING SOON DEVELOPMENTS ONLY
    And I select "PROPOSED AND COMING SOON" option from the search page Filter
    Then I land on the search result page for the New Homes
    And I validate that URL for "PROPOSED AND COMING SOON" option is as expected
    And I validate the breadcrumb on the search result page
    And I validate "PROPOSED AND COMING SOON" Developments listed under that county "<County>"

#  Scenario: CURRENT AND COMING SOON
#    Given I am on the Taylor Wimpey website for New Homes Page
#    And I accept the cookies message if available accessed via OTHER page
#    And I setup default test data for the Development for the county "Bristol"
#    When I enter the location and perform search
#    Then I land on the search result page for the New Homes
#    And I select "CURRENT AND COMING SOON" option from the search page Filter
#    And I validate the breadcrumb on the search result page
#    And I coming soon tag is available on the Keynsham Development


# TWW-710 : Filter by Development Status












