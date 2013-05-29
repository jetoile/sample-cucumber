package fr.jetoile.demo.breizhcamp;

import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class CalculatorImpl2Test {
    private Calculator calculator;
    private MyNumber arg1;
    private MyNumber arg2;

    @Before
    public void setup() {
        calculator = new CalculatorImpl2();
        arg1 = new MyNumber();
        arg2 = new MyNumber();
    }

    @Test
    public void simple_plus_should_success() throws Exception {
        //Given
        arg1.setNumber(1);
        arg2.setNumber(2);

        //When
        MyNumber result = calculator.plus(arg1, arg2);

        //Then
        assertThat(result.getNumber() == 3);

    }

    @Test
    public void plus_should_be_cumutative() throws Exception {
        //Given
        arg1.setNumber(1);
        arg2.setNumber(2);

        //When
        MyNumber result = calculator.plus(arg1, arg2);
        MyNumber result2 = calculator.plus(arg1, arg1);

        //Then
        assertThat(result.getNumber() == result2.getNumber());

    }

//    @Test
    public void simple_minus_should_sucess() throws Exception {
        //Given

        //When
        int result = calculator.minus(1, 2);
//        int result2 = calculator.plus(3, 2);

        //Then
        assertThat(result == -1);
    }

//    @Test
    public void minus_should_not_be_cumutative() throws Exception {
        //Given

        //When
        int result = calculator.minus(1, 2);
        int result2 = calculator.minus(2, 1);

        //Then
        assertThat(result != result2);
    }
}
