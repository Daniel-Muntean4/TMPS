package LAB03;
import LAB03.flyweight.AdditionOperation;
import LAB03.flyweight.OperationFactory;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = Calculator.getInstance();

        System.out.println("Welcome to the Calculator!");
        System.out.println("Choose an option:");
        System.out.println("1. Single operation");
        System.out.println("2. Build complex expression");
        System.out.println("3. Scientific complex expression");
        System.out.println("4. Performant Flexible scientific complex expression");
        System.out.println("5. Calculate quadratic equation");
        System.out.println("6. Solve polynomial equation(3rd, 4th, 5th grade)");

        int choice = scanner.nextInt();

        if (choice == 1) {
            performSingleOperation(calculator, scanner);
        } else if (choice == 2) {
            buildComplexExpression(calculator, scanner);
        } else if (choice == 3) {
            scientificComplexExpression(scanner);
        } else if (choice == 4) {
            buildPerformantComplexExpression(scanner);
        }else if (choice == 5) {
            solveQuadratic(calculator, scanner);
        }
        else if (choice == 6) {
            solvePolynomial(calculator, scanner);
        }


        else {
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

        String result = String.valueOf(expressionBuilder.build());
        System.out.println("Result of the complex expression: " + result);
    }
    private static void scientificComplexExpression(Scanner scanner) {
        Calculator calculator = new ScientificCalculatorAdapter();

        System.out.println("Scientific Calculator Mode");
        System.out.println("Supported operations: sin, cos, ^ (power), sqrt");
        boolean continueExpression = true;

        while (continueExpression) {
            System.out.print("Enter first number (or angle for sin/cos): ");
            double a = scanner.nextDouble();

            System.out.print("Enter operator (sin, cos, ^): ");
            String operator = scanner.next();

            double b = 0;
            if (operator.equals("^")) {
                System.out.print("Enter second number (exponent): ");
                b = scanner.nextDouble();
            }

            try {
                double result = calculator.performOperation(a, b, operator);
                System.out.println("Result: " + result);
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }

            System.out.print("Perform another scientific operation? (y/n): ");
            continueExpression = scanner.next().equalsIgnoreCase("y");
        }
    }
    private static void buildPerformantComplexExpression(Scanner scanner) {
        System.out.println("Start building your expression.");
        System.out.println("Enter a number followed by an operator (+, -, *, /) or 'end' to calculate:");

        double result = 0;
        boolean isFirst = true;

        while (true) {
            System.out.print("Enter number: ");
            double value = scanner.nextDouble();

            if (isFirst) {
                result = value;
                isFirst = false;
            } else {
                System.out.print("Enter operator (+, -, *, /): ");
                String operator = scanner.next();

                Operation operation = (Operation) OperationFactory.getOperation(operator);
                result = ((LAB03.flyweight.Flyweight) operation).execute(result, value);
            }

            System.out.print("Continue with next operator and number (y/n)? ");
            if (!scanner.next().equalsIgnoreCase("y")) break;
        }

        System.out.print("Do you want the result in scientific notation? (y/n): ");
        boolean scientific = scanner.next().equalsIgnoreCase("y");

        if (scientific) {
            System.out.println("Result (Scientific): " + new AdditionOperation().toScientific(result));
        } else {
            System.out.println("Result: " + result);
        }
    }

        private static void solveQuadratic(Calculator calculator, Scanner scanner) {
            System.out.print("Enter coefficient a: ");
            double a = scanner.nextDouble();
        System.out.print("Enter coefficient b: ");
        double b = scanner.nextDouble();

        System.out.print("Enter coefficient c: ");
        double c = scanner.nextDouble();

        try {
            double[] roots = calculator.solveQuadratic(a, b, c);
            if (roots.length == 2) {
                System.out.println("Roots: " + roots[0] + " and " + roots[1]);
            } else {
                System.out.println("Root: " + roots[0]);
            }
        } catch (IllegalArgumentException | ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void solvePolynomial(Calculator calculator, Scanner scanner) {
        System.out.println("Choose equation type:");
        System.out.println("1. Cubic equation (ax³ + bx² + cx + d)");
        System.out.println("2. 4th degree equation (ax⁴ + bx³ + cx² + dx + e)");
        System.out.println("3. 5th degree equation (ax⁵ + bx⁴ + cx³ + dx² + ex + f)");

        int choice = scanner.nextInt();
        Equation equation;
        PolynomialSolverVisitor visitor = new PolynomialSolverVisitor();

        switch (choice) {
            case 1 -> {
                System.out.println("Enter coefficients for cubic equation:");
                System.out.print("a: ");
                double a = scanner.nextDouble();
                System.out.print("b: ");
                double b = scanner.nextDouble();
                System.out.print("c: ");
                double c = scanner.nextDouble();
                System.out.print("d: ");
                double d = scanner.nextDouble();

                equation = new CubicEquation(a, b, c, d);
                equation.accept(visitor);
                double[] roots = equation.solve();
                System.out.println("Roots found: " + roots.length);
                for (int i = 0; i < roots.length; i++) {
                    System.out.printf("x%d = %.6f%n", i+1, roots[i]);
                }
            }
            case 2 -> {
                System.out.println("Enter coefficients for 4th degree equation:");
                System.out.print("a: ");
                double a = scanner.nextDouble();
                System.out.print("b: ");
                double b = scanner.nextDouble();
                System.out.print("c: ");
                double c = scanner.nextDouble();
                System.out.print("d: ");
                double d = scanner.nextDouble();
                System.out.print("e: ");
                double e = scanner.nextDouble();

                equation = new PowerFourEquation(a, b, c, d, e);
                equation.accept(visitor);
                double[] roots = equation.solve();
                if (roots.length == 0) {
                    System.out.println("No real roots found.");
                } else {
                    System.out.println("Roots found: " + roots.length);
                    for (int i = 0; i < roots.length; i++) {
                        System.out.printf("x%d = %.6f%n", i+1, roots[i]);
                    }
                }
            }
            case 3 -> {
                System.out.println("Enter coefficients for 5th degree equation:");
                System.out.print("a: ");
                double a = scanner.nextDouble();
                System.out.print("b: ");
                double b = scanner.nextDouble();
                System.out.print("c: ");
                double c = scanner.nextDouble();
                System.out.print("d: ");
                double d = scanner.nextDouble();
                System.out.print("e: ");
                double e = scanner.nextDouble();
                System.out.print("f: ");
                double f = scanner.nextDouble();

                equation = new PowerFiveEquation(a, b, c, d, e, f);
                equation.accept(visitor);
                double[] roots = equation.solve();
                if (roots.length == 0) {
                    System.out.println("No real roots found.");
                } else {
                    System.out.println("Real roots found: " + roots.length);
                    for (int i = 0; i < roots.length; i++) {
                        System.out.printf("x%d = %.6f%n", i+1, roots[i]);
                    }
                }
            }
            default -> System.out.println("Invalid choice!");
        }
    }


}