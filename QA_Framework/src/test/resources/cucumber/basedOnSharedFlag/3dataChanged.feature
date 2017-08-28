@general_hook_first
Feature: demonstration of concept data_changed

  Scenario: 1. First scenario
    And step for scenario "one"

  Scenario: 2. Second scenario
    And step for scenario "two"

  @general_hook_second
  Scenario: 3. Third scenario
    And step for scenario "three"

  Scenario: 4. Fourth scenario
    And step for scenario "four"

  Scenario: 5. Fourth scenario
    And step for scenario "five"

  @data_changed
  Scenario: 6. Fourth scenario
    And step for scenario "six"

  Scenario: 7. Fourth scenario
    And step for scenario "seven"

