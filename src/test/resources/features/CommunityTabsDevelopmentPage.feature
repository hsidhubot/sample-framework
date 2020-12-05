@smokeA
Feature: Validate Community tabs available on the Development Pages

  #Development Page  - TWW-37
  Scenario: Community Tabs on Broadgate Park Ph3
    Given I am on the Taylor Wimpey website for New Homes Page
    And I accept the cookies message if available accessed via OTHER page
    And I setup default test data for the Development "Broadgate Park Ph3"
    When I enter the location and perform search
    Then I land on the search result page for the New Homes
    And I validate the breadcrumb on the search result page
    And I select view development Link for this development
    And I validate the breadcrumb on the development page
    Then I validate available community tabs on the Broadgate Park Ph3 Development
    And I validate tabs contents on Broadgate Park Ph3 Development page


  #Broadgate Park Ph3 - Plot Page
  Scenario: Validate Community Tabs on Plot page - Broadgate Park Ph3 developments - Plot111
    Given I am on the Taylor Wimpey website for New Homes Page
    And I accept the cookies message if available accessed via OTHER page
    And I setup default test data for the Development "Broadgate Park Ph3"
    When I enter the location and perform search
    Then I land on the search result page for the New Homes
    And I validate the breadcrumb on the search result page
    And I select view development Link for this development
    And I validate the breadcrumb on the development page
    Then I validate the number of plots available under that development
    When I select the card with required plot name
    Then I validate available community tabs on Plot page
    And I validate tabs contents on Broadgate Park Development Plot page


  # Grange Park Development page
  Scenario: Community Tabs on Grange Park
    Given I am on the Taylor Wimpey website for New Homes Page
    And I accept the cookies message if available accessed via OTHER page
    And I setup default test data for the Development "Grange Park"
    When I enter the location and perform search
    Then I land on the search result page for the New Homes
    And I validate the breadcrumb on the search result page
    And I select view development Link for this development
    And I validate the breadcrumb on the development page
    Then I validate available community tabs on the Grange Park Development
    And I validate tabs contents on Grange Park Development page

  #Grange Park - Plot Page
  Scenario: Validate Community Tabs on Plot page - Grange Park developments - Plot 555
    Given I am on the Taylor Wimpey website for New Homes Page
    And I accept the cookies message if available accessed via OTHER page
    And I setup default test data for the Development "Grange Park"
    When I enter the location and perform search
    Then I land on the search result page for the New Homes
    And I validate the breadcrumb on the search result page
    And I select view development Link for this development
    And I validate the breadcrumb on the development page
    Then I validate the number of plots available under that development
    When I select the card with required plot name
    Then I validate available community tabs on Grange Park Plot page
    And I validate tabs contents on Grange Park Development Plot page