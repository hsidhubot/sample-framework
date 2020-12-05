@smokeA
Feature: Validate Active Inactive Status for Proposed Developments - Inactive Status and redirection

  Scenario: Leigham Road Proposed Development- Mark proposed development as in-active and with no 'development phase for redirection' selected
    Given I am on the Taylor Wimpey website for New Homes Page
    And I accept the cookies message if available accessed via OTHER page
    And I setup up test data for Leigham Road Proposed Development
    When I enter the location and perform search
    Then I land on the search result page for the New Homes
    And I validate the breadcrumb on the search result page
    And I validate that Leigham Road Proposed Development is not available in search result page
    When I access Leigham-road-proposed-development directly it should return 302
    When I access Leigham-road-proposed-development directly it should redirect to search result page of LONDON

  Scenario: Windmill Development Proposed Development - Mark as In-active and with 'development phase for redirection' selected as 'brislington'
    Given I am on the Taylor Wimpey website for New Homes Page
    And I accept the cookies message if available accessed via OTHER page
    And I setup up test data for Windmill Development Proposed Development
    When I enter the location and perform search
    Then I land on the search result page for the New Homes
    And I validate the breadcrumb on the search result page
    And I validate that Windmill Development Proposed Development is not available in search result page
    When I access Windmill Development-proposed-development directly it should return 301
    When I access Windmill Development-proposed-development directly it should redirect to search result page of LONDON

  # New N Developments' will be marked as in-active
  Scenario: Whitakers Garden Centre - Mark as In-active and with 'development phase for redirection' selected as 'New N Developments' under Northampton
    Given I am on the Taylor Wimpey website for New Homes Page
    And I accept the cookies message if available accessed via OTHER page
    And I setup up test data for Whitakers Garden Centre Proposed Development
    When I enter the location and perform search
    Then I land on the search result page for the New Homes
    And I validate the breadcrumb on the search result page
    And I validate that Whitakers Garden Centre Proposed Development is not available in search result page
#    When I access Whitakers Garden Centre-proposed-development directly it should return 301 and 302
    When I access Whitakers Garden Centre-proposed-development directly it should redirect to search result page of Wellingborough





