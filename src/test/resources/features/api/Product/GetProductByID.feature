
@GetProductByID-Get
Feature: Get product by ID
    As a user
    I want to get product details by its unique ID
    So that I can view its specific information

    Scenario: As a admin I can get a product by valid ID
        Given I set API endpoint for get a product by ID
        When I send a request to get the product with the valid ID
        Then I should receive a status code of 200 for get a product by ID
        And I should receive the details of the product associated with the provided ID

    Scenario: As a admin I can not get product with invalid or non-existent ID
        Given I set API endpoint for get a product with invalid ID
        When I send a request GET to get product invalid id
        Then I should receive a status code of 404
        And I should receive an error message indicating that the product was not found