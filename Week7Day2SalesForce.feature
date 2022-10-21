Feature: Salesforce Cucumber Assignment 

# TC001_Create New Oppurtunity

@Regression 
Scenario Outline: 
#	Given Launch the chrome browser 
#	And Load the URL and maximize 
#	When Enter Username as 'ramkumar.ramaiah@testleaf.com' 
#	And Enter Password as 'Password#123' 
#	And Click on Login 
#	And Click on Global Actions SVG icon
#	And Click View All
	And Click Sales 
	And Click on Opportunity tab 
	And Click on New button 
	And Enter account name as <accountName> 
	And Choose close date 
	And Click stage as Need Analysis 
	And Click save button 
	Then Verify Oppurtunity Name 
	
	Examples: 
		|accountName|
		|'Salesforce Automation by QA'|
	
##TC002_Create Oppurtunity Without Mandatory Fields

@Functional @Smoke @Sanity
Scenario Outline: 
#	Given Launch the chrome browser 
#	And Load the URL and maximize 
#	When Enter Username as 'ramkumar.ramaiah@testleaf.com' 
#	And Enter Password as 'Password#123' 
#	And Click on Login 
#	And Click on Global Actions SVG icon
#	And Click View All
	And Click Sales 
	And Click on Opportunity tab
	And Click on New button
	And Send close date as <closeDate>
	And Click save button 
	Then Verify the Alert message displayed for Name and Stage
	
	Examples: 
		|closeDate|
		|'10/17/2022'|	
	
#TC003_Create New Dashboard

@Sanity @Smoke
Scenario Outline: 
#	Given Launch the chrome browser 
#	And Load the URL and maximize 
#	When Enter Username as 'ramkumar.ramaiah@testleaf.com' 
#	And Enter Password as 'Password#123' 
#	And Click on Login 
#	And Click on Global Actions SVG icon
#	And Click View All
	And Click on Dashboards
	And Click on the new dashboard
	And Enter name as <nameValue>
	And click Create
	Then Verify the Dashboard name
	
	Examples:
	|nameValue|
	|'Salesforce Automation by Anu'|
	
#TC004_Create Individuals
@Regression
Scenario Outline: 
#	Given Launch the chrome browser 
#	And Load the URL and maximize 
#	When Enter Username as 'ramkumar.ramaiah@testleaf.com' 
#	And Enter Password as 'Password#123' 
#	And Click on Login 
#	And Click on Global Actions SVG icon
#	And Click View All
	And Click Individuals from App Launcher
	And Click on the Dropdown icon in the Individuals tab
	And Enter Salutation as Mr
	And Enter LastName as <lastName>
	And Click Save
	Then Verify individuals
	
		Examples:
	|	lastName|
	|	'Prakash'|
	
#TC005_Create Accounts
@Smoke @Sanity
Scenario Outline: 
	And Click Sales 
	And Click on Accounts tab 
	And Click on New button
	And Enter Account name as <yourName>
	And Select Ownership as Public  
	And Click save button
	Then Verify Account name 
	
	Examples: 
		|	yourName|
		|	'Anu'|