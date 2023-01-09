@regex
Feature: Search Feature

  Scenario: TC01_create_Ii and any character
    When i open "https://www.bluerentalcars.com/" page
    When I open "https://www.google.com/" page
    When i open "https://www.amazon.com/" page
  @regex2
    Scenario: TC02_
      When user open "https://www.google.com/" page and search "Hello World" text


