@smoking @regression
Feature: Search Functionality - City - Postcode - Geocity

  Scenario Outline: Search with City name
    Given I am on the Taylor Wimpey website
    And I accept the cookies message if available accessed via HOME page
    And I enter a "<City>" name
    And I select Price range
    And I select bedroom size
    Then I click cta Search
    And I land on the search result page for "<City>"
    Examples:
      | City |
      | Kent |

  Scenario Outline: Search with valid POSTCODE
    Given I am on the Taylor Wimpey website
    And I accept the cookies message if available accessed via HOME page
    And I enter a "<Postcode>" name
    And I select Price range
    And I select bedroom size
    Then I click cta Search
    And I land on the search result page for Postcode
    Examples:
      | Postcode |
      | CV6 7AU  |

  Scenario Outline: Search with valid GEOCITY
    Given I am on the Taylor Wimpey website
    And I accept the cookies message if available accessed via HOME page
    And I enter a "<GeoCity>" name
    And I select Price range
    And I select bedroom size
    Then I click cta Search
    And I am provided with which Did you mean page and select first option
    And I land on the search result page for the selected option
    Examples:
      | GeoCity   |
      | Yorkshire |