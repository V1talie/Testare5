Feature: Are login and search working?
  Everybody wants to know if login and search works.

  Scenario: Login works
    Given MyAnimeList login page is opened
    When I enter correct login and pass info
    Then I'm logged in successfully

  Scenario: Search works
    Given MyAnimeList search page
    When I introduce a key word in search bar
    Then I'm given the results
