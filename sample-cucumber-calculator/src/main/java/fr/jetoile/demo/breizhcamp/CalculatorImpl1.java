package fr.jetoile.demo.breizhcamp;

public class CalculatorImpl1 implements Calculator {

    @Override
    public int plus(int arg1, int arg2) {
        return arg1 + arg2;
    }

    @Override
    public MyNumber plus(MyNumber arg1, MyNumber arg2) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int minus(int arg1, int arg2) {
        return arg1 - arg2;
    }

    @Override
    public MyNumber minus(MyNumber arg1, MyNumber arg2) {
        throw new UnsupportedOperationException();
    }
}
