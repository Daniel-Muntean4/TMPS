package LAB1.client;

class ExpressionBuilder {
    private double result;
    private boolean isFirstOperation = true;

    public ExpressionBuilder add(double value) {
        if (isFirstOperation) {
            result = value;
            isFirstOperation = false;
        } else {
            result += value;
        }
        return this;
    }

    public ExpressionBuilder subtract(double value) {
        if (isFirstOperation) {
            result = value;
            isFirstOperation = false;
        } else {
            result -= value;
        }
        return this;
    }

    public ExpressionBuilder multiply(double value) {
        if (isFirstOperation) {
            result = value;
            isFirstOperation = false;
        } else {
            result *= value;
        }
        return this;
    }

    public ExpressionBuilder divide(double value) {
        if (isFirstOperation) {
            result = value;
            isFirstOperation = false;
        } else {
            if (value == 0) {
                throw new ArithmeticException("Cannot divide by zero");
            }
            result /= value;
        }
        return this;
    }

    public double build() {
        return result;
    }
}