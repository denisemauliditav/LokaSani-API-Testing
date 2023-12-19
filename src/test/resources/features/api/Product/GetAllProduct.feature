@GetAllProduct
Feature: Get all product
  As a user
  I want to retrieve a list of all available products
  So that I can view all the products at once

  Scenario: As a admin I can get all products successfully
    Given I set API endpoint for get all product
    When I send GET request to the endpoint to get all products
    Then the response status code should be 200
    And I receive valid data for get all products

#  Scenario: As a admin I can get all products by role
#    Given I set API endpoint with adding parameter role
#    When I send GET request to the endpoint to get all products by role
#    Then the response status code should be 200
#    And I receive valid data for get all products based on role


    ##case negative
  Scenario: As a admin I can not get products with invalid parameters
    Given I set invalid API endpoint for get all product with invalid parameters
    When I send GET request for get all product
    Then The response status code equal 400
    And I receive error message