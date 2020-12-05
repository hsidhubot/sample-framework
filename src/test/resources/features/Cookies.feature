@regression @smokeA
Feature: Cookies Notification

  Scenario: Validate Cookies Info - OTHER PAGE
    Given I am on the Taylor Wimpey website for Inspire Me
    #Then scan the accessibility issues for page "Home"
    When I click on cta Read more when on OTHER page
    Then i should be taken to Cookies Read More page
    And I accept the cookies message if available accessed via OTHER page


#  DISABLED AS HOME PAGE NOT ACCESSIBLE FROM HOME PAGE

#  Scenario: Cookies - When Accessed via HOME PAGE
#    Given I am on the Taylor Wimpey website
#    Then I validate the cookies banner page accessed via home page
#    #Then scan the accessibility issues for page "Home"
#    When I click on cta Read more when on HOME PAGE
#    Then i should be taken to Cookies Read More page