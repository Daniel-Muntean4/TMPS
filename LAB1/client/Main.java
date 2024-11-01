package LAB1.client;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = Calculator.getInstance();

        System.out.println("Welcome to the Calculator!");
        System.out.println("Choose an option:");
        System.out.println("1. Single operation");
        System.out.println("2. Build complex expression");

        int choice = scanner.nextInt();

        if (choice == 1) {
            performSingleOperation(calculator, scanner);
        } else if (choice == 2) {
            buildComplexExpression(calculator, scanner);
        } else {
            System.out.println("Invalid choice!");
        }
        scanner.close();
    }

    private static void performSingleOperation(Calculator calculator, Scanner scanner) {
        System.out.print("Enter first number: ");
        double a = scanner.nextDouble();

        System.out.print("Enter operator (+, -, *, /): ");
        String operator = scanner.next();

        System.out.print("Enter second number: ");
        double b = scanner.nextDouble();

        try {
            double result = calculator.performOperation(a, b, operator);
            System.out.println("Result: " + result);
        } catch (IllegalArgumentException | ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void buildComplexExpression(Calculator calculator, Scanner scanner) {
        ExpressionBuilder expressionBuilder = new ExpressionBuilder();

        System.out.println("Start building your expression.");
        System.out.println("Enter a number followed by an operator (+, -, *, /) or 'end' to calculate:");

        boolean buildingExpression = true;
        boolean isFirst = true;
        while (buildingExpression) {
            System.out.print("Enter number: ");
            double value = scanner.nextDouble();

            if (isFirst) {
                expressionBuilder.add(value);
                isFirst = false;
            } else {
                System.out.print("Enter operator (+, -, *, /): ");
                String operator = scanner.next();

                switch (operator) {
                    case "+" -> expressionBuilder.add(value);
                    case "-" -> expressionBuilder.subtract(value);
                    case "*" -> expressionBuilder.multiply(value);
                    case "/" -> expressionBuilder.divide(value);
                    default -> System.out.println("Invalid operator, try again.");
                }
            }

            System.out.print("Continue with next operator and number (y/n)? ");
            buildingExpression = scanner.next().equalsIgnoreCase("y");
        }

        double result = expressionBuilder.build();
        System.out.println("Result of the complex expression: " + result);
    }
}