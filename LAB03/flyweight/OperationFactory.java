package LAB03.flyweight;

import java.util.HashMap;
import java.util.Map;

public class OperationFactory {
    private static final Map<String, Flyweight> operations = new HashMap<>();

    public static Flyweight getOperation(String operator) {
        if (!operations.containsKey(operator)) {
            switch (operator) {
                case "+" -> operations.put(operator, new AdditionOperation());
                case "-" -> operations.put(operator, new SubtractionOperation());
                case "*" -> operations.put(operator, new MultiplicationOperation());
                case "/" -> operations.put(operator, new DivisionOperation());
                default -> throw new IllegalArgumentException("Invalid operator: " + operator);
            }
        }
        return operations.get(operator);
    }
}