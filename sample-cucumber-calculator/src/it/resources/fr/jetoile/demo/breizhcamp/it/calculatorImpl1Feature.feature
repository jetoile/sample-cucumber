Feature: basic CalculatorImpl1 test

  @wip
  Scenario: scenario 1
    Given an instance of CalculatorImpl1 is used
    When I add 1 and 2
    Then I should obtain 3

  @wip
  Scenario: scenario 2
    Given an instance of CalculatorImpl1 is used
    When I add:
      | number |
      | 1      |
      | 2      |
      | 1      |
    Then I should obtain 4

  Scenario: scenario 3
    Given an instance of CalculatorImpl1 is used
    When I add with data:
      | 1 |
      | 3 |
      | 1 |
    Then I should obtain 5

  Scenario Outline: scenario 4
    Given an instance of CalculatorImpl1 is used
    When I add <number1> and <number2>
    Then I should obtain <res>
  Examples:
    | number1 | number2 | res |
    | 1       | 1       | 2   |
    | 1       | 2       | 3   |
    | 2       | 2       | 4   |


