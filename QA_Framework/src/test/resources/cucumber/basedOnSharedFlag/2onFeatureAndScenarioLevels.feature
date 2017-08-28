@general_hook_first
Feature: demonstration of hook implementation based on shared static flag (Mixed)

  Scenario: 1. First scenario
    And step for scenario "one"

  Scenario: 2. Second scenario
    And step for scenario "two"

  @general_hook_second
  Scenario: 3. Third scenario
    And step for scenario "three"

  Scenario: 4. Fourth scenario
    And step for scenario "four"
