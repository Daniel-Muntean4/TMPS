package LAB03;

class ScientificCalculatorAdapter extends Calculator {
    private final ScientificCalculator scientificCalculator = new ScientificCalculator();

    @Override
    protected Operation createOperation(String operator) {
        return switch (operator) {
            case "sin" -> (a, b) -> scientificCalculator.calculateSin(a);
            case "cos" -> (a, b) -> scientificCalculator.calculateCos(a);
            case "^" -> (a,b) -> scientificCalculator.calculatePower(a, b);
            case "sqrt" -> (a, b) -> scientificCalculator.calculateRoot(a);
            default -> null;
        };
    }

    @Override
    public double[] solveQuadratic(double a, double b, double c) {
        return new double[0];
    }
}
