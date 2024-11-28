# Creational Design Patterns


## Author: Daniel Muntean
## Group: FAF-221



----

## Objectives:

* Get familiar with the Structural DPs;
* As a continuation of the previous laboratory work, think about the functionalities that your system will need to provide to the user.;
* Implement some additional functionalities using structural design patterns;


## Used Design Patterns: 

* Proxy: a structural design pattern that lets you provide a substitute or placeholder for another object. A proxy controls access to the original object, allowing you to perform something either before or after the request gets through to the original object.
* Flyweight: a pattern that lets you fit more objects into the available amount of RAM by sharing common parts of state between multiple objects instead of keeping all of the data in each object.
* Adapter: a pattern that allows objects with incompatible interfaces to collaborate


## Implementation

* Adding thre structural design patterns to the previous laboratory with creational design patterns, the adapter was used to adapt the string input to the function that makes the comlplex operation in our calculator. Then we used a flyweight to create a more performant way of doing complex operations, also having the option of having scientifiic notation. To conclude I used a Proxy for accessing a quadratic equation function in a safe way, that could be in a separate library. Creating a calculator proxy class and a function in main 
  


* This is a an adapter, for the scientific complex expressions using lambda functions. It gets the string inpput and uses the methods for calculating the scientific expressions, from the class ScientificCalculator

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


```
* This is the flyweight interface. It separates the two main methods being execute()(for calculations) and then passing result to scientific notation toScientific()

```


public interface Flyweight {
    double execute(double a, double b);

    default String toScientific(double value) {
        return String.format("%e", value);
    }
}

```
* Calculator proxy with a quadratic equation solver, that would call usually a solveQuadratic() function that is part of a library. In this case it is in a separate class created for the purpose of having a proxy. The calc object of the class ConcreteOpration does the calculations themselves(operation or formulas).
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



## Conclusions / Screenshots / Results
* In conclusion we have new features done with structural patterns, such as having scientific notation, scientific calculator and a quadratic equation solver. Is possible t
o be improved by solving more complex equations.
