package LAB03;

public interface Equation {
    void accept(Visitor visitor);
    double[] solve();
}