##DIG Test Automation 
Contains cucumber features based UI automation for Docuphase application.

__A walk through the folder structure__

1. features folder is the place where all the test case descriptions are kept in Given-When-Then(GWT) format.
2. These scenarios link to step_definitions folder(com.java.cukes.StepDefinitions.java) where 1-1 mapping is present for each GWT in scenario folder
3. Reports folder is an empty folder where the reports are created after execution
4. Cukes folder has the framework and is the most important and __Handle with care__ folder
5. hooks contains the initializations of all browsers, the setup and teardown for tests, these decide and call appropriate browser launch and kill and also take screenshots, again modifying this might break browser launch or screenshot functionality.
6. utilities contain the most utility method widely used in the project, you can add/remove mehtods as per your project
7. CukesRunnerTest used for running features under feature folder

## Requirements 

1. __Code__
  * DIG_UIAutomation code
2. __Programming Language__
  * Java_version_13
3. __Plugins__
  * Cucumber framework plugin
4. __JARs__
  * selenium jar
  * Junit jar 
5. __Browsers__
  * Google Chrome
  * Mozilla Firefox

## Execution 

__Commmands__ 
Before running the command, export following environment variables
* export BROWSER=Chrome
* export TEST_URL='https://dev.docuphase-erp.com/'
* __mvn test__ : This will execute all scenarios from all features using terminal

# Reporting :eyes:
Testdrive automation reports are created in following 2 types of format

1. __HTML__ : index.html
2. __JSON__ : index.json

Reports are created inside the target/reports directory with above mentioned filenames

## How to set it up in Eclipse and Run
- Import the project as Existing Maven Project. 
- Create a Run Configuration with goal as `test`, make sure to define the environment variable. 
- You are set, run this. 
