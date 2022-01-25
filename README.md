# weatherShopper-Testing
- this framework is build using Page Object Model (POM) consists of 5 pages.
- the Five pages are (Homepage, Moisturizer Page, Sunscreens Page, Checkout page and the Payment successful page).
 there are 3 test cases exists on the Frame work
    - First Test Case "TestWeatherShopperEndToEnd" choose the least Moisturizer or Sunscreens based on the Displayed Temperature once the homepage is opened.
    - Second Test Case "TestBuyingLeastMoisturizerWhileTempBelow19" will refresh the page till the required temperature to buy Moisturizer (below 19 degrees) is displayed.
    - Third Test Case "TestBuyingLeastSunscreensWhileTempAbove34" will refresh the page till the required temperature to buy Sunscreens (Above 34 degrees) is displayed.
---------------------------------------------
# ElementActions Class
- This Class contains all actions we need to interact with any web element existed in the dom and all methods 
are implemented using selenium library with its methods and all contained methods are implemented to be directly
used by the user to create his own test case without any need to know info about selenium before
Just call the ElmentActions class in your test and use their methods
---------------------------------------------
# BrowserActions Class
- This Class contains all actions we need to interact with the browser and all methods 
are implemented using selenium library with its methods and all contained methods are implemented to be directly
used by the user to create his own test case without any need to know info about selenium before
Just call the BrowerActions class in your test and use their methods
---------------------------------------------
# Config.properties
- This File is a config file contains all data you will need to use in your tests
it contains the browser Type you need to run your tests on (Chrome, Firefox or Edge)
