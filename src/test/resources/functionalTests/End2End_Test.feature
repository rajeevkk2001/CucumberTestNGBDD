@NewVersionTest
Feature: Automated Test Steps
  Description: The purpose of the test is to do End to End integration


  Scenario Outline:
    Given user is on Home Page
    When he search for "dress"
    When choose to buy the first item
    When moves to checkout from mini cart
    When enter "<Customer>" personal details on checkout page
    When select same delivery address
    When select payment method as "check" payment
    When place the order

    Examples:
      | Customer |
      | Lakshay  |

