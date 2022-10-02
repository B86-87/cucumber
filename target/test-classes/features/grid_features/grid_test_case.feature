@cross_browser_testing
Feature: app_title_verification

  @grid_chrome
  Scenario: TC01_title_on_chrome
    Given user is on the application_url "https://www.bluerentalcars.com/"
    Then verify the page title is "Blue Rental Cars | Cheap, Hygienic, VIP Car Hire"
    Then close the remote driver


    @grid_firefox
    Scenario: TC02_title_on_firefox
      Given user is on the application_url "https://www.bluerentalcars.com/" with firefox
      Then verify the page title is "Blue Rental Cars | Cheap, Hygienic, VIP Car Hire"
      Then close the remote driver




