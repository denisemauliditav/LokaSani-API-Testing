# new feature
# Tags: optional
@CreateNewDataProduct
Feature: Create a new product
  As a user
  I want to add a new product
  So that I can make it available for purchase

  Background:
    Given I set API endpoint for creating a new product is available

  @CreateNewDataProduct-Positive
  Scenario: As a admin I can create a new product with valid inputs
    When I send a request POST to create a new product with valid inputs
    And I should receive a status code of 200
    Then I should receive the details of the newly created product

    @CreateNewDataProduct-Negative
  Scenario:As a admin I can not create new product with duplicate fields
    When I send a request to create a new product with duplicate fields
    And I should receive a status code of 500
    Then I should receive an error message error in create new data product

