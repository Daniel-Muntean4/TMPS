package LAB2.flyweight;

public class DivisionOperation implements Flyweight {
    @Override
    public double execute(double a, double b) {
        if (b == 0) throw new ArithmeticException("Division by zero");
        return a / b;
    }
}
