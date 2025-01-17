package LAB03;

public class PolynomialSolverVisitor implements Visitor {
    private double[] result;

    @Override
    public void visitCubic() {
        System.out.println("Solving cubic equation using Cardano's formula...");
    }

    @Override
    public void visitPowerFour() {
        System.out.println("Solving 4th degree equation using Ferrari's method...");
    }

    @Override
    public void visitPowerFive() {
        System.out.println("Solving 5th degree equation using Newton-Raphson method...");
    }

    public double[] getResult() {
        return result;
    }
}