
# Design Patterns 
## Summary
This repository was created for learning and educational purposes. Also Intended to collect the 23 GOF design patterns
## Index
 * [Creational Patterns](https://github.com/Reistoge/DesignPatterns/tree/main/src/CreationalPatterns) 
 * Structural Patterns
 * Behavioral Patterns
 
 ------
<div align="center"> 
<img src="https://github.com/Reistoge/DesignPatterns/blob/main/src/CreationalPatterns/CreationalPatterns.png?raw=true" width="600px" height="300px" alt="#  ">   
</div>

## When to use a creational pattern ?
_In situations related to object creation or instantiation mechanisms, aiming to abstract the process so that code is flexible, reusable, and decoupled from the specific classes it needs to instantiate._

### 1. Abstract Factory
  
   > "Provides an interface for creating families of related objects without specifying their concrete classes".<br/>
   > "Ofrece una interfaz para crear familias de objetos relacionados y sin especificar sus clases concretas".
  <div align="center"  > <img src="https://github.com/Reistoge/DesignPatterns/blob/main/src/CreationalPatterns/AbstractFactory/dpcs_af-432075449.png?raw=true" width="400px" height="200px"  alt="#  ">  </div>


### Example:

[UML Diagram](https://github.com/Reistoge/DesignPatterns/blob/main/src/CreationalPatterns/AbstractFactory/AbstractFactory.drawio.png?raw=true") <br/>
[Code](https://github.com/Reistoge/DesignPatterns/tree/main/src/CreationalPatterns/AbstractFactory)
#### Concrete Factories : ````NintendoFactory````,````MicrosoftFactory````,````SonyFactory````
#### Concrete Products A: ````NintendoSwitch````,````XboxSeriesX````,````Playstation5````
#### Concrete Products B: ````ProController````,````XboxController````,````DualShock5````



-------
