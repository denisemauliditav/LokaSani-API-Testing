# new feature
# Tags: optional
@PutTickets
Feature: PUT Tickets

  Background:
    Given I set API endpoint to update tickets available
  #case positive
  Scenario: Successful Update Detail Tickets with Existent ID
    When I send a request PUT request to update tickets with valid ID
    And I should receive a 200 OK response
    Then The response should contain of the updated detail tickets

  Scenario: Successful Update Tickets Quantity
    When I send a request PUT request to quantity tickets
    And I should receive a 200 OK response
    Then The response should contain of the updated event with the changed quantity tickets

#  Scenario: Successful Update Tickets Due Date
#    When I send a request PUT request to date tickets
#    And I should receive a 200 OK response
#    Then The response should contain of the updated event with the changed date tickets

    #case negative
  Scenario: Can not update tickets with invalid or non-existent ID
    Given I set API endpoint for update a tickets with invalid ID
    When I send a request PUT to update tickets invalid ID
    Then I should receive a status code of 404
    And I should receive an error message indicating that the tickets was not found

  Scenario: Can not update tickets with invalid endpoint API
    Given I set invalid API endpoint tickets for update tickets
    When I send a request PUT request with invalid endpoint
    Then I should receive a status code of 404 for update ticket
    And I should receive an error message indicating that not found

