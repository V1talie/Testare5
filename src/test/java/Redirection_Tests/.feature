Feature: Are redirections working?
  Everybody wants to know if redirection works.

  Scenario: Redirection works
    Given MyAnimeList main page is opened
    When I click on "Login" button
    Then I'm redirected to login page

  Scenario: Login without a password is not working
    Given MyAnimeList login page
    When I introduce an email with a wrong password
    Then I'm not able to login