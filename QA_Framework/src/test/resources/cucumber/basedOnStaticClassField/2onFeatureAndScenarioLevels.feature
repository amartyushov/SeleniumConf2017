@first_setup
Feature: demonstration of hook implementation based on static field in class (Mixed)

  Scenario: 1. First scenario
    And step for scenario "one"

  Scenario: 2. Second scenario
    And step for scenario "two"

  @second_setup
  Scenario: 3. Third scenario
    And step for scenario "three"

  # it means that here scenario expects testdata prepared
  # by hook @first_setup
  # but in fact here will be data from hook @second_setup
  Scenario: 4. Fourth scenario
    And step for scenario "four"
