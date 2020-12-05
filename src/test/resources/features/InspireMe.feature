Feature: Inspire Me Page

  Background: Inspire me pages
    Given I am on the Taylor Wimpey website for Inspire Me
    And I accept the cookies message if available accessed via OTHER page
    And I click on Inspire me navigation
    Then I should see Inspire me page header

    #How to guides
    Given I click on How to guide header option
    Then I should see how to guide page header

    #Our latest guides
    When I click on How to boost wellness at home
    Then I should see wellness at home page header
    When I click on How to live a greener life
    Then I should see greener life page header
    When I click on How to give your bathroom a spa-like feel
    Then I should spa-like feel page header

  @smokeB
  Scenario: Inspire me pages - in QA
    When I click on How to design a child's room
    Then I should see child's room design page
    #Show home gallery
    Given I click on Show home gallery
    Then I should see Show home gallery page header

    #Trends
    Given I click on Trends
    Then I should see Trends page header

    #Our latest trends
    When I click on Home office interior design
    Then I should see interior design page header
    When I click on 2020 interior designs trends
    Then I should see 2020 interior design header
    When I click on 5 must haves for a contemporary kitchen
    Then I should see contemporary kitchen page header
    When I click on Bedroom storage
    Then I should see Bedroom storage page header

  @regression @uat
  Scenario: Inspire me pages - Live / UAT
    When I click on How to make most of the home
    Then I should see How to make most of the home page

    #Show home gallery
    Given I click on Show home gallery
    Then I should see Show home gallery page header

    #Trends
    Given I click on Trends
    Then I should see Trends page header

    #Our latest trends
    When I click on Home office interior design
    Then I should see interior design page header
    When I click on 2020 interior designs trends
    Then I should see 2020 interior design header
    When I click on 5 must haves for a contemporary kitchen
    Then I should see contemporary kitchen page header
    When I click on Bedroom storage
    Then I should see Bedroom storage page header
