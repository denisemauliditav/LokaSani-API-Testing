@login
Feature: Login
  As a user
  I want to login
  So that I can manage users data

  Background:
    Given I set API endpoint for login

  Scenario Outline: As a user I can login with valid credentials
    When I send request to login with valid email "<email>" and valid password "<password>"
    Then I receive status code 200
    And I receive valid data for login
    Examples:
      | email                   | password  |
      | caron.nolan@example.com | fjwvp4m3l |

  Scenario Outline: As a user I can not login with unregistered credentials
    When I send request to login with unregistered email "<email>" and valid password "<password>"
    Then I receive status code 404
    And I receive message error
    Examples:
      | email         | password |
      | naja@gmailcom | 90       |