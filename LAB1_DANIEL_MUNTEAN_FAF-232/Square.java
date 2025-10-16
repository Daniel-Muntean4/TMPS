public class Square implements IShape {

    private double size;

    public Square(double size) {
        this.size = size;
    }

    @Override
    public double area() {
        return size*size;
    }

    @Override
    public double perimeter() {
        return size*4;
    }

    public double getSize() {
        return size;
    }
    

    
    
}

