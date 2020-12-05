@smokeA @book
Feature: Book An Appointment - New Development

  Background:
    Given I am on the Taylor Wimpey website for New Homes Page
    And I accept the cookies message if available accessed via OTHER page
    And I setup up test data for Brislington Developments scenario
    When I enter the location and perform search
    Then I land on the search result page for the New Homes
    And I validate the breadcrumb on the search result page
    And I select view development Link for this development
    And I validate the breadcrumb on the development page
    Then I validate check the availability of the Appointment Feature
    And I select the time from the given options
    Then all other required fields of the form should be populated
#    And all the radio buttons are pre-populated with NO option selected

  Scenario: Validate Success Messages
    When I provide all relevant details on the Form and Submit
    Then I am provided with the success message and I validate all details

  Scenario: Validate Error Messages - EMPTY FORM
    When I submit without providing any details on the form
    Then I should be able to see the error message on the page

  Scenario: Validate Error Messages - INCORRECT EMAIL
    When I submit by providing incorrect email format on the form
    Then I should be able to see the error message on the page

  Scenario: Validate Error Messages - DO NOT SELECT FOLLOW UP RADIO OPTIONS
    When I submit by providing all Form details but not any follow up options
    Then I should be able to see the error message on the page

  Scenario: Validate Scenario to ensure that booked date is NO LONGER available for selection - TWW-835
    When I provide all relevant details on the Form and Submit
    Then I am provided with the success message and I validate all details
    And I am on the Taylor Wimpey website for New Homes Page
    When I enter the location and perform search
    Then I land on the search result page for the New Homes
    And I validate the breadcrumb on the search result page
    And I select view development Link for this development
    And I validate the breadcrumb on the development page
    Then I select previously selected Month and Date
    And I validate that previously booked time slot is not available

  Scenario: Validate Scenario to ensure that once a time has been booked - other time slots are not impacted - TWW-933
    When I provide all relevant details on the Form and Submit
    Then I am provided with the success message and I validate all details
    And I am on the Taylor Wimpey website for New Homes Page
    When I enter the location and perform search
    Then I land on the search result page for the New Homes
    And I validate the breadcrumb on the search result page
    And I select view development Link for this development
    And I validate the breadcrumb on the development page
    Then I select previously selected Month and Date
    And I validate that previously booked time slot is not available
    And I validate that other remaining slots for same day are still available for booking

  Scenario: Duplicate Tab - validate we get an error when we do try to access the same booking in another tab
    Then I create another tab before submitting the form
    When I provide all relevant details on the Form and Submit
    Then I am provided with the success message and I validate all details
    And I switch to newly created tab
    Then I select previously selected Month and Date and TIME
    And I provide all relevant details on the Form and Submit
    And I should be able to see please select another time error message on the page
    And I close the old tab
























