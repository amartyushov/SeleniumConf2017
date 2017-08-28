@deleteAll
Feature: Check push notification

  Scenario: Check user service calls push notification service

    Given create user with params
      | key                     | value |
      | name                    | Alex  |
      | pushNotificationMessage | push  |
    And user has name "Alex"
    And send push notification to user "Alex"
    And Mock was called to notify user "Alex"