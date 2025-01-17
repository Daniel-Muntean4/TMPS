package LAB03;

public class CalculatorProxy extends Calculator {
    ConcreteCalculator calc = new ConcreteCalculator();

    @Override
    protected Operation createOperation(String operator) {
        return null;
    }

    @Override
    public double performOperation(double a, double b, String operator) {
        return calc.performOperation(a, b, operator);
    }

    @Override
    public double[] solveQuadratic(double a, double b, double c) {
        return calc.solveQuadratic(a, b, c);
    }
}