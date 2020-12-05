@smoking @regression @legacy
Feature: Book an Appointment - Legacy

  Scenario Outline: Validate Error Messages when booking an appointment in legacy system
    Given I am on the Taylor Wimpey website
    And I accept the cookies message if available accessed via HOME page
    And I enter a "<City>" name
    And I select Price range
    And I select bedroom size
    Then I click cta Search
    When I click on cta Book an appointment
    And I select preferred date and time for the appointment
    And I am able to see user details required for the appointment
    And I submit without providing all details
    Then valid error messages should be displayed

    Examples:
      | City              |
      | Cheshire, England |

  Scenario Outline: Book an appointment on the legacy system
    Given I am on the Taylor Wimpey website
    And I accept the cookies message if available accessed via HOME page
    And I enter a "<City>" name
    And I select Price range
    And I select bedroom size
    Then I click cta Search
    When I click on cta Book an appointment
    And I select preferred date and time for the appointment
    And I provide all user details required for the appointment

    Examples:
      | City              |
      | Cheshire, England |

