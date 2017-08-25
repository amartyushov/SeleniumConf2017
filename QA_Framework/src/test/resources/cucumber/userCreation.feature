@deleteAll
Feature: create user

  Scenario: check user is not null
    Given create user with params
      | key  | value |
      | name | Alex  |
    Then user has name "Alex"