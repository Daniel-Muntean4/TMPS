# Topic: *Creational Design Patterns*
## Author: *Daniel Muntean* *FAF 221*
------
## Objectives:
__1. Study and understand the SOLID principles .__

## Some Theory:
The SOLID principles are five essential guidelines that enhance software design, making code more maintainable and scalable. They include Single Responsibility, Open/Closed, Liskov Substitution, Interface Segregation, and Dependency Inversion. 

## Solid Principles implemented
Single responsability, Open-closed and Interface segregation 

## Main tasks:
__1. Choose an OO programming language and a suitable IDE or Editor (No frameworks/libs/engines allowed).__

__2. Select a domain area for the sample project.__

__3. Define the main involved classes and think about what instantiation mechanisms are needed.__

## Snippets
```
public interface IReplyQuestion
{
    String replyQuestion();
}
public interface IAskQuestions {
    String askQuestion();
}
```
Here we can see how each interface is responsible for one particular thing without mixing functionalities
```
public class Teacher implements ITeach, IAskQuestions, IReplyQuestion {
    @Override
    public String askQuestion() {
        return "a";
    }
    @Override
    public String replyQuestion() {
        return "*Replies to students questions*";
    }

    @Override
    public void teach(String lesson) {
        System.out.println("Teaching the lesson nr. " + lesson);

    }
}
```
The teacher implements the interfaces and it has the open/closed principle because it is closed for modification open for adding more functionality. Like the next class
```
class CoolTeacher extends Teacher {
    public void tellJoke() {
        System.out.println("*Tells a joke that students like*");
    }
}
```
The cool teacher extends the normal, adding the new functionality, without violating any of the SOLID principles. Also it allows more modifications in the future.


## Implementation
This program simulates a classroom interaction using OOP principles like encapsulation, inheritance, and polymorphism. By designing flexible components like InputManager, Teacher, and Student, the code allows easy extension, such as adding new teacher types (e.g., FunnyTeacher or StrictTeacher) or modifying student behaviors.

The program emphasizes dependency injection, making it testable and maintainable. It also uses casting (CoolTeacher) and conditional logic to ensure that specialized behavior (like telling jokes) is only executed when appropriate. 


