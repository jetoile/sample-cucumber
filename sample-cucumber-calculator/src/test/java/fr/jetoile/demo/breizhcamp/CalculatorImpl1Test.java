package fr.jetoile.demo.breizhcamp;

import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class CalculatorImpl1Test {
    private Calculator calculator;

    @Before
    public void setup() {
        calculator = new CalculatorImpl1();
    }

    @Test
    public void simple_plus_should_success() throws Exception {
        //Given

        //When
        int result = calculator.plus(1, 2);

        //Then
        assertThat(result == 3);

    }

    @Test
    public void plus_should_be_cumutative() throws Exception {
        //Given

        //When
        int result = calculator.plus(1, 2);
        int result2 = calculator.plus(3, 2);

        //Then
        assertThat(result == result2);

    }

    @Test
    public void simple_minus_should_sucess() throws Exception {
        //Given

        //When
        int result = calculator.minus(1, 2);

        //Then
        assertThat(result == -1);
    }

    @Test
    public void minus_should_not_be_cumutative() throws Exception {
        //Given

        //When
        int result = calculator.minus(1, 2);
        int result2 = calculator.minus(2, 1);

        //Then
        assertThat(result != result2);
    }
}
