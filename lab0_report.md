# Topic: *Creational Design Patterns*
## Author: *Daniel Muntean* *FAF 232*
------
## Objectives:
__1. Study and understand the SOLID principles .__

## Some Theory:
The SOLID principles are five essential guidelines that enhance software design, making code more maintainable and scalable. They include Single Responsibility, Open/Closed, Liskov Substitution, Interface Segregation, and Dependency Inversion. 
Single Responsability: A class should have one and only one reason to change, meaning that a class should have only one job.
Open-closed: Each object or entity should be open for extension but closed for modification.
Liskov-Substitution: The derived class should be able to be substituted by it's base class
Interface segregation: each interface should do only one thing, because the client should not implement methods it does not use. And each client should not implement interfaces that are not used.
Dependency inversion: High level modules should not depend on lower level modules, but should depend on abstrations


## Solid Principles implemented
Single responsability, Open-closed and Liskov-Substitution 

## Main tasks:
__1. Choose an OO programming language and a suitable IDE or Editor (No frameworks/libs/engines allowed).__

__2. Select a domain area for the sample project.__

__3. Define the main involved classes and think about what instantiation mechanisms are needed.__

## Snippets
```
public interface Shape {
    public double area();
    public double perimeter();
}
```
This is our shape interface, we will implement it for several shapes. In this program there are 4 shapes: circle, square, rectangle andn triangle
```
public class Circle implements Shape{
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
Above there is an example of the shape implementation with the circle class, this program has a different implementation of each shape according to the mathematical formulas. This program allows many other shapes to be added, so it is *open for extension*, but *closed for modification*(If we wanted to make a graphical interface we would create a geometrical circle class, without altering the functionality of the current class) 
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
Above we have the main class. In this program each class has a single job, which is to compute the area and perimeter of the shape. And in the case of the TEXT UI is to create the user interface logic, the Main function is the responsible to get the input and to initialize the textUI and scanner objects, which gives the posibility to have input from multiple sources based on the posibilities of the Scanner class imported in java. 
```
Shape shape;
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
            }
```
Above we have the example for the Liskov substitiution principle from the TextUI class. The implementation of the interface is in accord with the promised behavior. Which in our case is to calculate the area and perimeter.


## Implementation
This program simulates a classroom interaction using OOP principles like encapsulation, inheritance, and polymorphism. By designing flexible components like InputManager, Teacher, and Student, the code allows easy extension, such as adding new teacher types (e.g., FunnyTeacher or StrictTeacher) or modifying student behaviors.

The program emphasizes dependency injection, making it testable and maintainable. It also uses casting (CoolTeacher) and conditional logic to ensure that specialized behavior (like telling jokes) is only executed when appropriate. 


