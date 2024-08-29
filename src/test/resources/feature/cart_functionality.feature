Feature: Cart Functionality
Scenario: Complete Shopping Cart Management on ToneOp Website
  Given the user navigates to the ToneOp website
  When the user clicks on the daily fitness button
  Then the user clicks on add to cart
  When the user clicks on the cart icon
  Then the user should be navigated to the shopping cart page
  When the user increases the product quantity 
  Then the unit price should remain the same
  And the total price should be the unit price multiplied by the quantity
  When the user clicks on the delete button
  Then the Empty cart message should appear
  And the cart should be empty with no products listed
  When the user clicks on the ToneOp icon
  Then the user should be navigated back to the homepage
  When the user clicks on the skincare button
  Then the user should be navigated to the skincare catalog page
  When the user fetches the product name and adds it to the cart
  And the user adds a second product to the cart
  And the user clicks again on the cart icon
  Then the user should see two products in the cart
  And both products should match the previously fetched names
