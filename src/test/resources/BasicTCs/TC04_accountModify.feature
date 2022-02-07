@BasicTCs
Feature: As a user I want to modify my account

  @ModifyAccount
  Scenario Outline: modify account scenario
    Given user is on the home page
    And  user wants to modify his "<firstName>" or his "<LastName>" or his "<PhoneNbre>" or his "<adress>"
    Then  the information "<firstName>" or his "<LastName>" or his "<PhoneNbre>" or his "<adress>" should be successfully modified in his account
    Examples:
      | firstName | LastName    |PhoneNbre | adress        |
      | wass      | benmess     |4444444444| nanterrrrrre  |

