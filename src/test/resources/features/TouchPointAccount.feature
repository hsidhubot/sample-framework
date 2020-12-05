@smoking @uat
Feature: Legacy Touch Point Account - Login - Register-Login - Update

  Scenario: Corporate legacy login after navigating to OTHER links in the home page and UPDATE
    Given I am on the Taylor Wimpey website
    And I accept the cookies message if available accessed via HOME page
    When I select Login Register Option
    And I log with valid credentials of an existing user
    Then I land on the Edit My Profile Touchpoint page
    And I am able to modify user details on this page
    And I click cta submit
    Then the successful update message should display
    And I click on return to website
    And I land on the Taylor Wimpey homepage
    And I click on Corporate Option on the header page for LEGACY PAGE
#    Then I should be able to see all four options under corporate for LEGACY PAGE
    And I click on JOB Option on the header page for LEGACY PAGE
#    When I click on Jobs Option on the header page
    Then I should be able to see all four options under jobs
    And I validate that TOUCHPOINT option is now available
    And I click Taylor Wimpey home
    And I select Login Register Option
    Then I verify touchpoint is active

  Scenario: Corporate legacy Create a new Account for Touchpoint
    Given I am on the Taylor Wimpey website
    And I accept the cookies message if available accessed via HOME page
    When I select Login Register Option
    Then I select Register HERE Option
    And I provide valid email and password for the new Account and submit the form
    Then I land on the Edit My Profile Touchpoint page
    And I logout from the touchpoint application
    And I land on the Taylor Wimpey homepage
    When I select Login Register Option
    And I log with credentials I created before in the steps
    Then I land on the Edit My Profile Touchpoint page

  Scenario: Corporate legacy login validation without navigating any other links on the page
    Given I am on the Taylor Wimpey website
    And I accept the cookies message if available accessed via HOME page
    When I select Login Register Option
    And I log with valid credentials of an existing user
    Then I land on the Edit My Profile Touchpoint page
    And I click on return to website
    And I land on the Taylor Wimpey homepage
    And I select Login Register Option
    Then I verify touchpoint is active

  Scenario: Corporate legacy Create a new Account for Touchpoint
    Given I am on the Taylor Wimpey website
    And I accept the cookies message if available accessed via HOME page
    When I select Login Register Option
    Then I select Register HERE Option
    And I provide valid email and password for the new Account and submit the form
    Then I land on the Edit My Profile Touchpoint page
    And I logout from the touchpoint application
    And I land on the Taylor Wimpey homepage
    When I select Login Register Option
    And I log with credentials I created before in the steps
    Then I land on the Edit My Profile Touchpoint page
    And I am able to modify user details on this page
    And I click cta submit
    Then the successful update message should display
