Feature: Addskills

  Scenario Outline: Add skills with description
    Given User launch chrome browser
    When User opens URL "https://opensource-demo.orangehrmlive.com/index.php/auth/login"
    And User enters username as "Admin" and password as "admin123"
    And Click on login button
    Then Page URL Should be "https://opensource-demo.orangehrmlive.com/index.php/dashboard"
    Then Go to Skill Page
    When Add skills with "<skillname>" and "<skilldesc>"
    Then Click on Save button
    Then Click on logout button
    Then Close Browser

    Examples: 
      | skillname | skilldesc                 |
      | Appium    | Mobile Automation Testing |
      | Java      | Core Java                 |
      | Selenium  | web Automation Testing    |

  Scenario: Add skills with description
    Given User launch chrome browser
    When User opens URL "https://opensource-demo.orangehrmlive.com/index.php/auth/login"
    And User enters username as "Admin" and password as "admin123"
    And Click on login button
    Then Page URL Should be "https://opensource-demo.orangehrmlive.com/index.php/dashboard"
    Then Go to Skill Page
    Then Select "selenium" record to delete 
    Then Click on Delete button to delete selected record
