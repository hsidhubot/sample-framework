@smokeB
Feature: Download a brochure for a development - WIP

  Scenario: Download a brochure via Action Bar - Validate Success Messages After Form Submit
    Given I am on the Taylor Wimpey website for New Homes Page
    And I accept the cookies message if available accessed via OTHER page
    And I setup default test data for the Development "Brislington Developments"
    When I enter the location and perform search
    And I select "ALL" option from the search page Filter
    Then I land on the search result page for the New Homes
    And I validate that URL for "ALL" option is as expected
    And I validate the breadcrumb on the search result page
    Then I select view development Link for this development
    And I land on the Development page and able to see the action bar
    And I validate the breadcrumb on the development page
    Then I select "BROCHURE" option from the action bar
    And I land on the download brochure page for selected Development
    And I validate the breadcrumb on the download brochure page
    When I provide all relevant details on the Download Brochure Form and Submit
    Then I land on the new page where I can download the respective PDF
    And I validate PDF download page details and select BACK TO SELECTED DEVELOPMENT option

  Scenario: Download a brochure via Action Bar - Validate Success Messages - With no Form Submit
    Given I am on the Taylor Wimpey website for New Homes Page
    And I accept the cookies message if available accessed via OTHER page
    Given I setup default test data for the Development "Brislington Developments"
    When I enter the location and perform search
    And I select "ALL" option from the search page Filter
    Then I land on the search result page for the New Homes
    And I validate that URL for "ALL" option is as expected
    And I validate the breadcrumb on the search result page
    Then I select view development Link for this development
    And I land on the Development page and able to see the action bar
    And I validate the breadcrumb on the development page
    Then I select "BROCHURE" option from the action bar
    And I land on the download brochure page for selected Development
    And I validate the breadcrumb on the download brochure page
    And I select SKIP button
    Then I land on the new page where I can download the respective PDF
    And I validate PDF download page details and select SEE MORE DEVELOPMENTS option

  Scenario: Download a brochure via Action Bar - Access URL Directly
    Given I access the Download Brochure Page for Brislington Developments directly
    And I accept the cookies message if available accessed via OTHER page
    And I setup default test data for the Development "Brislington Developments"
    And I land on the download brochure page for selected Development
    And I validate the breadcrumb on the download brochure page
    And I select SKIP button
    Then I land on the new page where I can download the respective PDF
    And I validate PDF download page details and select SEE MORE DEVELOPMENTS option

  Scenario: Download a brochure via Action Bar - Access URL Directly
    Given I access the Download Brochure Page for Brislington Developments directly
    And I accept the cookies message if available accessed via OTHER page
    And I setup default test data for the Development "Brislington Developments"
    And I land on the download brochure page for selected Development
    And I validate the breadcrumb on the download brochure page
    And I select SKIP button
    Then I land on the new page where I can download the respective PDF
    And I validate PDF download page details and select SEE MORE DEVELOPMENTS option

  @brochureWIP
  Scenario: Download a brochure via Action Bar - Validate Success Messages - With no Form Submit
    Given I am on the Taylor Wimpey website for New Homes Page
    And I accept the cookies message if available accessed via OTHER page
    Given I setup default test data for the Development "Clifton Developments"
    When I enter the location and perform search
    And I select "ALL" option from the search page Filter
    Then I land on the search result page for the New Homes
    And I validate that URL for "ALL" option is as expected
    And I validate the breadcrumb on the search result page
    Then I select view development Link for this development
    And I land on the Development page and able to see the action bar
    And I validate the breadcrumb on the development page
    Then I select "BROCHURE" option from the action bar
    And I land on the download brochure page for selected Development
    And I validate the breadcrumb on the download brochure page
    And I select SKIP button
    Then I land on the new page where I can download the respective PDF
    And I validate PDF download page details and select SEE MORE DEVELOPMENTS option


#TWW-66 :  Download Brochure












