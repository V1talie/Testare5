Feature: Are search accessing and friend adding working?
  Everybody wants to know if search access and friend adding works.

  Scenario: Search accessing works
    Given MyAnimeList search bar is given
    When I enter text in search bar and access search element
    Then I'm redirected to the search element successfully

  Scenario: Adding a friend works
    Given MyAnimeList friend page
    When I click on adding a friend
    Then I'm adding a friend

