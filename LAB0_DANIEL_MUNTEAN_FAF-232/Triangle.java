public class Triangle implements IShape {
    private double a;
    private double b;
    private double c;
    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    @Override
    public double area() {
        double semiperimeter= (a+b+c)/2;
        return  Math.sqrt(semiperimeter*(semiperimeter-a)*(semiperimeter-b)*(semiperimeter-c));
    }
    @Override
    public double perimeter() {
        return a+b+c;
    }
    

    public double getA() {
        return a;
    }
    public double getB() {
        return b;
    }public double getC() {
        return c;
    }
  

}
