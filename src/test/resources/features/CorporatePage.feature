@smokeA @regression @uat
Feature: Corporate Pages

  Background: : Validate All available options under Corporate
    Given I am on the Taylor Wimpey website for Corporate Page
    And I accept the cookies message if available accessed via OTHER page
    When I click on Corporate Option on the header page
    Then I should be able to see all four options under corporate

  Scenario: Validate INVESTORS options under Corporate
    And I select the Investors option under Corporate
    Then I can see all available options under Investors

  Scenario: Validate INVESTORS options under Corporate
#   INVESTORS option
    And I select the Investors option under Corporate
    And I can see all available options under Investors
#   Shareholder option
    Then I select the option of Shareholder centre
    And I am able to see Shareholder centre page
#   Results and reports option
    Then I select the option of Results and reports
    And I am able to see Results and reports page
#   2019 Annual Report option
    Then I select the option of 2019 Annual Report
    And I am able to see 2019 Annual Report page
#   Financial calendar option
    Then I select the option of Financial calendar
    And I am able to see Financial calendar page
#   Shareholder option
    Then I select the option of Analysts and Advisors
    And I am able to see Analysts and Advisors page
#   RNS announcements option
    Then I select the option of RNS announcements
    And I am able to see RNS announcements page
#   Shareholder option
    Then I select the option of 2020 Equity Raise
    And I am able to see 2020 Equity Raise page


  Scenario: Validate SUSTAINABILITY options under Corporate
#   Sustainability option
    And I select the Sustainability option under Corporate
    And I can see all available options under Sustainability
#   Sustainability in review option
    Then I select the option of Sustainability in review
    And I am able to see Sustainability in review page
#   Approach option
    Then I select the option of our Approach
    And I am able to see our approach page
#   Stakeholders and materiality option
    Then I select the option of Stakeholders and materiality
    And I am able to see Stakeholders and materiality page
#   Modern Slavery Act option
    Then I select the option of Modern Slavery Act
    And I am able to see Modern Slavery Act page

  Scenario: Validate OUR COMPANY options under Corporate
#   Our Company option
    And I select the our company option under Corporate
    And I can see all available options under our company
#   About Our Company option
    And I select the about our company option under Corporate
    And I am able to see about our company page
#   Board of Directors option
    Then I select the option of Board of Directors
    And I am able to see Board of Directors page
#   Group Management Team option
    Then I select the option of Group Management Team
    And I am able to see Group Management Team page
#   Governance option
    Then I select the option of Governance
    And I am able to see Governance page
#   Contacts option
    Then I select the option of Contacts
    And I am able to see Contacts page


