package LAB1.client;

abstract class Calculator {
    protected abstract Operation createOperation(String operator);

    public double performOperation(double a, double b, String operator) {
        Operation operation = createOperation(operator);
        if (operation == null) {
            throw new IllegalArgumentException("Invalid operator: " + operator);
        }
        return operation.calculate(a, b);
    }

    private static Calculator instance;

    public static Calculator getInstance() {
        if (instance == null) {
            instance = new ConcreteCalculator();
        }
        return instance;
    }
}