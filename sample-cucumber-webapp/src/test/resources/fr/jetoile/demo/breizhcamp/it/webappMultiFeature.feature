Feature: multi CalculatorImpl1 test

  Scenario Outline: scenario 1
    Given I use browser firefox
    And an instance of <impl> is used for multi
    When I add 2 and 2 for multi
    Then I should obtain 4 for multi
  Examples:
    | impl            |
    | CalculatorImpl1 |
    | CalculatorImpl2 |


  Scenario Outline: scenario 2
    Given I use browser <browser> with <parameters>
    And an instance of CalculatorImpl1 is used for multi
    When I add 3 and 5 for multi
    Then I should obtain 8 for multi
  Examples:
    | browser | parameters                                             |
    | firefox |                                                        |
    | chrome  | webdriver.chrome.driver@/opt/chromedriver/chromedriver |


  Scenario Outline: scenario 3
    Given I use browser <browser> with <parameters>
    Given an instance of CalculatorImpl2 is used for multi
    When I add 3 and 3 for multi
    Then I should obtain 6 for multi
  Examples:
    | browser   | parameters                                                            |
    | firefox   |                                                                       |
    | chrome    | webdriver.chrome.driver@/opt/chromedriver/chromedriver                |
#    | phantomjs | phantomjs.binary.path@/opt/phantomjs-1.9.0-linux-x86_64/bin/phantomjs |


