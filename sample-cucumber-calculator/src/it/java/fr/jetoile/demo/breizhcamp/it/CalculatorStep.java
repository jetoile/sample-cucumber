package fr.jetoile.demo.breizhcamp.it;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import fr.jetoile.demo.breizhcamp.Calculator;
import fr.jetoile.demo.breizhcamp.CalculatorImpl1;
import fr.jetoile.demo.breizhcamp.CalculatorImpl2;
import fr.jetoile.demo.breizhcamp.MyNumber;
import gherkin.formatter.model.DataTableRow;

import java.util.List;

import static org.fest.assertions.Assertions.assertThat;


public class CalculatorStep {

    private Calculator calculator;
    private int result = 0;
    private MyNumber result2 = new MyNumber();

    @Given("^an instance of (CalculatorImpl2|CalculatorImpl1) is used$")
    public void an_instance_of_CaculatorController_is_used(String calculatorInstance) throws Throwable {
        switch (calculatorInstance) {
            case "CalculatorImpl1":
                calculator = new CalculatorImpl1();
                break;
            case "CalculatorImpl2":
                calculator = new CalculatorImpl2();
                break;
        }
    }

    @When("^I add (\\d+) and (\\d+)$")
    public void I_add_and(int arg1, int arg2) throws Throwable {
        if (calculator instanceof CalculatorImpl1)
            result = calculator.plus(arg1, arg2);
        else if (calculator instanceof CalculatorImpl2) {
            MyNumber a1 = new MyNumber();
            a1.setNumber(arg1);
            MyNumber a2 = new MyNumber();
            a2.setNumber(arg2);
            result2 = calculator.plus(a1, a2);
        }
    }

    @When("^I add:$")
    public void I_add(List<MyNumber> numbers) throws Throwable {
        if (calculator instanceof CalculatorImpl1) {
            for (MyNumber number : numbers) {
                result = calculator.plus(result, number.getNumber());
            }
        } else if (calculator instanceof CalculatorImpl2) {
            for (MyNumber number : numbers) {
                MyNumber c = calculator.plus(result2, number);
                result2.setNumber(c.getNumber());
            }
        }
    }

    @When("^I add with data:$")
    public void I_add(DataTable dataTable) throws Throwable {
        List<DataTableRow> rows = dataTable.getGherkinRows();
        int accumulator = 0;
        for (DataTableRow row : rows) {
            List<String> cells = row.getCells();
            accumulator += Integer.valueOf(cells.get(0));
        }

        if (calculator instanceof CalculatorImpl1) {
            result = calculator.plus(result, accumulator);
        } else if (calculator instanceof CalculatorImpl2) {
            MyNumber number = new MyNumber();
            number.setNumber(accumulator);
            MyNumber c = calculator.plus(result2, number);
            result2.setNumber(c.getNumber());
        }
    }

    @Then("^I should obtain (\\d+)$")
    public void I_should_obtain(int arg1) throws Throwable {
        if (calculator instanceof CalculatorImpl1) {
            assertThat(result).isEqualTo(arg1);
        } else if (calculator instanceof CalculatorImpl2) {
            assertThat(result2.getNumber()).isEqualTo(arg1);
        }
    }

}
