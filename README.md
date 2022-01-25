# weatherShopper-Testing
- this framework is build using Page Object Model (POM) consists of 5 pages.
- the Five pages are (Homepage, Moisturizer Page, Sunscreens Page, Checkout page and the Payment successful page).
 there are 3 test cases exists on the Frame work
    - First Test Case "TestWeatherShopperEndToEnd" choose the least Moisturizer or Sunscreens based on the Displayed Temperature once the homepage is opened.
    - Second Test Case "TestBuyingLeastMoisturizerWhileTempBelow19" will refresh the page till the required temperature to buy Moisturizer (below 19 degrees) is displayed.
    - Third Test Case "TestBuyingLeastSunscreensWhileTempAbove34" will refresh the page till the required temperature to buy Sunscreens (Above 34 degrees) is displayed.
------------------------------------------------
# Framework classes and their functionality
**ElementActions Class**
- This Class contains all actions we need to interact with any web element existed in the dom and all methods 
are implemented using selenium library with its methods and all contained methods are implemented to be directly
used by the user to create his own test case without any need to know info about selenium before 
Just call the ElmentActions class in your test and use their methods

**BrowserActions Class**
- This Class contains all actions we need to interact with the browser and all methods 
are implemented using selenium library with its methods and all contained methods are implemented to be directly
used by the user to create his own test case without any need to know info about selenium before
Just call the BrowerActions class in your test and use their methods

**DriverHandler**
- This class handles all the initialization we need for any selected web driver (Chrome, Firefox and Edge)

**Paths**
- This class contains all paths we need to read data from it

**Config.properties**
- This File is a config file contains all data you will need to use in your tests

**ConfigUtil**
- This class is used to read our config file "Config.properties"
--------------------------------------------------
# Test Classes and their functionality
**Locators Package**
- This package is considered as a repository of static locators that we have in the system to be used to create any method needed for building our test case
the locators are divided into a separate classes based on their page location

**Strings Package**
- This package is considered as a repository of static strings that we have in the system to be used to create any method needed for building our test case
the locators are divided into a separate classes based on their page location

**Pages Package**
- As we mentioned before the framework follow the POM design pattern so each page we have in the system has its own class and each page class contains its methods
we need to interact with this page

**Test Package**
- This package contains our tests we build End to End to be used in any suite
