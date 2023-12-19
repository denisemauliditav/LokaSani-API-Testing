# new feature
# Tags: optional
@Delete-ProductByID
Feature:  Delete a product
  As a user
  I want to delete a product by its ID
  So that I can remove it from the system

  Scenario: Sucessfully delete product by valid ID
    Given I set API endpoint for delete product By valid ID
    When I send a request to delete the product with the valid ID
    And I should receive a status code of 200
    Then The product was deleted successfully

  Scenario: Can not delete a product with invalid or non-existent ID
    Given I set API endpoint for delete product By invalid ID
    When I send a request to delete the product with the invalid ID
    And I should receive a status code of 404 for invalid ID
    Then The product fails to be deleted and an error message appears that product data not found