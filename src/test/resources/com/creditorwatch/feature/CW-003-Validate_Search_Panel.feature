Feature:Validate Search Panel

  Background:
    When i click blog
    Then i should go to blog page

  @Scenario1
  Scenario: Verify free search
    When i click search button
    Then all the articles should be displayed


  @Scenario2
  Scenario: Verify Keyword search
    When i enter keyword and click search button
      | bad debt  |
    Then all the articles relate to keyword should be displayed

