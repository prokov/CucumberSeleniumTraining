Feature: Sanity test
Bacid user flow happy paths work

Scenario OutLine: Login
     Given go to login page
     When login with valid credentials "<email>"" <password>"
     Then user is logged in "<name>"" <surname>"
         Examples:
        | name      | surname|  email                | password |
        | Lev       | Tolstoy|  lev.tolstoy@gmil.com | Welcome1!|


Scenario Outline: Visa application
    Given go to Visa booking page
    When submit application with valid data "<date>"" <name>""<surname>"" <phone>"
    Then I should see application success page "<message>"
        Examples:
        | date            | name | surname|    phone      |  message |
        | 01.01.2020        | lev  | tolstoy|  16040456550| Submitted|


