@db_read
Feature: db_customer_information

  Background: Connecting to the DB
    Given user connects to the application database

  Scenario: TC01_read_customer_ssn_info
    And user gets the column "*" from table "tp_customer"
    And user reads all of the column "ssn" data
    Then user close the connection


#  Print the phone number of customers
  Scenario: TC02_read_customer_phone_info
    And user gets the column "*" from table "tp_customer"
    And user reads all of the column "phone_number" data
    Then user close the connection

#    Print the city of customers
  Scenario: TC03_read_customer_city_info
    And user gets the column "*" from table "tp_customer"
    And user reads all of the column "city" data
    Then user close the connection


#  Print the first name of the users
  Scenario: TC04_read_user_first_names
    And user gets the column "*" from table "jhi_user"
    And user reads all of the column "first_name" data
    Then user close the connection

    #  Print the login name of the users
  Scenario: TC05_read_user_login
    And user gets the column "*" from table "jhi_user"
    And user reads all of the column "login" data
    Then user close the connection

        #  Print the login name of the users
  Scenario: TC06_read_user_account
    And user gets the column "*" from table "tp_account"
    And user reads all of the column "account_type" data
    Then user close the connection


    @verify_user_logins
    Scenario: TC07_verify_user_logins
      And user gets the column "*" from table "jhi_user"
      Then verify table "jhi_user" and column "login" contains data "abidin321"
      Then user close the connection

#      verify if user emails contains aby@yahoo.com

  Scenario: TC08_verify_user_emails
    And user gets the column "*" from table "jhi_user"
    Then verify table "jhi_user" and column "email" contains data "aby@yahoo.com"
    Then user close the connection


#    verify user account > account type contains : SAVING, CREDIT_CARD, CHECKING, INVESTING
  @verify_account_types
  Scenario: TC09_verify_user_account_types
    And user gets the column "*" from table "tp_account"
    Then verify table "tp_account" and column "account_type" contains data "SAVING"
    Then verify table "tp_account" and column "account_type" contains data "CREDIT_CARD"
    Then verify table "tp_account" and column "account_type" contains data "CHECKING"
    Then verify table "tp_account" and column "account_type" contains data "INVESTING"
    Then user close the connection

    #    verify user account > account type contains : SAVING, CREDIT_CARD, CHECKING, INVESTING
  @verify_account_types_SA
  Scenario Outline: TC09_verify_user_account_types
    And user gets the column "*" from table "tp_account"
    Then verify table "tp_account" and column "account_type" contains data "<data>"
    Then user close the connection

    Examples: data
    |data       |
    |SAVING    |
    |CREDIT_CARD   |
    |CHECKING   |
    |INVESTING   |

#
  Scenario: TC_10_get_column_names
    And user gets the column "*" from table "tp_account"
    Then verify the columns names from table "tp_account" contains data "balance"


