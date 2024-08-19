@login
Feature: Login page validation on cardio one website


  Scenario: Login with valid credential
    Given launch the application
    When login with valid Credential "syed.ali@concertidc.com" and "Ccare@123"
    Then Verify the success msg ""
    Then It should redirect to the dashboard page