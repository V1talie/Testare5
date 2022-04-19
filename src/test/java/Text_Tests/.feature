Feature: Text writing to profile(description,comments)

  Scenario: Add profile description
    Given MyAnimeList profile settings is opened
    When I insert string in about me
    Then the description is updated on profile

    Scenario: Add comment on profile
      Given MyAnimeList profile  is opened
      When I insert string in comment
      Then the comments are updated
