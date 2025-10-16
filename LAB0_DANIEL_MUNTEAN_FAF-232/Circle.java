public class Circle implements IShape{
    private double radius;
    private final double pi = 3.14;
    public Circle(double radius) {
        this.radius = radius;
    }
    @Override
    public double area() {
        return pi*radius*radius;
    }
    @Override
    public double perimeter() {
        return 2*pi*radius;
    }
}
