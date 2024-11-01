package LAB1.client;

public class ConcreteCalculator extends Calculator {
    @Override
    protected Operation createOperation(String operator) {
        return switch (operator) {
            case "+" -> new Addition();
            case "-" -> new Subtraction();
            case "*" -> new Multiplication();
            case "/" -> new Division();
            default -> null;
        };
    }
}