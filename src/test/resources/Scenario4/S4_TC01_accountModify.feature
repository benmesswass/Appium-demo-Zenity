@non-reg
@Scenario4
Feature: As a user I want to modify my account

  Scenario Outline: modify account scenario
    Given user is on the home page
    When  user wants to modify his "<firstName>" or his "<LastName>" or his "<PhoneNbre>" or his "<Adress>"
    Then  the information "<firstName>" or his "<LastName>" or his "<PhoneNbre>" or his "<Adress>" should be successfully modified in his account
    Examples:
      | firstName         | LastName          |PhoneNbre | Adress    |
      | wassim              | benmessaoud          |0654554512| nanterre2  |
