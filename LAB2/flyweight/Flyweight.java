package LAB2.flyweight;

public interface Flyweight {
    double execute(double a, double b);

    default String toScientific(double value) {
        return String.format("%e", value);
    }
}

