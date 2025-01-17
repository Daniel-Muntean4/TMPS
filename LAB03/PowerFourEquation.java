package LAB03;

public class PowerFourEquation implements Equation {
    private double a, b, c, d, e;

    public PowerFourEquation(double a, double b, double c, double d, double e) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitPowerFour();
    }

    @Override
    public double[] solve() {
        // Ferrari's method for quartic equations
        // First, normalize the equation (make coefficient of x⁴ equal to 1)
        double p = b/a;
        double q = c/a;
        double r = d/a;
        double s = e/a;

        // Calculate coefficients of resolvent cubic equation
        double f = q - 3*p*p/8;
        double g = r + p*p*p/8 - p*q/2;
        double h = s - 3*p*p*p*p/256 + p*p*q/16 - p*r/4;

        // Solve resolvent cubic equation
        CubicEquation resolvent = new CubicEquation(1, f/2, (f*f - 4*h)/16, -g*g/64);
        double[] resRoots = resolvent.solve();
        double y = resRoots[0]; // Take the first real root

        // Calculate coefficients for quadratic factors
        double R = Math.sqrt(p*p/4 - q + 2*y);
        if (Double.isNaN(R)) {
            return new double[]{}; // No real roots
        }

        double D = Math.sqrt(y*y - h);
        double E = y + D;
        double F = y - D;

        // Solve two quadratic equations
        double[] roots = new double[4];
        int count = 0;

        // First quadratic: x² + (p/2 + R)x + E = 0
        double discriminant1 = (p/2 + R)*(p/2 + R) - 4*E;
        if (discriminant1 >= 0) {
            roots[count++] = (-p/2 - R + Math.sqrt(discriminant1))/2;
            roots[count++] = (-p/2 - R - Math.sqrt(discriminant1))/2;
        }

        // Second quadratic: x² + (p/2 - R)x + F = 0
        double discriminant2 = (p/2 - R)*(p/2 - R) - 4*F;
        if (discriminant2 >= 0) {
            roots[count++] = (-p/2 + R + Math.sqrt(discriminant2))/2;
            roots[count++] = (-p/2 + R - Math.sqrt(discriminant2))/2;
        }

        // Return only the found real roots
        double[] realRoots = new double[count];
        System.arraycopy(roots, 0, realRoots, 0, count);
        return realRoots;
    }
}