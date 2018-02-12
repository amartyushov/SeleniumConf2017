@deleteAll
Feature: create user

  Scenario: Check user is created with correct name
    Given create user with params
      | key  | value |
      | name | Alex  |
    Then user has name "AlexUU"