@smokeB
Feature: Validate Image caveats on Development and PLOT Page

  Background:
    Given I am on the Taylor Wimpey website for New Homes Page
    And I accept the cookies message if available accessed via OTHER page
#    And I setup up test data for Brislington Developments scenario
    Given I setup default test data for the Development "Brislington Developments"
    When I enter the location and perform search
    Then I land on the search result page for the New Homes
    And I validate the breadcrumb on the search result page

  Scenario: Validate Image caveats on Development And PLOT Page - not on the Other Pages Like Search Result Page- TWW-909
    And I ensure that Image Caveats of the said Image is not available on the search Result page for Brislington Developments
    Then I select view development Link for this development
    And I validate the breadcrumb on the development page
    Then I validate the number of plots available under that development
    And I ensure that Image Caveats of the said Image are available on the Development Page for Brislington Developments
    And I select the card with required plot name
    And I also validate that image gallery is displayed on the PLOT Page
    And I ensure that Image Caveats of the said Image are available on the PLOT-3 for Brislington Developments

#  Scenario: Validate Image caveats on PLOT Page And not on the Other Pages Like Search Result Page- TWW-909
#    And I ensure that Image Caveats of the said Image is not available on the search Result page for Brislington Developments
#    Then I select view development Link for this development
#    And I validate the breadcrumb on the development page
#    Then I validate the number of plots available under that development
#    And I select the card with required plot name
#    And I also validate that image gallery is displayed on the PLOT Page
#    And I ensure that Image Caveats of the said Image are available on the PLOT-3 for Brislington Developments







