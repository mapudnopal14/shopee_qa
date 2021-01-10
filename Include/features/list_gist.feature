
Feature: List GIST

  Scenario: As a user, I want to see my list gist.
    Given I want to access github home page
    When I want to login using my github account
    And I want to see my list gist
    Then I can see my gist list