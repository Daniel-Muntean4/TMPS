package LAB03;

public class PowerFiveEquation implements Equation {
    private final double a, b, c, d, e, f;
    private static final double EPSILON = 1e-10;
    private static final int MAX_ITERATIONS = 100;

    public PowerFiveEquation(double a, double b, double c, double d, double e, double f) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitPowerFive();
    }

    private double evaluateFunction(double x) {
        return a * Math.pow(x, 5) + b * Math.pow(x, 4) + c * Math.pow(x, 3) +
                d * Math.pow(x, 2) + e * x + f;
    }

    private double evaluateDerivative(double x) {
        return 5 * a * Math.pow(x, 4) + 4 * b * Math.pow(x, 3) + 3 * c * Math.pow(x, 2) +
                2 * d * x + e;
    }

    private double newtonRaphson(double initialGuess) {
        double x = initialGuess;
        int iterations = 0;

        while (iterations < MAX_ITERATIONS) {
            double fx = evaluateFunction(x);
            if (Math.abs(fx) < EPSILON) {
                return x;
            }

            double fPrime = evaluateDerivative(x);
            if (Math.abs(fPrime) < EPSILON) {
                return Double.NaN; // Method fails - derivative too close to 0
            }

            double nextX = x - fx / fPrime;
            if (Math.abs(nextX - x) < EPSILON) {
                return nextX;
            }

            x = nextX;
            iterations++;
        }

        return Double.NaN; // Failed to converge
    }

    private boolean isRoot(double x) {
        if (Double.isNaN(x)) return false;
        return Math.abs(evaluateFunction(x)) < EPSILON;
    }

    @Override
    public double[] solve() {
        // Use different initial guesses to find multiple roots
        double[] initialGuesses = {-2.0, -1.0, -0.5, 0.0, 0.5, 1.0, 2.0};
        java.util.Set<Double> rootsSet = new java.util.TreeSet<>();

        for (double guess : initialGuesses) {
            double root = newtonRaphson(guess);
            if (isRoot(root)) {
                // Round to handle floating-point precision issues
                root = Math.round(root * 1e10) / 1e10;
                rootsSet.add(root);
            }
        }

        // Convert set to array
        double[] roots = new double[rootsSet.size()];
        int i = 0;
        for (Double root : rootsSet) {
            roots[i++] = root;
        }

        return roots;
    }
}