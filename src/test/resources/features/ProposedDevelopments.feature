@smokeC
Feature: Proposed Developments - Register Interest - Breadcrumb - London Theme - Bordesley - Leigham

  @hs22
  Scenario: Proposed Developments London Theme Validation - Osiers Point - TWW-56
    Given I am on the Taylor Wimpey website for New Homes Page
    And I accept the cookies message if available accessed via HOME page
    And I accept the cookies message if available accessed via OTHER page
    And I setup up test data for Osiers Point proposed development scenario
    When I enter the location and perform search
    And I select "ALL" option from the search page Filter
    Then I land on the search result page for the New Homes
    And I validate the breadcrumb on the search result page
    And I validate Proposed development card details content
    And I select view development Link for this PROPOSED development
    And I validate the breadcrumb on the development page
    And I validate the proposed development page with London Theme

  Scenario: Proposed Developments - Register Interest London Theme Validation - Osiers Point - TWW-56
    Given I am on the Taylor Wimpey website for proposed development for Register Interest
    And I accept the cookies message if available accessed via OTHER page
    And I setup up test data for Osiers Point proposed development scenario
    And I validate the breadcrumb on the register interest page
    And I validate the proposed development page with London Theme

  Scenario: Proposed Developments - Bordesley Proposed Development- TWW-809
    Given I am on the Taylor Wimpey website for Bordesley proposed development
    And I accept the cookies message if available accessed via HOME page
    And I accept the cookies message if available accessed via OTHER page
    And I setup up test data for Bordesley proposed development scenario
    And I validate the breadcrumb on the Bordesley Proposed Development
    Then I validate available tabs on the Bordesley Proposed Development

  Scenario: Proposed Developments Cards - TWW- - Proposed Developments - Bordesley
    Given I am on the Taylor Wimpey website for New Homes Page
    And I accept the cookies message if available accessed via OTHER page
    And I setup up test data for Bordesley proposed development scenario
    When I enter the location and perform search
    And I select "ALL" option from the search page Filter
    Then I land on the search result page for the New Homes
    And I validate the breadcrumb on the search result page
    And I validate Proposed development card details content
    And I select view development Link for this PROPOSED development
    And I validate the breadcrumb on the development page



#  Note : Leigham Road Proposed Development is marked as INACTIVE as part of other feature

#  Scenario: Proposed Developments - Leigham Road Proposed Development- TWW-809
#    Given I am on the Taylor Wimpey website for Leigham Road proposed development
#    And I accept the cookies message if available accessed via HOME page
#    And I accept the cookies message if available accessed via OTHER page
#    And I setup up test data for Leigham Road proposed development scenario
#    And I select view development Link for this PROPOSED development
#    And I validate the breadcrumb on the development page
#    Then I validate available only tabs with content are available on the proposed development page

#TWW-809 : Tabbed module for proposed developments content
#TWW-56 - Register Interest in a new home (proposed developments)
#TWW-770 - Proposed developments Search Card
#TWW-907 : Search result development state labels












