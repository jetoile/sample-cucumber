Feature: basic CalculatorImpl1 test

  Scenario Outline: scenario 1
    Given an instance of <impl> is used
    When I add 2 and 2
    Then I should obtain 4
  Examples:
    | impl            |
    | CalculatorImpl1 |
    | CalculatorImpl2 |


  Scenario Outline: scenario 2
    Given an instance of CalculatorImpl1 is used
    When I add <number1> and <number2>
    Then I should obtain <res>
  Examples:
    | number1 | number2 | res |
    | 1       | 1       | 2   |
    | 1       | 2       | 3   |
    | 2       | 2       | 4   |


  Scenario Outline: scenario 3
    Given an instance of CalculatorImpl1 is used
    When I add <number1> and <number2>
    Then I should obtain <res>
  Examples:
    | number1 | number2 | res |
    | 1       | 1       | 2   |
    | 1       | 2       | 3   |
    | 2       | 2       | 4   |


