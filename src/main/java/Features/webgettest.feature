Feature: Get Weather Info
  Scenario: Get weather details Pune

    Given I have url to get weather for Pune

    When I successfully sent the request 

    Then I should get weather details