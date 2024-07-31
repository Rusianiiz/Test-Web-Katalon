@tag
Feature: Login Feature
  I want to use this template for my login feature file

  @tag1
  Scenario Outline: User logs in with valid credentials
    Given I open the browser and navigate to the URL
    When I login with username <username> and password <password>
    Then I should be redirected to the dashboard
    And I close the browser

    Examples: 
      | username | password           |
      | John Doe | ThisIsNotAPassword |
