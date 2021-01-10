
Feature: Delete Public GIST

  Scenario: As a user, I want to delete an existing gist.
    Given I want to access github home page
    When I want to login using my github account
    And I want to see my list gist
    Then I delete one of my gist