# Topic: *Creational Design Patterns*
## Author: *Daniel Muntean* *FAF 232*
------
## Objectives:
__1. Study and understand the SOLID principles .__

## Some Theory:
The SOLID principles are five essential guidelines that enhance software design, making code more maintainable and scalable. They include Single Responsibility, Open/Closed, Liskov Substitution, Interface Segregation, and Dependency Inversion.  
__1. Single Responsability:__ A class should have one and only one reason to change, meaning that a class should have only one job.  
__2. Open-closed:__ Each object or entity should be open for extension but closed for modification.  
__3. Liskov-Substitution:__ The derived class should be able to be substituted by it's base class.  
__4. Interface segregation:__ each interface should do only one thing, because the client should not implement methods it does not use. And each client should not implement interfaces that are not used.  
__5. Dependency inversion:__ High level modules should not depend on lower level modules, but should depend on abstrations.


## Solid Principles implemented
Single responsability, Liskov-Substitution and Interface Segregation

## Main tasks:
__1. Choose an OO programming language and a suitable IDE or Editor (No frameworks/libs/engines allowed).__

__2. Select a domain area for the sample project.__

__3. Define the main involved classes and think about what instantiation mechanisms are needed.__

## Snippets
```
public interface IShape {
    public double area();
    public double perimeter();
}
```
This is our shape interface, we will implement it for several shapes. In this program there are 4 shapes: circle, square, rectangle andn triangle
```
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

```
Above there is an example of the shape implementation with the circle class, this program has a different implementation of each shape according to the mathematical formulas. This program allows many other shapes to be added, so it could be said it is *open for extension*, but *closed for modification*, but we have also TextUI class that should change it's code so it is not fully Open/Closed, so we can't consider it as implemented in this project.
```
import java.util.Scanner;
public class Main{
public static void main(String [] args){
    Scanner scanner = new Scanner(System.in);
    TextUI textUI = new TextUI(scanner);
    textUI.start();
}
}
```
Above we have the main class. In this program each class has a single job, which is to compute the area and perimeter of the shape. And in the case of the TEXT UI is to create the user interface logic, the Main function is the responsible to get the input and to initialize the textUI and scanner objects, which gives the posibility to have input from multiple sources based on the posibilities of the Scanner class imported in java. We have a solid evidence that the __Single responsibility principle__ is fully accomplished.
```
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
```
Above we have the example for the Liskov substitiution principle from the TextUI class. The implementation of the interface is in accord with the promised behavior. Which in our case is to calculate the area and perimeter.
```
public interface IDrawShape {
    public void draw();
}
public class DrawSquare implements IDrawShape{
    private Square square;
    public DrawSquare(Square square) {
        this.square=square;
    }
    @Override
    public void draw() {
        for (int i = 0; i < square.getSize(); i++) {
            System.out.println();
            for (int j = 0; j < square.getSize(); j++) {
                System.out.print("* ");
            }
        }
    }
}
```
Lastly our project has the **Interface Segregation Principle** accomplished, the drawer and mathematical interfaces are separated and the drawer and mathematical shapes classes are the ones that implement it, in this project there are shapes that do not have yet the possibility for being drawn (Triangle and Circle), but it is something that could be added in the future. The ISP is shown also in the fact that here are not classes that implement an interface or that overrides a method that it does not use.  

## Implementation
This program allows a user to calculate perimeter and area for Triangles, Rectangles, Squares and Circles in any metrical unit, at the same time it has a drawer interface and the implementation for Rectangles and Squares. It can be extended with more implemented shapes and those shapes could have implementations of the IDrawShape class added, the OCP is almost fulfilled but adding the new shapes would require changes in the TextUI class. The fully implemented principles are: Single Responsibility, Liskov-Substitution and Interface segregation


