Feature: OracleNS flow funtionalities including smoke testcases

  Background: 
    Given I on Docuphase Login Page

  @Smoke
  Scenario: Create flow without flowname
  Given I m on Docuphase login page
  When I enter adminid as "supriya@appliedaiconsulting.com"
  And I enters pswd as "Aaic@12345"
  Then I click on login button
  Then I clcik on Create flow button
  And Clicked on OracleNS button
  
  
  @Smoke
  Scenario: To create flow without action
  Given I m on Docuphase login page
  When I enter adminid as "supriya@appliedaiconsulting.com"
  And I enters pswd as "Aaic@12345"
  Then I click on login button
  Then I clcik on Create flow button
  Then I entered flow name "flowtest1"
  When Clicked on OracleNS button for next page
  Then I click on Next button without Adaptor action
  Then I goto homepage and search for the flowname "flowtest1"
  Then I click on delete icon and deleted flow
  
  #@Smoke
  #Scenario: DIG_010 To Create flow with existing name
  #Given I m on Docuphase login page
  #When I enter adminid as "supriya@appliedaiconsulting.com"
  #And I enters pswd as "Aaic@12345"
  #Then I click on login button
  #Then I clcik on Create flow button
  #Then I entered flow name "flowtest"
  #Then I enter existing flowname "flowtest"
  #Then Click on OracleNS button
  #Then I goto homepage and search for the flowname "flowtest"
  #Then I goto homepage and search for the flowname
  #Then I click on delete icon and deleted flow
 #
  #@Smoke
  #Scenario: DIG_012 To create flow without adapter mapping
    #Given I m on Docuphase login page
    #When I enter adminid as "supriya@appliedaiconsulting.com"
    #And I enters pswd as "Aaic@12345"
    #Then I click on login button
    #Then I clcik on Create flow button
    #Then I entered flow name "flowtest"
    #When Clicked on OracleNS button for next page
    #Then I clicked on dropdown action
    #Then I Select Create Customer action & clicked on next btn
    #When I click on SignIn To Oracle Adaptor
    #Then I filled valid OAuth  Details
    #Then I create filter
    #Then I added adaptor mapping
    #Then I was on response mapping page and clicked on save button
    #Then I goto homepage and search for the flowname "flowtest"
    #Then I click on delete icon and deleted flow
    #
    #@Smoke
    #Scenario: DIG_019 To Clone flow
     #Given I m on Docuphase login page
    #When I enter adminid as "supriya@appliedaiconsulting.com"
    #And I enters pswd as "Aaic@12345"
    #Then I click on login button
    #Then I clcik on Create flow button
    #Then I entered flow name "flowtest"
    #When Clicked on OracleNS button for next page
    #Then I goto homepage and search for the flowname "flowtest"
    #Then I clicked on clone icon and clone the flow
    #Then I searched for cloned flow "Clone:clone2"
    #Then I click on delete icon deleted flow
    #Then Again search flowname "flowtest"
    #Then I click on delete icon and deleted flow
    #
    #@Smoke
    #Scenario: DIG_011 To delete Flow
     #Given I m on Docuphase login page
    #When I enter adminid as "supriya@appliedaiconsulting.com"
    #And I enters pswd as "Aaic@12345"
    #Then I click on login button
    #Then I clcik on Create flow button
    #Then I entered flow name "flowtest"
    #Then I entered flow name
    #When Clicked on OracleNS button for next page
    #Then I clicked on dropdown action
    #Then I Select Create Customer action & clicked on next btn
    #When I click on SignIn To Oracle Adaptor
    #Then I filled valid OAuth  Details
    #Then I create filter
    #Then I added adaptor mapping
    #Then I was on response mapping page and clicked on save button
    #Then I goto homepage and search for the flowname "flowtest"
    #Then I click on delete icon and deleted flow
    #
    #@Smoke
    #Scenario: DIG_013 To edit flow
    #When I enter adminid as "supriya@appliedaiconsulting.com"
    #And I enters pswd as "Aaic@12345"
    #Then I click on login button
    #Then I clcik on Create flow button
    #Then I entered flow name "flowtest"
    #When Clicked on OracleNS button for next page
    #Then I clicked on dropdown action
    #Then I Select Create Customer action & clicked on next btn
    #When I click on SignIn To Oracle Adaptor
    #Then I filled valid OAuth  Details
    #Then I create filter
    #Then I added adaptor mapping
    #Then I was on response mapping page and clicked on save button
    #Then I goto homepage and search for the flowname "flowtest"
    #Then I clicked on edit button checked
    #Then I goto homepage and search for the flowname "flowtest"
    #Then I click on delete icon and deleted flow
    #
    #@Functional
    #Scenario: DIG_017 To create flow with filter and publish flow
    #When I enter adminid as "supriya@appliedaiconsulting.com"
    #And I enters pswd as "Aaic@12345"
    #Then I click on login button
    #Then I clcik on Create flow button
    #Then I entered flow name "flowtest"
    #When Clicked on OracleNS button for next page
    #Then I clicked on dropdown action
    #Then I Select Create Customer action & clicked on next btn
    #When I click on SignIn To Oracle Adaptor
    #Then I filled valid OAuth  Details
    #Then I create filter
    #Then I added adaptor mapping and generate mapping
    #Then I was on response mapping page and clicked on continue button and publish flow
    #Then I goto homepage and search for the flowname "flowtest"
    #Then I will click on  re-auth button to reauthorize it.
    #Then I click on delete icon and deleted flow
    #
     #@Functional
    #Scenario: DIG_018 To create flow without filter and unpublish flow
    #When I enter adminid as "supriya@appliedaiconsulting.com"
    #And I enters pswd as "Aaic@12345"
    #Then I click on login button
    #Then I clcik on Create flow button
    #Then I entered flow name "flowtest"
    #When Clicked on OracleNS button for next page
    #Then I clicked on dropdown action
    #Then I Select Create Customer action & clicked on next btn
    #When I click on SignIn To Oracle Adaptor
    #Then I filled valid OAuth  Details
    #Then I clicked on next button without adding fliter
    #Then I added adaptor mapping and generate mapping
    #Then I was on response mapping page and clicked on continue button and publish flow
    #Then I goto homepage and search for the flowname "flowtest"
    #Then I clicked on publish button to unpublish flow
    #Then I goto homepage and search for the flowname "flowtest"
    #Then I click on delete icon and deleted flow
    #
    #@Functional
    #Scenario: DIG_015 To create flow with response mapping
     #When I enter adminid as "supriya@appliedaiconsulting.com"
    #And I enters pswd as "Aaic@12345"
    #Then I click on login button
    #Then I clcik on Create flow button
    #Then I entered flow name "flowtest"
    #When Clicked on OracleNS button for next page
    #Then I clicked on dropdown action
    #Then I Select Create Customer action & clicked on next btn
    #When I click on SignIn To Oracle Adaptor
    #Then I filled valid OAuth  Details
    #Then I clicked on next button without adding fliter
    #Then I added adaptor mapping and generate mapping
    #Then I added response mapping and created flow
    #Then I goto homepage and search for the flowname "flowtest"
    #Then I click on delete icon and deleted flow
    #
    #@Functional
    #Scenario: DIG_034 To verify re-auth button is not clickable
     #When I enter adminid as "supriya@appliedaiconsulting.com"
    #And I enters pswd as "Aaic@12345"
    #Then I click on login button
    #Then I clcik on Create flow button
    #Then I entered flow name "flowtest"
    #When Clicked on OracleNS button for next page
    #Then I clicked on dropdown action
    #Then I Select Create Customer action & clicked on next btn
    #Then I goto homepage and search for the flowname "flowtest"
    #Then I clicked on re-auth button
    #Then I click on delete icon and deleted flow
    
    #@Functional
    #Scenario: To verify number of rows in a page
    #When I enter adminid as "supriya@appliedaiconsulting.com"
    #And I enters pswd as "Aaic@12345"
    #Then I click on login button
    #Then I will check number of row in page
    
    
    
