# weatherShopper-Testing
- config.properties is the file where you need to fill your data in to be used in the test cases.
- this framework is build using Page Object Model (POM) consists of 5 pages.
- the Five pages are (Homepage, Moisturizer Page, Sunscreens Page, Checkout page and the Payment successful page).
 there are 3 test cases exists on the Frame work
    - First Test Case "TestWeatherShopperEndToEnd" choose the least Moisturizer or Sunscreens based on the Displayed Temperature once the homepage is opened.
    - Second Test Case "TestBuyingLeastMoisturizerWhileTempBelow19" will refresh the page till the required temperature to buy Moisturizer (below 19 degrees) is displayed.
    - Third Test Case "TestBuyingLeastSunscreensWhileTempAbove34" will refresh the page till the required temperature to buy Sunscreens (Above 34 degrees) is displayed.
