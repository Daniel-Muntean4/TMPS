# Creational Design Patterns


## Author: Daniel Muntean
## Group: FAF-221



----

## Objectives:

* Study and understand the Behavioural Design Patterns;
* As a continuation of the previous laboratory work, think about the functionalities that your system will need to provide to the user..;
* Implement some additional functionalities using behavioral design patterns.;


## Used Design Patterns: 

* VISITOR: a behavioral design pattern that lets you define a new operation without changing classes of the element on which operates. 


## Implementation

* Adding the visitor pattern allowed the calculator I'm creating to have 5th, 4th and 3rd degree equations. They are different ways of interpreting the input.
* Third degree uses Cardano's formula, quartic equations use Ferrari's returning real roots onlyand for 5ht degree uses the Newton-Raphson method for numerical approximation.


* This is the visitor interface

```
    public interface Visitor {
    void visitCubic();
    void visitPowerFour();
    void visitPowerFive();
}

```
* This is the polynomial solver concrete visitor

```
public class PolynomialSolverVisitor implements Visitor {
    private double[] result;

    @Override
    public void visitCubic() {
        System.out.println("Solving cubic equation using Cardano's formula...");
    }

    @Override
    public void visitPowerFour() {
        System.out.println("Solving 4th degree equation using Ferrari's method...");
    }

    @Override
    public void visitPowerFive() {
        System.out.println("Solving 5th degree equation using Newton-Raphson method...");
    }

    public double[] getResult() {
        return result;
    }
}

```
* This is the element interface, has the method to accept and solve(which is shared by all concrete elements) 
 ```

public interface Equation {
    void accept(Visitor visitor);
    double[] solve();
}

```
*  Finally we have an example of a concrete element for solving quartic equations which accepts the visitor visitPowerFour (the example is simplified for mantaining brevity the full one is in the code)
  ```
public class PowerFourEquation implements Equation {
    private double a, b, c, d, e;

    public PowerFourEquation(double a, double b, double c, double d, double e) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitPowerFour();
    }

    @Override
    public double[] solve() {
        // Ferrari's method for quartic equations
        // First, normalize the equation (make coefficient of x⁴ equal to 1)
        // Calculate coefficients of resolvent cubic equation
        // Solve resolvent cubic equation
        // Calculate coefficients for quadratic factors
        // Solve two quadratic equations
        // First quadratic: x² + (p/2 + R)x + E = 0
        // Second quadratic: x² + (p/2 - R)x + F = 0
        // Return only the found real roots
        
    }
}
```




## Conclusions / Screenshots / Results
* In conclusion behavioral patterns are about communication and assignment of responsability between objects. The visitor pattern permitted to have 3,4 5th degree equations mantaining open/ close and single responsability principles of SOLID.


<img width="471" alt="Captura de pantalla 2025-01-17 a las 17 16 10" src="https://github.com/user-attachments/assets/2357a012-c0e9-4b60-aa19-d3fcab244401" />
