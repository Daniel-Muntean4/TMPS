package LAB1.client;

// Operation interface
interface Operation {
    double calculate(double a, double b);
}
class Division implements Operation {
    @Override
    public double calculate(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a / b;
    }
}
class Multiplication implements Operation {
    @Override
    public double calculate(double a, double b) {
        return a * b;
    }
}
class Subtraction implements Operation {
    @Override
    public double calculate(double a, double b) {
        return a - b;
    }}
class Addition implements Operation {
        @Override
        public double calculate(double a, double b) {
            return a + b;
        }}
