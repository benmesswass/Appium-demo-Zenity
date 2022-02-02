@BasicTCs
Feature: As a user I want to register a user account

  @Registration
  Scenario Outline: Registration scenario
    Given user is on the login page
    When user clicks on register button
    And  user enters his "<mail>" his "<password>" and "<confirmPassword>"
    Then  user should be registered with his "<mail>" and his "<password>"
    Examples:
      | mail                         | password      | confirmPassword |
      | gregoryzenityyopmail.com     | Test12345     | Test12345       |
      #| wasszenity@yopmail.com       | Test12345     | Test12345       |
      #| gregoryzenity@yopmail.com    | Test12345     | Test123         |

