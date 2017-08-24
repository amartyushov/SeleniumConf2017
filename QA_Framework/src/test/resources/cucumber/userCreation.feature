@deleteAll
Feature: create user
  mvn clean test -Dcucumber.options="--tags @deleteAll --plugin html:target/cucumber-html-report-myReport"

  Scenario: check user is created with name Alex
    Given create user with params
      | key  | value |
      | name | Alex  |
    Then user has name "Alex"
    And wait for 10 seconds

  Scenario: check user is created with name Ivan
    Given create user with params
      | key  | value |
      | name | Ivan  |
    Then user has name "Ivan"
    And wait for 10 seconds

  Scenario: check user is created with name Robert
    Given create user with params
      | key  | value  |
      | name | Robert |
    Then user has name "Robert"
    And wait for 10 seconds
