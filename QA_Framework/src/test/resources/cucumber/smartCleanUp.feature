@api @bm @tm @hook
Feature: demonstration of robust cleanup
  mvn clean test -Dcucumber.options="--tags @hook --plugin html:target/cucumber-html-report-myReport"

  Scenario: first scenario
    And do nothing