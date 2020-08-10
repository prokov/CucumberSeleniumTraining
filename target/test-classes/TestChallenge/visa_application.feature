Feature: Visa application?
It's possible to apply for visa with valid data

Scenario OutLine: Login
Given go to login page
When login with valid credentials
Then user is logged in "<name>"" <surname>"
    Examples:
    | name      | surname|
    | Lev       | Tolstoy  |


Scenario Outline: Visa application
    Given go to Visa booking page
    When submit application with valid data "<date>"" <name>""<surname>"" <phone>"
    Then I should see application success page "<message>"
        Examples:
        | date            | name | surname|    phone      |  message |
        | 01.01.2020        | lev  | tolstoy|  16040456550| Submitted|


