Feature: Verifying Docuphase Functionalities

  Background: 
    Given I on Docuphase Login Page

  #@Smoke
  #Scenario Outline: DIG_002-007 Check Login Invalid functionalities
    #Given I on Docuphase Login Page
    #Given I enter <username> and <password>
    #When I click on Dlogin button
    #Then I should be on homepage page
#
    #Examples: 
      #| username                        | password   |
      #| supriya@appliedaiconsulting.com | AAic111    |
      #| omkar@appliedaiconsulting.com   | Aaic@12345 |
      #| rahul@appliedaiconsulting.com   | Aaic_12345 |
      #| supriya@appliedaiconsulting.com |            |
      #|                                 |            |
#
  #@Smoke
  #Scenario: DIG_001 Check login valid functionality
    #Given I m on Docuphase login page
    #When I enter adminid as "supriya@appliedaiconsulting.com"
    #And I enters pswd as "Aaic@12345"
    #Then I click on login button
    #And then I will be on Docuphase homepage
