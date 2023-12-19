# new feature
# Tags: optional
@PutEvents
Feature: PUT Events

  Background:
    Given I set API endpoint for update event
  #case positive
  Scenario:  Successful Update Name Event Information
    When I send a request PUT request to update name information
    And I should receive a 200 OK response
    Then The response should contain of the updated event with the changed event name

  Scenario:  Successful Update Description Event Information
    When I send a request PUT request to update a description
    And I should receive a 200 OK response
    Then The response should contain of the updated event with the changed event description

  Scenario:  Successful Update Date Event Information
    When  I send a request PUT request to update a date
    And I should receive a 200 OK response
    Then The response should contain of the updated event with the changed event date

    #case negative
  Scenario: Updated Event with Invalid Event ID
    Given I set API endpoint for update event with invalid event ID
    When I send a request PUT request to update a date with invalid event ID
    And I should receive a 500 code
    Then The response should contain an error message indicating that the event ID is not found

  Scenario:  Updated Event with Invalid URL
    Given I set invalid endpoint API for update event with invalid event URL
    When I send a request PUT request to update a date with invalid event URL
    And I should receive a 404 code for update event with invalid url
    Then The response should contain an error message indicating that not found


