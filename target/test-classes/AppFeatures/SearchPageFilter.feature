Feature: E Search Results by Filter

Background: 
        Given User invokes the browser
		And User navigates to the search page

##1
@Smoke
Scenario: Search Filter Validation With Valid Data
When User Inputs Following Valid Year Data In Search Field And Validates
    |From|To  |
    |2021|2021|
    |2022|2022|
    |2011|2012|
And User Close The Browser

##2
@Smoke
Scenario: Search Filter Validation With InValid Data
When User Input Following invalid Data In Search Field And Validates
   |From|To  |
   |2023|2025|
   |1600|1800|
And User Close The Browser

##3
@Smoke @Regression
Scenario: Search Filter Validation With Given Inputs(Specific Data Validation)
When User Inputs Valid Year Data In Search Field And Validates  With Given Data
    |From|To  |
    |2021|2021|
    |2022|2022|   
And User Close The Browser

##4
@Smoke  @Regression
Scenario: Validate The Sorted Dropdown (Descending)
When User Clicks On Dropdown And Selects "newest to oldest" Option 
Then User Should See Oldest Publication "1 April 1898" On Top Of Publication List 
And User Close The Browser

##5
@Smoke  @Regression
Scenario: Validate all Year links
And User Clicks On Links In Year Sections And Validates           
And User Close The Browser 

##6
@Smoke @Regression
Scenario: Search Page Access Verification
When User clicks on Only content I have access to Link
   Then User Should Verify access Content available On Publication List
And  User Clicks On Only Open Access Link
   Then User Should See Open Access On Publication List
And User Close The Browser

##7
@Smoke @Regression @Sanity
Scenario: Search Page Download Button Verification
When User Clicks On Citations Checkbox
Then User Should Able To Download RIS
And User Close The Browser



##
##Scenario Outline: Validate the sorted dropdown(Ascending)
##When User clicks on 'sorted by' dropdown and selects 'newest to oldest' option
##Then User validates the search results in ascending order
##Examples:
# # |||
#  #|||
#

############# Alternate Way For Scenario 5 ###################
##Scenario: Validate all Year link
##When User Clicks On 'Last week' Link
##    Then User Validates Page Is Displayed
##And User Navigates Back
##And User Clicks On 'Last 3 months'
##    Then User Validates Page Is Displayed
##And User Navigates Back
##And User Clicks On 'Last 6 months'
##    Then User Validates Page Is Displayed
##And User Navigates Back
##And User Clicks On 'Last 12 months'
##    Then User Validates Page Is Displayed
##And User Navigates Back
##And User Clicks On 'All dates'
##    Then User Validates Page Is Displayed     
##And User Closed The Browser 
###############################

















