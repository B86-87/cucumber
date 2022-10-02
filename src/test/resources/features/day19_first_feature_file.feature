@google_search @smoke_test
Feature: Search Feature

  Background: User_goes_to_google
    Given user is on the google page

    @iphone
  Scenario: TC01_iphone_search
    When user search for iPhone on google
    Then verify the page title contains iPhone
    Then close the application

  @teapot @skip_scenario
  Scenario: TC02_teapot_search
    When user search for TeaPot on google
    Then verify the page title contains TeaPot
    Then close the application

#  Create GoogleStepDefs and write JAVA Code
#  When you write JAVA code use page object model
#  For that, in pages, create GooglePage class and locate the google page objects
#  Test Cases Runs from TOP TO BUTTOM from the feature file. NOT STEP DEFINITIONS
#  Background: is used for preconditions. It runs before each Scenario:


#  HOW TO IGNORE TEST SCENARIOS IN CUCUMBER
#  1. tags = "@google_search and not @teapot" -> run @google_search tags but do not run @teapot tags
#  2. HOOKS =
#  @Before(value = "@skip_scenario")
#    public void setUp(Scenario scenario){
#//        RUNS BEFORE EACH SCENARIO
#        System.out.println("SKIPPED : "+scenario.getName());
#        Assume.assumeTrue(false);//
#    }