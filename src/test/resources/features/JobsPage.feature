@smokeB @regression @uat
Feature: Job Page

  Background: Validate All available options under Jobs
    Given I am on the Taylor Wimpey jobs home page
    When I click on Jobs Option on the header page
    Then I should be able to see all four options under jobs

  Scenario: Validate How We Work options under Jobs
    And I select the How We Work option under Jobs
    Then I can see all available options under How We Work

  Scenario: Validate options under How We Work
#     How we work option
    And I select the How We Work option under Jobs
    And I can see all available options under How We Work
#     Your Development option
    And I select option of Your development
    Then I am able to see Your development page
#     Inclusion & wellbeing option
    And I select option of Inclusion & wellbeing
    Then I am able to see Inclusion & wellbeing page
#     Benefits option
    And I select option of Benefits
    Then I am able to see benefits page
#     Who we are option
    And I select option of Who we are
    Then I am able to see Who we are page
#     Career converters option
    And I select option Career converters
    Then I am able to see Career converters page

  Scenario: Validate Jobs you can do options under Jobs
    And I select the Jobs you can do option under Jobs
    Then I can see all available options under Jobs you can do

  Scenario: Validate options under Jobs you can do
#     Jobs you can do option
    And I select the Jobs you can do option under Jobs
    Then I can see all available options under Jobs you can do
#     Commercial option
    And I select option Commercial
    Then I am able to see Commercial page
#     Construction option
    And I select option Construction
    Then I am able to see Construction page
#     Customer Services option
    And I select option Customer Services
    Then I am able to see Customer Services page
#     Design & Technical option
    And I select option Design & Technical
    Then I am able to see Design & Technical page
#     Finance option
    And I select option Finance
    Then I am able to see Finance page
#     Head Office option
    And I select option Head Office
    Then I am able to see Head Office page
#     Land & Planning option
    And  I select option Land & Planning
    Then I am able to see Land & Planning page
#     Sales & Marketing option
    And I select opnt Sales & Marketing
    Then I am able to see Sales & Marketing page
#     Trade option
    And I select option Trade
    Then I am able to see Trade page

  Scenario: Validate Early careers options under Jobs
    And I select the Early careers option under Jobs
    Then I can see all available options under Early careers

  Scenario: Validate options under Early careers
#     Early careers option
    And I select the Early careers option under Jobs
    Then I can see all available options under Early careers
#     Apprenticeships option
    And I select option Apprenticeships
    Then I am able to see Apprenticeships page
#     Graduate scheme option
    And I select option Graduate scheme
    Then I am able to see Graduate scheme page
#     Management trainees option
    And I select option Management trainees
    Then I am able to see Management trainees page










