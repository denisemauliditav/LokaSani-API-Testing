# new feature
# Tags: optional
@UpdateProduct
Feature: Update Product By ID
  As a user
  I want to update data product for a specific
  So that I can modify the content or details

Background:
  Given I set API for update product

  @CasePositiveUpdateProduct1
  Scenario: As a admin I can update product with name only
    When I send request PUT to update product with name only
    Then The response status code should be 200
    And The response should contain the details of the updated product with the changed name

  @CasePositiveUpdateProduct2
  Scenario: As a admin I can update product with price only
    When I send request PUT to update product with price only
    Then The response status code should be 200
    And The response should contain the details of the updated product with the changed price

  @CasePositiveUpdateProduct3
  Scenario: As a admin I can update product with description only
    When I send request PUT to update product with description only
    Then The response status code should be 200
    And The response should contain the details of the updated product with the changed description

 #######################  # CASE NEGATIVE #######################################
  @CaseNegativeUpdateProduct1
    Scenario: As a admin I can not update product with invalid ID
      Given I set API for update product with invalid ID
      When I send request PUT to update product with invalid ID
      Then The response status code should be 404
      And The response should contain an error message indicating that the product ID is not found
  @CaseNegativeUpdateProduct2
  Scenario: As a admin I can not update product with empty fields
      Given I set API for update product with empty ID
      When I send request PUT to update product with empty ID
      Then The response status code should be 404
      And The response should contain an error message indicating that the update data is not found