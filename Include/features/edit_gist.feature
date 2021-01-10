
Feature: Edit Public GIST

  Scenario: As a user, I want to edit an existing gist.
    Given I want to access github home page
    And I want to login using my github account
    And I want to edit a public GIST on my github
    When I write the new description on my GIST
    And I update my GIST
    Then I can see my gist on my github account page