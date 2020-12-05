@whyChooseus @regression @smokeC
Feature: Why choose us - all sub options

  Background: Why choose us page
#    Given I am on the Taylor Wimpey website
    Given I am on the Taylor Wimpey website for Why Choose us
    And I accept the cookies message if available accessed via OTHER page
    And I click on Why choose us navs
    Then I should see Why choose us page header

  Scenario: New homes in Spain
    When I click New Homes in Spain
    Then I should see New homes in Spain page header

  Scenario: Why Taylor Wimpey
    When I click on Why Taylor Wimpey
    Then I should see Taylor Wimpey page header

  Scenario: Touchpoint
    When I click on Touchpoint
    Then I should see Touchpoint page header

  Scenario: Personalise your home
    When I click on Personalise your home
    Then I should see Personalise your home page header

  Scenario: Why a new build
    When I click on Why a new build nav
    Then I should see a new build homes page header

  Scenario: Online buying journey
    When I click on Online buying journey nav
    Then I should see Online buying page header

  Scenario: Our homes
    When I click on Our homes nav
    Then I should see Our homes age header

  Scenario: Quality assurance
    When I click on Quality assurance nav
    Then I should see Quality assurance page header

  Scenario: Our reviews
    When I click on Our reviews nav
    Then I should see Our reviews page header

  Scenario: Building communities
    When I click on Building communities nav
    Then I should see Building communities page header

  Scenario: Charity and local support
    When I click on Charity and local support nav
    Then I should see Charity and local support page header

  Scenario: Taking sustainability seriously
    When I click on Taking sustainability seriously nav
    Then I should see Taking sustainability seriously page header