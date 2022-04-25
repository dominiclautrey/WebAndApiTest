Feature: Jquery Testing

Background:
Given User is on jquery webpage

Scenario:
When User clicks on the droppable field on the left menu option
Then the user is naviagted to the droppable page
And the user peforms the drag and drop operation
Then the drop here lable changes to Dropped

Scenario:
When User clicks on Selectable option from the left menu
Then user is navigated to the Selectable page
Then User is able to select item1, item3 and item7 from the given item list


Scenario:
When User clicks on the controlgroup option from the left menu
Then user is navigated to the controlgroup page
Then User is able to select the type of cars with insurance of his choice




