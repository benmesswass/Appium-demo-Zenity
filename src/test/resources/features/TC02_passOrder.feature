@non-reg
Feature: As a user I want to pass an order

  @Login
  Scenario Outline: passOrder scenario
    Given user is connected to his account
    When  user wants to add products to his cart
    Then  user should be able to confirm his order using his card information: "<cardNbre>" "<expirationDate>" and "<code>"
    Examples:
      | cardNbre                         | expirationDate      |code|
      | 4242424242424242                 | 12/24               |123 |