# Creational Design Patterns


## Author: Vasile Drumea

----

## Objectives:

* Get familiar with the Structural DPs;
* Choose a specific domain;
* Implement at least 3 CDPs for the specific domain;


## Used Design Patterns: 

* Proxy
* Flyweight: a structural design pattern that lets you fit more objects into the available amount of RAM by sharing common parts of state between multiple objects instead of keeping all of the data in each object.
* Adapter


## Implementation

* Adding thre structural design patterns to the previous laboratory with creational design patterns, the adapter was used to adapt the string input to the function that makes the comlplex operation in our calculator. Then we used a flyweight to create a more performant way of doing complex operations, also having the option of having scientifiic notation. To conclude I used a Proxy for accessing a quadratic equation function in a safe way, that could be in a separate library. Creating a calculator proxy class and a function in main 
  


* This is a an adapter, for the scientific complex expressions using lambda functions.

```

    @Override
    protected Operation createOperation(String operator) {
        return switch (operator) {
            case "sin" -> (a, b) -> scientificCalculator.calculateSin(a);
            case "cos" -> (a, b) -> scientificCalculator.calculateCos(a);
            case "^" -> (a,b) -> scientificCalculator.calculatePower(a, b);
            case "sqrt" -> (a, b) -> scientificCalculator.calculateRoot(a);
            default -> null;
        };
    }
public interface Flyweight {
    double execute(double a, double b);

    default String toScientific(double value) {
        return String.format("%e", value);
    }
}

```
```


public interface Flyweight {
    double execute(double a, double b);

    default String toScientific(double value) {
        return String.format("%e", value);
    }
}

```
* This is the flyweight interface.
 ```



public class CalculatorProxy extends Calculator {
    ConcreteCalculator calc = new ConcreteCalculator();

    @Override
    protected Operation createOperation(String operator) {
        return null;
    }

    @Override
    public double performOperation(double a, double b, String operator) {
        return calc.performOperation(a, b, operator);
    }

    @Override
    public double[] solveQuadratic(double a, double b, double c) {
        return calc.solveQuadratic(a, b, c);
    }
}

```
* Calculator proxy with a quadratic equation solver


## Conclusions / Screenshots / Results
