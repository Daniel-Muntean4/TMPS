import java.util.Scanner;

public class TextUI{
    private Scanner scanner;

    public TextUI(Scanner scanner) {
        this.scanner=scanner;
    }

    public void start(){
        while (true) { 
            System.out.println("Write a shape to calculate area and perimeter");
            System.out.println("1-Circle\n2-Square\n3-Rectangle\n4-Triangle");
            String shapeName=scanner.nextLine().toLowerCase();
            System.out.println("What measuring unit(m/cm/mm)?");
            String unit = scanner.nextLine();
            IShape shape;
            if(shapeName.equals("circle")){
                System.out.println("Introduce the radius("+unit+"): ");
                double radius = Double.valueOf(scanner.next());
                shape = new Circle(radius);
                System.out.print("The area of the "+shapeName+ "is: "+shape.area()+unit+"^2, the perimeter is: "+shape.perimeter()+unit);

            }
            else if(shapeName.equals("square")){
                System.out.println("Introduce the size("+unit+"): ");
                double size = Double.valueOf(scanner.next());
                shape = new Square(size);
                System.out.print("The area of the "+shapeName+ "is: "+shape.area()+unit+"^2, the perimeter is: "+shape.perimeter()+unit);
                System.out.println();
                DrawSquare drawSquare = new DrawSquare(new Square(size));
                drawSquare.draw();
            }
            else if(shapeName.equals("rectangle")){
                System.out.println("Introduce the width("+unit+"): ");
                double width = Double.valueOf(scanner.next());
                System.out.println("Introduce the length: ");
                double length = Double.valueOf(scanner.next());
                shape = new Rectangle(width,length);
                System.out.print("The area of the "+shapeName+ "is: "+shape.area()+unit+"^2, the perimeter is: "+shape.perimeter()+unit);
                System.out.println();
                DrawRectangle drawrectangle = new DrawRectangle(new Rectangle(width,length));
                drawrectangle.draw();

            }
            else if(shapeName.equals("triangle")){
                System.out.println("Introduce the first side("+unit+"): ");
                double a = Double.valueOf(scanner.next());
                System.out.println("Introduce the second side("+unit+"): ");
                double b = Double.valueOf(scanner.next());
                System.out.println("Introduce the third side("+unit+"): ");
                double c = Double.valueOf(scanner.next());
                shape = new Triangle(a, b, c);
                System.out.print("The area of the "+shapeName+ "is: "+shape.area()+unit+"^2, the perimeter is: "+shape.perimeter()+unit);
            }
            System.out.println();
            System.out.println("Do you have another shape (press 1 for yes/press 0 for exit)");
            int input = Integer.valueOf(scanner.next());
            if(input==0){
                break;
            }
                    
            }
        }
    }
