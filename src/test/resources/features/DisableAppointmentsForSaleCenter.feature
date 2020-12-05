@smokeB
Feature: Disable appointments for Sales Centre - WIP

  Scenario: Disable appointments for Sales Centre - Finchley Developments
    Given I am on the Taylor Wimpey website for New Homes Page
    And I accept the cookies message if available accessed via OTHER page
    And I setup default test data for the Development "Finchley Developments"
    When I enter the location and perform search
    And I select "ALL" option from the search page Filter
    Then I land on the search result page for the New Homes
    And I validate that URL for "ALL" option is as expected
    And I validate the breadcrumb on the search result page
    Then I select view development Link for this development
    And I land on the Development page and able to see the action bar
    And I validate the breadcrumb on the development page
    And I ensure that "BOOK APPOINTMENTS" option is not available in the action bar
    And I ensure that "BOOK APPOINTMENTS" option is not available in the CONTACT US Section
    And I ensure that "BOOK APPOINTMENTS" option is not available on the Page
    And I select the card with required plot name
    And I am able to see the action bar on the PLOT page
    And I ensure that "BOOK APPOINTMENTS" option is not available in the action bar
    And I ensure that "BOOK APPOINTMENTS" option is not available in the CONTACT US Section
    And I ensure that "BOOK APPOINTMENTS" option is not available on the Page




# TWW-867 :  Disable appointments for Sales Centre












