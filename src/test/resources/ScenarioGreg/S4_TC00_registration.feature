@ScenarioGreg
Feature: As a user I want to register a user account

  Scenario Outline: Registration scenario
    Given user is on the login page
    When user clicks on register button
    And  user enters his "<mail>" his "<password>" and "<confirmPassword>"
    Then  user should be registered with his "<mail>" and his "<password>"
    Examples:
      | mail                         | password      | confirmPassword |
      | gregyopmail.com     | Test12345     | Test12345       |
      | greg@yopmail.com       | Test12345     | Test12345       |
      #| greg@yopmail.com    | Test12345     | Test12         |

