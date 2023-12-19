# new feature
# Tags: optional

  @GetEvents
Feature: Get Events

  Scenario: User Succesfully Get All Events
    Given I set API endpoint for get all events is available
    When I send a request GET to get all events
    And I should receive a status code of 200 for get all events
    Then The API should respond with a list of local art culture events

  Scenario: User Succesfully Get Detail Events By ID
    Given I set API endpoint for get detail events is available
    When I send a request GET to get detail events
    And I should receive a status code of 200 for get detail events by ID
    Then The API should respond with detailed information about the event


    #case negative

  Scenario: User Can not get detail event with invalid or non-existent ID
    Given I set API endpoint for get detail event with invalid ID
    When I send a request GET to get detail event with invalid ID
    Then I should receive a status code of 404 for invalid ID
    And The response body should contain an error message not found



