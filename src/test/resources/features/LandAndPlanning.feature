@regression @smokeB @uat
Feature: Land and Planning Pages

  Background: : Validate All available options under Land and Planning
    Given I am on the Taylor Wimpey website for Land and Planning Page
    And I accept the cookies message if available accessed via OTHER page
    Then I should be able to see all six options under Land and Planning

  Scenario: Validate WHY TAYLOR WIMPEY options under Land and Planning
    And I select the Why Taylor Wimpey option under Land and Planning.
    Then I can see all available options under Why Taylor Wimpey

#   Planning and design option
    Then I select the option of Planning and design
    And I am able to see Planning and design page
#   Community and customers option
    Then I select the option of Community and customers
    And I am able to see Community and customers page
#   Sustainability option
    Then I select the option of Sustainability
    And I am able to see Sustainability page

  Scenario: Validate OUR APPROACH options under Land and Planning
#   Our approach option
    And I select the Our approach option under Land and Planning
    And I can see all available options under Our approach
#   Why Taylor Wimpey option
    Then I select the option of Why Taylor Wimpey card
    And I am able to see Why Taylor Wimpey page
#   Acquiring land option
    Then I select the option of Acquiring land
    And I am able to see Acquiring land page
#   Contact us option
    Then I select the option of Contact us
    And I am able to see Contact us page

#   Acquiring land option
  Scenario: Validate ACQUIRING LAND options under Land and Planning
    And I select the Acquiring land option under Land and Planning
    And I am able to see Acquiring land landing page

#   Case studies option
  Scenario: Validate CASE STUDIES options under Land and Planning
    And I select the Case studies option under Land and Planning
    And I am able to see Case studies page

#   Contact us option
  Scenario: Validate CONTACT US options under Land and Planning
    And I select the Contact us option under Land and Planning
    And I am able to see Contact us landing page


