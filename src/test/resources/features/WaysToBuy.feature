Feature: Ways To Buy - All sub options

  Background: : Ways to buy page
#    Given I am on the Taylor Wimpey website
    Given I am on the Taylor Wimpey website for Ways to Buy
    And I accept the cookies message if available accessed via OTHER page
#    And I click on Ways to buy nav
    Then I should see Ways to buy page header

  @regression @smokeC @uat
  Scenario: Buyer guides
    When I click on Buyer guides nav
    Then I should see Buyer guides page

  @regression @smokeC
  Scenario: Help to Buy & Where do you want to live
    Given I click on Help to buy
    Then I should see help to buy page header
    When I click on Help to Buy England
    Then I should see how help to buy work in England page header
    When I click on Help to buy Scotland
    Then I should see how help to buy work in Scotland page header
    When I click on how Help to buy work in Wales
    Then I should see how Help to buy work in Wales page header
    When I click on how Help to buy work in London
    Then I should see how Help to buy work in London

  @regression @smokeC @uat
  Scenario: Part exchange
    Given I click on Part exchange navs
    Then I should see Part exchange page header

  @regression @smokeC @uat
  Scenario: Easymover
    Given I click on Easymover navs
    Then I should see Easymover page header

  @regression @smokeC @uat
  Scenario: Home reach
    Given I click on Home reach navs
    Then I should see Home reach page header

  @regression @smokeC @uat
  Scenario: Care worker offer
    Given I click on Care worker offer navs
    Then I should see Care worker offer page header

  @regression @smokeC @uat
  Scenario: Stamp duty holiday
    Given I click on Stamp duty holiday navs
    Then I should see Stamp duty holiday page header

# Land Transaction Tax holiday  & LBTT holiday---- NOT IN QA Environment
  @regression @uat
  Scenario: Land Transaction Tax holiday
    Given I click on Land Transaction Tax holiday navs
    Then I should see Land Transaction Tax holiday page header

  @regression @uat
  Scenario: LBTT holiday
    Given I click on LBTT holiday navs
    Then I should see LBTT holiday page header

  @regression @smokeC @uat
  Scenario: First home fund
    Given I click on First home fund navs
    Then I should see First home fund page header
    


