# new feature
# Tags: optional
@DeleteEvents
Feature: DELETE Events

  Scenario:  Sucessfully delete event with valid ID
    Given I set API endpoint for delete event By valid ID
    When I send a request to delete the event with the valid ID
    And I should receive a status code of 200
    Then The product was deleted successfully

  Scenario: Can not delete a event with invalid or non-existent ID
    Given I set API endpoint for delete event By invalid ID
    When I send a request to delete the event with the invalid ID
    And I should receive a status code of 404
    Then The product fails to be deleted and an error message appears that product data not found