# new feature
# Tags: optional
@PostEvents
Feature: POST Events

  Background:
    Given I set API endpoint for creating a new event is available

#case positive
  Scenario: User successfully creates a new event
    When I send a request POST to create a new event with valid inputs
    And I should receive a status code of 200
    Then I should receive the details of the newly created event

#case negative
  Scenario: User can not create an event without required fields
    When I send a request to create a new event with required fields
    And I should receive a status code of 400 
    Then I should receive an error message indicating that the fields is empty

  Scenario:User can not create an event with invalid data format
    When I send a request to create a new event with invalid data format
    And I should receive a status code of 400
    Then I should receive an error message indicating that format not valid