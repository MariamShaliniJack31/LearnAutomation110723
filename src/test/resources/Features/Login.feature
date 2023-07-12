#Test Case 1
#@Smoke
Feature: Login to the application as Admin

  Scenario: Login to the application as Admin
    Given Open the "URL" in browser as Admin
    And Login to application as Admin with "UserName" and "Password"
    When I click on "Login" button
    Then I verify "Dashboard / nopCommerce administration" Title on HomePage
    When I click on "Logout" button

  Scenario: Login to the application as Admin TC2
    Given Open the "URL" in browser as User
   	And Login to application as Admin with "UserName" and "Password"
    When I click on "Login" button
    Then I verify "Dashboard / nopCommerce administration" Title on HomePage
   	When I click on "Logout" button