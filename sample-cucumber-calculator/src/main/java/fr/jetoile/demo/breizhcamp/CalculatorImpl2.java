package fr.jetoile.demo.breizhcamp;

public class CalculatorImpl2 implements Calculator {

    @Override
    public int plus(int arg1, int arg2) {
        throw new UnsupportedOperationException();
    }

    @Override
    public MyNumber plus(MyNumber arg1, MyNumber arg2) {
        int res = arg1.getNumber() + arg2.getNumber();
        MyNumber result = new MyNumber();
        result.setNumber(res);
        return result;
    }

    @Override
    public int minus(int arg1, int arg2) {
        throw new UnsupportedOperationException();
    }

    @Override
    public MyNumber minus(MyNumber arg1, MyNumber arg2) {
        int res = arg1.getNumber() - arg2.getNumber();
        MyNumber result = new MyNumber();
        result.setNumber(res);
        return result;
    }
}
