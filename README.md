
 
[Español](README_ES.md) | [English](README.md)
# Software Patterns and Principles 🦔

## Summary
This repository was created for learning and educational purposes. Also intended to collect the 23 GOF design patterns

## Index
 * [Design Principles](#design-principles)
 * [Design Properties](#design-properties)
    * [Conceptual Integrity](#conceptual-integrity)
    * [Information Hiding](#information-hiding)
    * [Cohesion](#cohesion)
    * [Coupling](#coupling)
 * [SOLID Principles and Others](#solid-principles-and-others)
    * [Single Responsibility](#single-responsibility-cohesion)
    * [Open-Closed](#open-closed-extension)
    * [Liskov Substitution](#liskov-substitution-extension)
    * [Interface Segregation](#interface-segregation-cohesion)
    * [Dependency Inversion](#dependency-inversion-coupling)
    * [Principle of Least Privilege](#principle-of-least-privilege)
    * [Composition over Inheritance](#composition-over-inheritance)
 * [Creational Patterns](#creational-patterns)
    * [Singleton](#singleton)
    * [Factory Method](#factory-method)
    * [Abstract Factory](#abstract-factory)
    * [Builder](#builder)
 
 * [Structural Patterns](#structural-patterns) 
    * [Proxy](#proxy)
    * [Decorator](#decorator)
    * [Adapter](#adapter)
    * [Facade](#facade)
 * [Behavioral Patterns](#behavioral-patterns)
    * [Observer](#observer)
    * [Strategy](#strategy)
    * [Template Method](#template-method)
    * [Visitor](#visitor)
------

## Design principles

Design principles represent generic guidelines or recommendations to ensure that a design meets certain ````properties```` that allow us to understand and develop higher quality systems.
 
## Design Properties
### Conceptual Integrity
````Definition````: _A system cannot be an accumulation of functionalities without coherence or cohesion between them._ </br></br>
Conceptual integrity defines standards, conventions, and provides consistency in component design and system development. It is therefore very useful when seeking to facilitate the use and understanding of a system by its users.</br>

To follow this principle you should consider:
  *  Define a code convention (e.g., camelCase, snake_case)
  *  Define the standard design for components (e.g., data structures to be used)
  *  Define design principles to follow throughout development.</br>

Cases where a system doesn't follow this principle:
 * Different versions of a Framework are used
 * The same type of problem is solved using different data structures
 * Different code conventions exist
 

### Information Hiding
````Definition````: _Classes should hide implementation details that are subject to change._ </br></br>
Encapsulating or hiding all information is also not a solution, we must also make some details public like methods so that our class is useful and can communicate. The public methods of a class define its interface and constitute its ````visible```` part for the rest of classes and external code, which is why we must elaborate `````stable interfaces`````, this is achieved by correctly defining which methods will be both public and private within our class.</br>

Thanks to this principle we can:
 * Implement systems in parallel development much faster and easier to understand between developers.
 * Makes a system more flexible to changes by eliminating the risk of one component affecting the entire system
 * Facilitates understanding in a system thanks to interfaces.

 
 ### Cohesion
 ````Definition````: _A class should have a single responsibility and implement a single interest so that it has only one reason to be modified._  </br></br>
A class that follows this principle is considered a ````cohesive```` class </br>
This principle allows us to:
* Implement, understand and maintain classes more easily
* Facilitates assigning single responsibility to classes. 
* Facilitates class reuse and testing in the system.  
 
 ### Coupling
 ````Definition````: Measures the strength of connection or dependency between classes   
 Types of coupling:
  * Acceptable: When a class A only uses public methods or the interface of B
  * Not acceptable: When changes in a class A easily impact a class B
  * Evolutionary: Occurs when changes in a class B tend to propagate to an A or some other class unexpectedly (tends to be not acceptable)
  * Structural: When a class A has an explicit reference in its code to a class B (can be acceptable or not)

**How to avoid unacceptable coupling?**: By maximizing cohesion and minimizing the strength of connection between classes, this involves involving stable interfaces in dependencies. 

This doesn't seek to eliminate coupling of one class with another, there's no problem with a class needing others, especially those that use services like data structures, input or output, etc.
 
 ------
## SOLID Principles and Others

</br>
Practical recommendations that allow developers to follow design properties, due to this each principle is linked to a design property.

### **S**ingle Responsibility (Cohesion):
 Directly linked with the cohesion property and tells us that a class should have a single responsibility and a single reason to be modified.
### Example
 ````java
class Report {
    public String generate() { return "Report"; }
    public void print() { System.out.println("Report"); } // bad responsibility
}

✖️ The class has two responsibilities (generate a report and print to screen).
````

````java
class ReportGenerator {
    public String generate() { return "Report"; }
}

class ReportPrinter {
    public void print(String report) { System.out.println(report); }
}

✔️ By delegating responsibilities to different classes we obtain classes with single responsibilities
````
 ----
### **O**pen-Closed (Extension):
A class should be closed to modification but open to extension, in other words, your class should have the capability to add things but without having to modify its base logic.
### Example
````java
class Discount {
    public double apply(double price, String type) {
        if (type.equals("Christmas")) return price * 0.9;
        else return price;
    }
}

✖️ If we want to add another type of discount we will have to
   directly change the logic of the apply() method.
````
````java
interface DiscountStrategy {
    double apply(double price);
}

class ChristmasDiscount implements DiscountStrategy {
    public double apply(double price) { return price * 0.9; }
}

✔️ Now to add another type of discount a class should be
    added to the system instead of modifying any. 
````
------
### **L**iskov Substitution (Extension):
All overridden methods in a subclass must follow the same logic or functionality as the original method of the superclass.
This principle allows us to separate and define a good hierarchy between parent and child classes.

### Example
````java
class Bird {
    public void fly() {}
}

class Penguin extends Bird {
    public void fly() { throw new UnsupportedOperationException(); } // a penguin doesn't fly :c.
}

✖️ Although a penguin is a type of bird, they don't fly,
   therefore fly() within Penguin doesn't respect the contract
   it has with the Bird class.
````

````java
class Animal {}

class Bird extends Animal {
    public void fly() {}
}

class Penguin extends Animal {} // Doesn't extend from Bird

✔️ By creating a more general class we make penguin
   a type of Animal, this way we no longer have
   implementation or contract problems 
````
-------
### **I**nterface Segregation (Cohesion):
You should not be forced to implement unnecessary methods, interfaces should be simple, small, cohesive and contracts should be stable and specific for each client. 
Let's say different types of clients use only a part of the implementation of a class or interface, for this it's better to divide complex interfaces towards more specific and smaller ones, this way we make a concrete client have to interact with a concrete interface 
### Example
````java
interface Multifunctional {
    void print();
    void scan();
}

class Printer implements Multifunctional {
    public void print() {}
    public void scan() {} // Doesn't need this
}

✖️ All printers print but don't always scan, that's why in some
    implementations of Multifunctional the print() or scan() method will be useless.
````
````java
interface Printer {
    void print();
}

interface Scanner {
    void scan();
}

class BasicPrinter implements Printer {
    public void print() {}
}

✔️ An interface is created for each specific method and functionality, now
    printer classes which can only print, print and scan or only scan
    will only have to implement the necessary interfaces without any having
    empty or unnecessary methods. 
````
-------
### **D**ependency Inversion (Coupling):
This principle tells us to prefer interfaces over concrete classes since interfaces are more stable. To achieve this we must exchange the concrete class dependencies of the client for interfaces or abstractions, this way we maintain a stable dependency between the abstraction and the client.
### Example
````java
class GasolineEngine {
    public void start() {}
}

class Car {
    GasolineEngine engine = new GasolineEngine();
}

✖️ The Car class by using GasolineEngine depends
   directly on a concrete class or implementation
   and not on an interface.
  (undesired structural coupling)
````
````java
interface Engine {
    void start();
}

class Car {
    Engine engine;

    public Car(Engine engine) {
        this.engine = engine;
    }
}

✔️ The concrete dependency in Car was exchanged and now
    depends on an interface in case different Engine
    implementations are created or changed there will be no problems in
    Car since it depends only on the interface contracts
    (desired structural coupling).
````
----
### Principle of Least Privilege 
The principle of least privilege or Demeter provides a set of rules to avoid encapsulation problems.
It maintains that the implementation of a method in a class should only invoke the following other methods:

* From its own class  
* From objects passed as parameters  
* From objects created by the method itself 
* From class attributes of the method
Another way to understand this principle is not to call methods of objects returned by other methods.
The most common case we should avoid are method chains, of the form:
````java
a.getX().getY().getValue();
✖️ We are accessing internal objects of A by chaining calls.
    This exposes the internal structure and breaks encapsulation, making the
    class that makes this call know too much about the structure of others.
````
and substitute them for functions that perform said action:
````java
a.getXYValue();
✔️ We create a specific method in A which encapsulates the logic in
    how to return the value we want without having to
    depend on or make direct calls to the Y object.
````
-----
### Composition over Inheritance 
A composition-based solution is usually in most cases better than one based on inheritance.
Why?
Inheritance violates the encapsulation of parent classes. The implementation of subclasses becomes so coupled to the implementation of the parent class that any change in the latter can force modifications in the subclasses.

Due to this there are composition-based solutions which aim to replace inheritance-based solutions like the decorator pattern since nowadays some languages don't support inheritance.

 
````java
class Database {
    public void connect() {
        System.out.println("Connecting to database...");
    }
}

class Application extends Database {
    public void start() {
        connect();
        System.out.println("Application started.");
    }
}
class SimpleApplication {
    public void start() {
        System.out.println("Simple application started.");
    }
}
 
✖️ Although database attributes are needed, an application
   is not a Database, changes or errors in the parent class logic
   will propagate directly to all child classes.
   What will happen if we have to add a GUI class?
   Make it extend again from application? or from Database?
   it's unstable.
````
 
````java
class Database {
    public void connect() {
        System.out.println("Connecting to database...");
    }
}

class Application {
    private Database db = new Database();

    public void start() {
        db.connect();
        System.out.println("Application started.");
    }
}
class SimpleApplication {
    public void start() {
        System.out.println("Simple application started.");
    }
}
✔️ An application doesn't need to be a database, but it can need it, that's why
    we make it simply composed or not of this without depending on inheritance from it this way we also
    ensure that adding components to the Application class is not through a class hierarchy.
````

------
## Creational Patterns
<div align="center"> 
<img src="https://github.com/Reistoge/DesignPatterns/blob/main/src/CreationalPatterns/CreationalPatterns.png?raw=true" width="600px" height="300px" alt="#  ">   
</div>
Patterns that propose flexible solutions for object creation 

## When to use a creational pattern ?
_In situations related to object creation or instantiation mechanisms, aiming to abstract the process so that code is flexible, reusable, and decoupled from the specific classes it needs to instantiate._

## Singleton
> _This pattern ensures that there exists a unique instance of a class and furthermore that it is accessible from anywhere in our system._

### Example
Let's consider a game settings manager context
where we need to maintain consistent settings
across the entire game


````java
public class GameSettings {
    private int volume;
    private boolean fullscreen;
    private int difficulty;

    public GameSettings() {
        // Default settings
        volume = 50;
        fullscreen = false;
        difficulty = 1;
    }

    // Getters and setters
    public void setVolume(int volume) { this.volume = volume; }
    public int getVolume() { return volume; }
    public void setFullscreen(boolean fullscreen) { this.fullscreen = fullscreen; }
    public boolean isFullscreen() { return fullscreen; }
    public void setDifficulty(int difficulty) { this.difficulty = difficulty; }
    public int getDifficulty() { return difficulty; }
}

// Usage in different classes
class AudioManager {
    private GameSettings settings = new GameSettings();
    public void playSound() {
        // Uses its own settings instance
        int volume = settings.getVolume();
    }
}

class DisplayManager {
    private GameSettings settings = new GameSettings();
    public void updateDisplay() {
        // Uses different settings instance
        boolean fullscreen = settings.isFullscreen();
    }
}
✖️ Multiple classes create their own instances of gameSettings this can lead to data inconsistencies.
✖️ It's not necessary to reinitialize data every time it's needed by some other class.

 
````
### Solution 

<div align="center"> 
<img src="https://github.com/Reistoge/DesignPatterns/blob/main/src/CreationalPatterns/Singleton/SingletonUML.png?raw=true" alt="#  ">   
</div>

[Code](https://github.com/Reistoge/DesignPatterns/tree/main/src/CreationalPatterns/Singleton/Solution)</br>
### Advantages of this structure 
✔️ Data is initialized only once or when necessary.</br>
✔️ There is better data consistency since there exists a single source from where to consult and access them.
 

## Factory Method
> _Establishes the relationship of a Creator-Product where each product has its concrete creator, this way we can delegate thanks to an abstract method the concrete creation of each concrete product creating a product without the need to specify its concrete type._
 
### Example
Imagine a drawing application that needs to create different colored shapes (Red triangles, Blue circles, Green rectangles). Initially, the shapes are created directly in the client code:

````java
public class Shape {
    private String name;
    private String shape;
    private String color;

    public Shape(String name, String shape, String color) {
        this.name = name;
        this.shape = shape;
        this.color = color;
    }

    public void draw() {
        System.out.println("Drawing " + color + " " + shape + ": " + name);
    }
}

public class DrawingApp {
    public static void main(String[] args) {
        // Client code creates shapes directly
        Shape redTriangle = new Shape("Red1", "Triangle", "Red");
        Shape blueCircle = new Shape("Blue1", "Circle", "Blue");
        Shape greenRectangle = new Shape("Green1", "Rectangle", "Green");
        
        // Complex creation logic scattered in client code
        if(needsRedShape()) {
            redTriangle.draw();
        } else if(needsBlueShape()) {
            blueCircle.draw();
        } else {
            greenRectangle.draw();
        }
    }
}
✖️ Drawing app is concerned with creating and showing shapes, it should only show. (SRP)
✖️ The user must interact with a concrete class instead of an interface 
✖️ difficult to maintain when adding or modifying a shape implies
having to modify the logic of the Draw class which involves other shapes too (OCP).
````
### Solution 

<div align="center"> 
<img src="https://github.com/Reistoge/DesignPatterns/blob/main/src/CreationalPatterns/FactoryMethod/FactoryMethodUML.png?raw=true" alt="#  ">   
</div>

[Code](https://github.com/Reistoge/DesignPatterns/tree/main/src/CreationalPatterns/FactoryMethod/Solution)</br>
### Advantages of this structure 
✔️ Adding or modifying a shape doesn't involve external code which has no relation to the class itself.</br>
✔️ We define concrete and stable contracts for each creator and shape, maintainable and safe.</br>
✔️ We are hiding the creation of each Shape since the client interacts with a Creator not a concrete product</br>
 
## Abstract Factory
   
   > _Provides an interface for creating families of related objects without specifying their concrete classes_.<br/>
   > _Offers an interface for creating families of related objects without specifying their concrete classes_.
  <div align="center"  > <img src="https://github.com/Reistoge/DesignPatterns/blob/main/src/CreationalPatterns/AbstractFactory/dpcs_af-432075449.png?raw=true"   alt="#  ">  </div>

### Example:
A video game store needs a system to manage their inventory of gaming consoles and controllers.
Initially, they had a simple, tightly coupled structure
````java
public class VideoGameStore {
    public Console createConsole(String brand) {
        if (brand.equals("Sony")) {
            return new PlayStation5();
        } else if (brand.equals("Microsoft")) {
            return new XboxSeriesX();
        } else if (brand.equals("Nintendo")) {
            return new NintendoSwitch();
        }
        throw new IllegalArgumentException("Unknown brand");
    }

    public Controller createController(String brand) {
        if (brand.equals("Sony")) {
            return new DualShock5();
        } else if (brand.equals("Microsoft")) {
            return new XboxController();
        } else if (brand.equals("Nintendo")) {
            return new ProController();
        }
        throw new IllegalArgumentException("Unknown brand");
    }
}
✖️ Adding a console or controller implies modifying the base code
✖️ The class doesn't have a single responsibility
✖️ The class depends on concrete classes and not on abstractions or interfaces.
````
### Solution 
<div align="center"> 
<img src="https://github.com/Reistoge/DesignPatterns/blob/main/src/CreationalPatterns/AbstractFactory/AbstractFactory.drawio.png?raw=true" width="800px" height="500px" alt="#  ">
</div>

[Code](https://github.com/Reistoge/DesignPatterns/tree/main/src/CreationalPatterns/AbstractFactory)</br>
### Advantages of this structure
✔️ Client interacts only with stable interfaces or abstractions.</br>
✔️ Facilitates addition and maintenance when implementing new types of controllers, consoles and even other types of products.

#### Concrete Factories : ````NintendoFactory````,````MicrosoftFactory````,````SonyFactory````
#### Concrete Products A: ````NintendoSwitch````,````XboxSeriesX````,````Playstation5````
#### Concrete Products B: ````ProController````,````XboxController````,````DualShock5````

## Builder
> _Allows us to simplify the constructor of an object when it is complex allowing us to abstract its different forms of construction simplifying the different construction implementations of the object._
 
### Example
Imagine a drawing application that needs to create different colored shapes (Red triangles, Blue circles, Green rectangles). Initially, the shapes are created directly in the client code:

````java
public class Character {
    private String name;
    private String dialogue;
    private String type;
    private String description;
    private float level;
    private float weight;
    private float experience;
    private float attack;
    private float defense;
    private float speed;

    Character(String name, String dialogue, String type, String description, float level, float weight, float experience, float attack, float defense, float speed) {
        this.name = name;
        this.dialogue = dialogue;
        this.type = type;
        this.description = description;
        this.level = level;
        this.weight = weight;
        this.experience = experience;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "name: "  + this.name + "\n"+
                "dialogue: "  + this.dialogue+ "\n"+
                "type: "  + this.type+ "\n"+
                "description: "  + this.description+ "\n"+
                "level: "  + this.level + "\n"+
                "weight: "  + this.weight+ "\n"+
                "experience: "  + this.experience+ "\n"+
                "attack: "  + this.attack+ "\n"+
                "defense: "  + this.defense + "\n"+
                "speed: "  + this.speed;
    }

    // ..... setters and getters

 
}
✖️ The constructor is very complex and saturated with parameters
✖️ A way to make constructing this object simpler is needed
✖️ If we seek constructor combinations with different parameters,
 leaving them empty is not a scalable solution and creating one by one isn't either.
````
### Solution 

<div align="center"> 
<img src="https://github.com/Reistoge/DesignPatterns/blob/main/src/CreationalPatterns/Builder/BuilderUML.png?raw=true" alt="#  ">   
</div>

[Code](https://github.com/Reistoge/DesignPatterns/tree/main/src/CreationalPatterns/FactoryMethod/Solution)</br>
### Advantages of this structure 
✔️ Object construction was simplified since it can now be initialized with the combination of parameters the client desires.</br>
✔️ Adding an attribute to object construction is much more scalable and stable since we don't have to worry about new combinations.

-------

## Structural Patterns
<div align="center"> 
<img src="https://github.com/Reistoge/DesignPatterns/blob/main/src/StructuralPatterns/StructuralPatterns.png?raw=true" width="391px" height="292px" alt="#  ">   
</div>
Patterns that propose flexible solutions for the composition of classes and objects

## When to use a Structural pattern ?
_In situations which involve encapsulation of object composition or also dynamism and flexibility in object composition such as making it easy to substitute an object's composition for another._ 

## Proxy
> _Seeks to substitute an object (subject) and control its access through a class that implements the same interface as the subject._
 
### Example
You need to show a preview of an asset (maybe a thumbnail or a name),
but only load the actual image when the user wants to use it because
these assets are large and stored remotely (in cloud storage or on disk),
and loading them all at once is too expensive in memory and time.

````java
public class SimpleAssetLoader {
    private List<String> assets = new ArrayList<>();

    public String loadAsset(String name) {
        // Always performs expensive processing
        String processedAsset = processAsset(name);
        assets.add(processedAsset);
        return processedAsset;
    }

    public void showAsset(String name) {
        // Always loads and processes the asset
        String asset = loadAsset(name);
        System.out.println("Showing asset: " + asset);
    }

    private String processAsset(String name) {
        // Simulates expensive processing
        return name.toUpperCase() + ".PROCESSED";
    }
}
✖️ There exists an uncontrolled high-cost method
    which furthermore doesn't need to be called every time
````
### Solution 
<div align="center"> 
<img src="https://github.com/Reistoge/DesignPatterns/blob/main/src/StructuralPatterns/Proxy/ProxyUML.png?raw=true" width="500px" height="300px" alt="#  ">   
</div>

[Code](https://github.com/Reistoge/DesignPatterns/tree/main/src/StructuralPatterns/Proxy/Solution)</br>
### Advantages of this structure 
✔️ We are controlling the contracts of concrete AssetLoader without having 
to modify its base code this way we can execute its methods
under the conditions of AssetLoaderProxy since both implement the same interface.
       
## Decorator
> _Used mainly when we want to add or add new functionalities to one or several types of components dynamically._

### Example
A small food truck sells Chilean Completos (hot dogs)
and needs to calculate prices for different combinations.
Initially, they handle it with a single class.

````java
public class ChileanCompleto {
    private boolean hasMayo;
    private boolean hasPalta;
    private boolean hasKetchup;
    private boolean isLightKetchup;
    private String sausageType; // normal, premium, veggie

    public ChileanCompleto() {
        this.sausageType = "normal";
    }

    public float calculatePrice() {
        float basePrice = 2.0f; // base completo price

        // Add toppings prices
        if (hasMayo) {
            basePrice += 0.2f;
        }
        if (hasPalta) {
            basePrice += 0.5f;
        }
        if (hasKetchup) {
            basePrice += isLightKetchup ? 0.3f : 0.1f;
        }

        // Calculate sausage price
        switch (sausageType.toLowerCase()) {
            case "premium":
                basePrice += 2.0f;
                break;
            case "veggie":
                basePrice += 3.0f;
                break;
        }

        return basePrice;
    }

    public void displayCompleto() {
        System.out.println("Chilean Completo with:");
        System.out.println("- Sausage type: " + sausageType);
        if (hasMayo) System.out.println("- Mayo");
        if (hasPalta) System.out.println("- Palta");
        if (hasKetchup) System.out.println("- Ketchup" + (isLightKetchup ? " (light)" : ""));
        System.out.println("Total price: " + calculatePrice());
    }

    // Setters
    public void addMayo() { this.hasMayo = true; }
    public void addPalta() { this.hasPalta = true; }
    public void addKetchup(boolean light) {
        this.hasKetchup = true;
        this.isLightKetchup = light;
    }
    public void setSausageType(String type) { this.sausageType = type; }
}
````
### Solution
<div align="center"> 
<img src="https://github.com/Reistoge/DesignPatterns/blob/main/src/StructuralPatterns/Decorator/DecoratorUML.png?raw=true"  alt="#  ">   
</div>

[Code](https://github.com/Reistoge/DesignPatterns/tree/main/src/StructuralPatterns/Decorator/Solution)</br>
In this case, we want a component and its ingredients to have
a price() and a display() in the program. We must establish 
this because, by saying this, we can create a single interface for both 
the component (Component) and the ingredients (Decorator). 
Now we start implementing the decorator structure in our solution.

1. Create the **IComponent** or **AbstractComponent** interface
2. Create an abstract **Decorator** class
3. Create all concrete components and make the Decorator class implement the IComponent interface
4. Inside the Decorator class, add a field of type IComponent called "component"
and delegate each call of the implementation methods to the component
(e.g., inside method1() -> component.method1())
5. Create a ConcreteDecorator class that extends Decorator
and overrides each method call by first calling the same method of the superclass.

## Adapter
> _Provides us with an intermediate interface so that an incompatible class can integrate into our structure without modifying the original code_.  
 
### Example
Your app was initially built to work with WeatherServiceA,
but now you need to integrate WeatherServiceB, which uses
a totally different interface. Your goal is to make
both work without changing the original client code
that expects WeatherServiceA.
````java
public class OpenWeatherA implements WeatherServiceA{
    @Override
    public String getTemperatureInCelsius(String city) {
        return "25ºc in " + city;
    }
}
public interface WeatherServiceA {
    String getTemperatureInCelsius(String city);
}
// New third-party library that you need to integrate (you can't modify this class)
public class WeatherServiceB {
    public double getTempFahrenheit(String location) {
        // Simulates an external API that only returns Fahrenheit
        return 77.0;
    }
}

````
### Solution 

<div align="center"> 
<img src="https://github.com/Reistoge/DesignPatterns/blob/main/src/StructuralPatterns/Adapter/AdapterUML.png?raw=true" alt="#  ">   
</div>

[Code](https://github.com/Reistoge/DesignPatterns/tree/main/src/StructuralPatterns/Adapter/Solution)</br>
### Advantages of this structure 
✔️ Through Dependency Inversion and Interface Segregation 
we manage to make functionalities compatible with our system by creating
an interface without altering the original code.</br>

-----
## Facade
> _Provides us with a class or interface which seeks to simplify the use of multiple subsystems in a specific or complex way into a single interface which is simpler to work with this set_.  
 
### Example
You're building a media player system, to play a song you have to manually
decode, buffer this creates tight coupling between the high-level
application logic and the low level subsystems.

 
````java
public class AudioBuffer {
    public void loadBuffer(String filePath) {
        System.out.println("Buffering audio file: " + filePath);
    }
}
public class AudioDecoder {
    public void decode(String filePath) {
        System.out.println("Decoding audio file: " + filePath);
    }
}
public class AudioDriver {
    public void playSound() {
        System.out.println("Playing sound through audio driver");
    }
}
public class MediaPlayer {

    public void turnOnMediaPlayer() {
        String song = "song.mp3";

        AudioDecoder decoder = new AudioDecoder();
        decoder.decode(song);

        AudioBuffer buffer = new AudioBuffer();
        buffer.loadBuffer(song);

        AudioDriver driver = new AudioDriver();
        driver.playSound();
    }
}
✖️ For one method we are directly invoking many subsystems as if it were a template or initialization, as our code grows this will increasingly be more complex to understand.
✖️ It's not necessary to reinitialize components every time this method is called since it's not part of constructing this.
✖️ If the initialization of a subsystem is very complex the code will be very difficult to understand and our class will have more reasons to be modified. 
````
### Solution 
Instead of using N subsystems or concrete interfaces in the same client code, a "Facade" class is created that provides a simplified interface to the subsystems. This way, the complexity of the client code is reduced, so that the client only calls the facade methods, and this takes care of calling the subsystems.

<div align="center"> 
<img src="https://github.com/Reistoge/DesignPatterns/blob/main/src/StructuralPatterns/Facade/FacadeUML.png?raw=true" alt="#  ">   
</div>

[Code](https://github.com/Reistoge/DesignPatterns/tree/main/src/StructuralPatterns/Facade/Solution)</br>
### Advantages of this structure 
✔️ Through composition and aggregation components are initialized only when really necessary.</br>
✔️ We reduce the complexity of the turnOnMediaPlayer() method by encapsulating and hiding the specific initialization of each component.</br>

-----
## Behavioral Patterns
<div align="center"> 
<img src="https://github.com/Reistoge/DesignPatterns/blob/main/src/BehavioralPatterns/BehavioralPatterns.png?raw=true" alt="#  ">   
</div>
Patterns that propose flexible solutions for interaction and division of responsibilities between classes and objects

## When to use a Behavioral pattern ?
_In situations which involve distributing or controlling processing and algorithms between objects or also when seeking to specify dynamic flows and processing of an object system._ 

## Visitor
> Allows the addition or construction of new operations and functionalities (visitors) that must be performed on the elements of a set of objects (elements) without the need to modify their class.

### Example
A museum needs to manage different types of artworks 
(Paint, Sculpture, Photograph) and perform various 
operations on them like generating reports,
calculating insurance values, and exporting data.
````java
public class Artwork {
    private String name;
    private double value;

    public void generatePdfReport() {
        if (this instanceof Paint) {
            System.out.println("Generating PDF for painting");
        } else if (this instanceof Sculpture) {
            System.out.println("Generating PDF for sculpture");
        } else if (this instanceof Photograph) {
            System.out.println("Generating PDF for photograph");
        }
    }

    public void calculateInsurance() {
        if (this instanceof Paint) {
            System.out.println("Calculating insurance for painting");
        } else if (this instanceof Sculpture) {
            System.out.println("Calculating insurance for sculpture");
        } else if (this instanceof Photograph) {
            System.out.println("Calculating insurance for photograph");
        }
    }

    public void exportToCsv() {
        if (this instanceof Paint) {
            System.out.println("Exporting painting to CSV");
        } else if (this instanceof Sculpture) {
            System.out.println("Exporting sculpture to CSV");
        } else if (this instanceof Photograph) {
            System.out.println("Exporting photograph to CSV");
        }
    }
}
✖️ Information from each element is not being properly hidden and
   furthermore whenever we have to add a functionality or operation
   we will have to modify the base code of Artwork which involves
   all other elements unnecessarily
   
````
### Solution 
1. Create an interface for the elements that will have logic applied to them (IElement) and the visitor that applies logic to the elements (IVisitor)
2. For the visitor interface:
    1. Our interface must be **capable** that in a single method it can 
       accept and apply different logic on concrete IElements that's why we must **add
       the same accept() method** but supported for **different parameters** which would be 
       each concrete type of elements.
       ````java
       accept(C1 element1);
       accept(C2 element2);
       accept(C3 element3);
       ````
           
3. For the Element interface:
   1. add a method
   ````java
    visit(IVisitor v);
   ````
   3. inside each concrete element it's important that inside the function body this is implemented this way
   ````java
    v.visit(this)
   ````
      
   
<div align="center"> 
<img src="https://github.com/Reistoge/DesignPatterns/blob/main/src/BehavioralPatterns/Visitor/VisitorUML.png?raw=true"  alt="#  ">   
</div>

[Code](https://github.com/Reistoge/DesignPatterns/tree/main/src/BehavioralPatterns/Visitor/Solution)</br>
### Advantages of this structure 
✔️ Thanks to the structure of this pattern each type of element will automatically redirect to the visitor executing its corresponding type method, this way when we have to add functionality for the elements we must simply create a class which implements the visitor interface and go adding the new functionality for each element separately.

### Detail
😔 The visitor pattern on the other hand has a great disadvantage and that's when we need to add new elements to our structure since it will suppose modifying the visitor interface and all its implementations (evolutionary coupling).

## Observer
> Allows defining dynamic subscription mechanisms to notify events to multiple objects which observe or listen to a Subject    

### Example
A multimedia application needs to update and notify different types
of users (Windows, Android, iPhone) about new app versions and messages.
Initially, the updates are handled through direct method calls.

````java
public class MultimediaApp {
    private ArrayList<String> windowsUsers = new ArrayList<>();
    private ArrayList<String> androidUsers = new ArrayList<>();
    private ArrayList<String> iphoneUsers = new ArrayList<>();
    private String currentVersion;

    public void addUser(String name, String platform) {
        switch(platform.toLowerCase()) {
            case "windows":
                windowsUsers.add(name);
                break;
            case "android":
                androidUsers.add(name);
                break;
            case "iphone":
                iphoneUsers.add(name);
                break;
        }
    }

    public void updateAppVersion(String newVersion) {
        currentVersion = newVersion;

        // Direct update calls for each platform
        for(String user : windowsUsers) {
            System.out.println("Updating Windows user " + user + " to version " + newVersion);
        }
        for(String user : androidUsers) {
            System.out.println("Updating Android user " + user + " to version " + newVersion);
        }
        for(String user : iphoneUsers) {
            System.out.println("Updating iPhone user " + user + " to version " + newVersion);
        }
    }

    public void sendMessage(String message) {
        // Direct message sending for each platform
        for(String user : windowsUsers) {
            System.out.println("Sending to Windows user " + user + ": " + message);
        }
        for(String user : androidUsers) {
            System.out.println("Sending to Android user " + user + ": " + message);
        }
        for(String user : iphoneUsers) {
            System.out.println("Sending to iPhone user " + user + ": " + message);
        }
    }
}
✖️ Modifying or adding specific logic to an observer implies changing the logic within
where all others are notified, SRP is not respected.
✖️ There's no definition of contracts or a concrete definition for each type of observer


   
````
### Solution 
<div align="center"> 
<img src="https://github.com/Reistoge/DesignPatterns/blob/main/src/BehavioralPatterns/Observer/ObserverUML.png?raw=true"  alt="#  ">   
</div>

[Code](https://github.com/Reistoge/DesignPatterns/tree/main/src/BehavioralPatterns/Observer/Solution)</br>
### Advantages of this structure 
✔️ We can add observers and subjects without the need to modify or alter the base logic (Coupling)</br>
✔️ We can add or modify the specific logic to each observer in the way it is updated and how each subject notifies its observers (encapsulation).</br>
✔️ Thanks to this structure it's much simpler and maintainable to make combinations between subjects and observers since they communicate through an interface.(conceptual integrity)</br>

## Template Method
> Allows defining the skeleton or template of an algorithm which furthermore is composed of abstract processes which apply different logic.  

### Example
A scientific calculation system needs to process different
mathematical formulas. Each formula follows a similar three-step
calculation pattern but with different mathematical operations.

````java
public class ScientificCalculation {
    private float a;
    private float b;
    private float c;
    private float d;
    private float e;

    public float processFormula1() {
        // Three-step calculation duplicated
        float step1 = a * b;
        float step2 = c + a;
        float step3 = Math.pow(a, b);
        return (step1 * step2) + step3;
    }

    public float processFormula2() {
        // Same three-step structure, different math
        float step1 = (d + e) * (d + e);
        float step2 = Math.exp(e);
        float step3 = (2 * d) / e;
        return (step1 * step2) + step3;
    }
}
✖️ Every time we add a new process we will have to rewrite the template code (unacceptable coupling)
✖️ If we have many processes and decide to change the template code we would break with
the structure of our system, having to go update each concrete process (evolutionary coupling, OCP)


   
````
### Solution 
<div align="center"> 
<img src="https://github.com/Reistoge/DesignPatterns/blob/main/src/BehavioralPatterns/TemplateMethod/TemplateMethodUML.png?raw=true"  alt="#  ">   
</div>

[Code](https://github.com/Reistoge/DesignPatterns/tree/main/src/BehavioralPatterns/TemplateMethod/Solution)</br>
### Advantages of this structure 
✔️ We don't have to be rewriting the formula every time we create a new process.</br>
✔️ Now it's more scalable because if we want to change the base formula we simply have to change it within the ````templateMethod()```` method.</br>
✔️ Each process is encapsulated and hides its information both attributes and methods in a way that they can be modified without having to alter the general structure.</br>

## Strategy
> Allows us to define a structure which selects at runtime what type of algorithm will be executed for a concrete process.   

### Example
A sorting application needs to handle different types
of sorting for integers and strings.

````java
public class SortingApp {
    private String sortingType;

    public ArrayList<Integer> sortIntegers(ArrayList<Integer> numbers, String sortType) {
        this.sortingType = sortType;
        ArrayList<Integer> result = new ArrayList<>(numbers);

        // Complex conditional logic for different sorting types
        if (sortType.equals("bubble")) {
            // ... bubble sort implementation
        } else if (sortType.equals("heap")) {
            // Duplicate heap sort logic here
            // ... heap sort implementation
        }
        return result;
    }

    public ArrayList<String> sortStrings(ArrayList<String> words, String sortType) {
        this.sortingType = sortType;
        ArrayList<String> result = new ArrayList<>(words);

        // Same sorting logic duplicated for strings
        if (sortType.equals("bubble")) {
            // Duplicate bubble sort for strings
        } else if (sortType.equals("heap")) {
            // Duplicate heap sort for strings
        }
        return result;
    }
}
✖️ The logic of each algorithm is not encapsulated, we must modify
the general structure whenever we want to modify any of the algorithms.
✖️ When we want to associate a specific type of algorithm to an
entity or object this structure will become increasingly unstable.


   
````
### Solution 
<div align="center"> 
<img src="https://github.com/Reistoge/DesignPatterns/blob/main/src/BehavioralPatterns/Strategy/StrategyUMLExample.png?raw=true"  alt="#  ">   
</div>

[Code](https://github.com/Reistoge/DesignPatterns/tree/main/src/BehavioralPatterns/Strategy/Solution)</br>
### Advantages of this structure 
✔️ Each concrete logic is encapsulated hiding the information of its specific methods and attributes so modifying it doesn't alter the general structure.</br>
✔️ Because this structure handles each concrete algorithm as an entity, we can associate these algorithms to other types of entities in a scalable way.</br>
