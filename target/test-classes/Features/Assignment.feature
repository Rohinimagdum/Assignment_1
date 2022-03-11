@AllTests
Feature: 

Background: open web url 
Given Open URL

@test1
Scenario: User ie able to open URL
When Get Expected URL and Validate
Then Get Title

@test2
Scenario: validating logo size 
When Check Logo Display
Then validate Height and Width of Logo

@test3
Scenario: Application product main category list validation
When Validate Product Category
Then Display categories

@test4
Scenario: Search Product
When Validate while entering the T-Shirt in textbox
#Then Disply T-shirt as a text

@test5
Scenario: Social media application handles
When User click on the footer link
Then Validate the URL opened in new tab contains"seleniumfrmwork"
And Display Twitter account name as"Selenium Framework" 