
Feature: Create Public GIST

  Scenario: As a user, I want to create a public gist.
    Given I want to access github home page
    And I want to login using my github account
    And I want to create a public GIST on my github
    When I write the description on my GIST
    And I post it to my github page
    Then I can see my gist on my github account page