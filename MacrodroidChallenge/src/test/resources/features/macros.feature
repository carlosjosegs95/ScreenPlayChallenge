@Feature1
Feature: MACRODroid app validate
As a mobile user
I want to validate the MACRODroid app functionality  

  Background: Open the MACRODroid main activity
    Given that carlos open the app MACRODroid in his device
  
  @tag1    
  Scenario: Adds macros validate
     When carlos adds five macros
     Then carlos waits for the create confirmation
      
     
  
  
