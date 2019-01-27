Feature: Make Payment
  Scenario: Make Payment

    Given I logged into the bank Application

    When I make payment with the app 

    Then App should accept the payment