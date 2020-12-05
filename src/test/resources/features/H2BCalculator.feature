@regression @smokeB
Feature: Help to Buy Calculator - Scotland

  Scenario Outline: How much can i get with H2B
    Given I am on the Taylor Wimpey website for Ways to Buy
    And I accept the cookies message if available accessed via OTHER page
    Then I should see Ways to buy page header
    Given I click on Help to buy
    Then I should see help to buy page header
    And I select my prefer "<region>" and minimum deposit "<deposit>"
    And I click cta Calculate
    Then Help to buy amount should display
    Examples:
      | region   | deposit |
      | Scotland | 4000    |