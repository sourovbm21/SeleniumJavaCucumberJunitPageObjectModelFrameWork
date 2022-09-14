Feature: E Search Year Filter Validation

Background: 
        Given User invokes the browser
		And User navigates to the search page

@Regression
Scenario Outline: Search Filter Validation With Valid Data
When User Inputs Valid Year "<From>" To "<To>" In The Textbox
And User Clicks On Go Button
And User Navigates To Search Page
Then User Validates Search Data
And User Close The Browser
Examples: 
           |From|To  |
           |2000|2005|
           |2006|2010|
           |2017|2022|
           |    |2000|
           |2000|    |
 
 @Regression
Scenario Outline: Search Filter Validation with invalid data
When Use inputs invalid year "<From>" to "<To>" in the textbox 
And User Clicks On Go Button
And User Navigates To Search Page
Then User Should see "No Search results" Message
And User Close The Browser
Examples: 
               |From|To  |
               |2023|2024|
               |1250|1600|
  
 