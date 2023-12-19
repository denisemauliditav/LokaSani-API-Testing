# new feature
# Tags: optional
@PostTickets
Feature: POST Tickets

Background:
    Given I set API endpoint for creating a new ticket is available
    #case positive
  Scenario: Successfully create a new ticket with valid inputs
        When I send a request POST to create a new ticket with valid inputs
        And I should receive a status code of 200
        Then I should receive the details of the newly created ticket

          #case negative
    Scenario: Can not create new ticket with missing required fields
        When I send a request POST to create a new ticket with missing required fields
        And I should receive a status code of 400 for missing required fields
        Then I should receive message error from missing required fields


    Scenario: Can not create new ticket with negative quantity
        When I send a request POST to create a new ticket with negative quantity
        And I should receive a status code of 400 for negative quantity
        Then I should receive message error from negative quantity





