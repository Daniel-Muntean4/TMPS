public class Rectangle implements IShape {
    
    private double width;
    private double length;
    
    public Rectangle(double  width, double  length) {
        this.width = width;
        this.length = length;

    }

    @Override
    public double area() {
        return width*length;
        
    }

    @Override
    public double perimeter() {
        return width*2+length*2;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }
    
    
}
