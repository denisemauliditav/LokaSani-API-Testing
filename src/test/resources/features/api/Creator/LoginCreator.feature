# new feature
# Tags: optional

Feature: Login Creator

  Background:
    Given I set API endpoint for login creator

  Scenario Outline: As a user I can login creator with valid credentials
    When I send request to login creator with valid email "<email>" and valid password "<password>"
    Then I receive status code 200
    And I receive valid data for login creator
    Examples:
      | email            | password |
      | accnew@gmail.com | 123      |

#  Scenario Outline: As a user I can not login with unregistered credentials
#    When I send request to login with unregistered email "<email>" and valid password "<password>"
#    Then I receive status code 404
#    And I receive message error
#    Examples:
#      | email         | password |
#      | naja@gmailcom | 90       |