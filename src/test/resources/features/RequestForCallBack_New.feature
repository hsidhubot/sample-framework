@smokeB
Feature: Request for call back - WIP

  Scenario: Request Call Back - Back to selected developments - Brislington
    Given I setup default test data for the Development "Brislington Developments"
    When I directly access Request Call back Brochure Page for the listed development
    And I validate the breadcrumb on the Request Call back page
    And I accept the cookies message if available accessed via OTHER page
    Then I select Month Day and Time for the call back request
    And I provide all relevant details on the Request Call Back Form and Submit
    And success message is displayed
    And I validate the breadcrumb on the Request Call back page
    And select Back to selected development link landing on the development page

  Scenario: Request Call Back - See More Developments - Brislington
    Given I setup default test data for the Development "Brislington Developments"
    When I directly access Request Call back Brochure Page for the listed development
    And I validate the breadcrumb on the Request Call back page
    And I accept the cookies message if available accessed via OTHER page
    Then I select Month Day and Time for the call back request
    And I provide all relevant details on the Request Call Back Form and Submit
    And success message is displayed
    And I validate the breadcrumb on the Request Call back page
    And select See More development link landing on the search result page

  Scenario: Request Call Back - Back to selected developments - Clifton
    Given I setup default test data for the Development "Clifton Developments"
    When I directly access Request Call back Brochure Page for the listed development
    And I validate the breadcrumb on the Request Call back page
    And I accept the cookies message if available accessed via OTHER page
    Then I select Month Day and Time for the call back request
    And I provide all relevant details on the Request Call Back Form and Submit
    And success message is displayed
    And I validate the breadcrumb on the Request Call back page
    And select Back to selected development link landing on the development page

  Scenario: Request Call Back - See More Developments - Clifton
    Given I setup default test data for the Development "Clifton Developments"
    When I directly access Request Call back Brochure Page for the listed development
    And I validate the breadcrumb on the Request Call back page
    And I accept the cookies message if available accessed via OTHER page
    Then I select Month Day and Time for the call back request
    And I provide all relevant details on the Request Call Back Form and Submit
    And success message is displayed
    And I validate the breadcrumb on the Request Call back page
    And select See More development link landing on the search result page


# TWW-53 :  Request for call back












