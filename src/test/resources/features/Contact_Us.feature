Feature: Webdriver University - Contac Us Page
  Scenario: Validate Successful Submission
    Given I access the webdriver university contact us page
    When Enter personal information
    And Enter a comment
    And Click on the submit button
    Then Should be presented with a successful contact us submission message