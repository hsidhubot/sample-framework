@urlredirect @smokeC
Feature: URL Redirect - TWW-879

  Scenario: Customer Services URL mapping - Validate REDIRECT Links
    Given I validate the Redirect URL in the TEST csv file

  Scenario: Configure Dynamic URL Not Found
    Given I validate the Configure Dynamic URL Not Found TEST csv file
    And These listed URLs should get resolved successfully

#    Test The breadCrumbs

