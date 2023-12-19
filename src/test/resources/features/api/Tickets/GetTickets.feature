# new feature
# Tags: optional
@GetTickets
Feature: GET Tickets

  #Case positive
  Scenario: Get All Tickets Successfully
    Given I set API endpoint for get all tickets is available
    When I send a request GET to get all tickets
    And I should receive a status code of 200 for get ticket
    Then The API should respond with a list of tickets

  Scenario: Get Tickets by Valid ID
    Given I set API endpoint to get tickets by valid ID
    When I send a request GET to get tickets by valid ID
    And I should receive a status code of 200 for get ticket
    Then The API should respond with a list of tickets to get tickets by valid ID

#  Scenario: Get Tickets based on VIP Tickets
#    Given I set API endpoint to get tickets based on VIP
#    When I send a request GET to get tickets based on VIP
#    And I should receive a status code of 200 for get ticket
#    Then The API should respond with a list of tickets to get tickets based on VIP
#
#  Scenario: Get Tickets based on Reguler Tickets
#    Given I set API endpoint to get tickets based on Reguler
#    When I send a request GET to get tickets based on Reguler
#    And I should receive a status code of 200 for get ticket
#    Then The API should respond with a list of tickets to get tickets based on Reguler

#  Scenario: Get Tickets based with Event Name Filter
#    Given I set API endpoint to get tickets with event name filter
#    When I send a request GET to get tickets with event name filter
#    And I should receive a status code of 200
#    Then The response should contain tickets from the specified event name

    #case negative
  Scenario: Can not get tickets with invalid or non-existent ID
    Given I set API endpoint for get a tickets with invalid ID
    When I send a request GET to get tickets invalid ID
    Then I should receive a status code of 404
    And I should receive an error message indicating that the tickets was not found

  Scenario: Can not get tickets with invalid endpoint API
    Given I set invalid API endpoint for get tickets
    When I send a request GET request with invalid endpoint
    Then I should receive a status code of 400
    And I should receive an error message indicating that bad request





