package LAB03;

public class CubicEquation implements Equation {
    private double a, b, c, d;

    public CubicEquation(double a, double b, double c, double d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitCubic();
    }

    @Override
    public double[] solve() {
        // First, reduce to standard form (x³ + px + q = 0)
        double p = (3 * a * c - b * b) / (3 * a * a);
        double q = (2 * b * b * b - 9 * a * b * c + 27 * a * a * d) / (27 * a * a * a);

        double D = Math.pow(q/2, 2) + Math.pow(p/3, 3);

        if (D > 0) {
            double u = Math.cbrt(-q/2 + Math.sqrt(D));
            double v = Math.cbrt(-q/2 - Math.sqrt(D));

            double root1 = u + v - b/(3*a);
            double realPart = -(u + v)/2 - b/(3*a);
            double imaginaryPart = Math.sqrt(3)*(u - v)/2;

            return new double[]{root1};
        }
        else if (D == 0) {
            // Three real roots, at least two are equal
            double u = Math.cbrt(-q/2);
            double root1 = 2*u - b/(3*a);
            double root2 = -u - b/(3*a);

            return new double[]{root1, root2};
        }
        else {
            // Three distinct real roots
            double phi = Math.acos(-q/(2*Math.sqrt(-Math.pow(p/3, 3))));
            double sqrt_p_3 = 2 * Math.sqrt(-p/3);

            double root1 = sqrt_p_3 * Math.cos(phi/3) - b/(3*a);
            double root2 = sqrt_p_3 * Math.cos((phi + 2*Math.PI)/3) - b/(3*a);
            double root3 = sqrt_p_3 * Math.cos((phi + 4*Math.PI)/3) - b/(3*a);

            return new double[]{root1, root2, root3};
        }
    }

    public double getA() { return a; }
    public double getB() { return b; }
    public double getC() { return c; }
    public double getD() { return d; }
}