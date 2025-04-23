
# Design Patterns 🦔

## Summary
This repository was created for learning and educational purposes. Also Intended to collect the 23 GOF design patterns

## Index
 * Design Principles
 * [Creational Patterns](https://github.com/Reistoge/DesignPatterns/tree/main/src/CreationalPatterns) 
 * Structural Patterns
 * Behavioral Patterns
------
## Design principles
Los principios de diseño representan directrices o recomendaciones genericas para garantizar que un diseño cumple con determinadas  ````propiedades````  las cuales nos permiten entender y desarollar sistemas de mayor calidad.

 
## Propiedades
### Integridad conceptual
````Definicion````: _Un sistema no puede ser una acumulación de funcionalidades sin coherencia ni cohesión entre ellas._ </br></br>
La integridad conceptual define estandares, convenciones y brinda consistencia al diseño de componentes y al desarrollo de un sistema, por lo tanto es de gran utilidad cuando buscamos facilitar el uso y la comprensión de un sistema por parte de sus usuarios.
</br>

Para seguir este principio se debe considerar
  *  definir una convencion de codigo (ej; camelCase, snake_case)
  *  definir el Diseño estandar para los componentes (ej: estructuras de datos que se usarán)
  *  definir principios de diseño a seguir a lo largo del desarrollo.</br>

Casos en los cuales un sistema no se sigue este principio.
 * Se usan distintas versiones de un Framework
 * Se resuelve un mismo tipo de problema usando otro tipo de estructuras de datos
 * Que existan distintas convenciones de codigo
 

### Ocultamiento de informacion
````Definicion````: _Las clases deben ocultar detalles de implementación que estén sujetos a cambios._ </br></br>
Encapsular o ocultar toda la informacion tampoco es una solucion, debemos tambien hacer publicos algunos detalles como los metodos para que nuestra clase sea útil y pueda comunicarse, los metodos publicos de una clase definen su interfaz y constituye su parte ````visible```` para el resto de clases y codigo externo, es por esto que debemos elaborar `````interfaces estables`````, esto se logra definiendo correctamente que metodos seran tanto publicos como privados dentro de nuestra clase.</br>

Gracias a este principio podemos:
 * Implementar sistemas en desarrollo paralelo mucho más rapido y facil entender entre desarrolladores.
 * Hace que un sistema sea más flexible ante cambios eliminando el riesgo de que un componente efecte a todo el sistema 
 * Facilita la comprension en un sistema gracias a las interfaces.

 
 ### Cohesion
 ````Definición````: _Una clase debe de tener una unica responsabilidad e implementar un unico interes para que de esta forma tenga un solo motivo para ser modificada._  </br></br>
Una clase que siga este principio es considerada una clase ````cohesiva```` </br>
Este principio nos permite:
* Implementar, comprender y mantener clases más facil
* Facilita la asignacion de responsabilidad unica a las clases. 
* Facilita reutilizacion y el testing de clases en el sistema.  
 
 ### Acoplamiento
 ````Definicion````: Mide la fuerza de conexion o dependencia entre clases   
 Tipos de acoplamiento:
  * Aceptable: Cuando una clase A solo usa metodos publicos o la interfaz de B
  * No aceptable: Cuando cambios en una clase A impactan facilmente a una clase B
  * Evolutivo: Ocurre cuando los cambios en una clase B tienden propagarse a una A o alguna otra clase de manera inesperada (tiende a ser no aceptable)
  * Estructural: Cuando una clase A tiene una referencia explícita en su código a una clase B (puede ser aceptable o no)

**¿Como evitar un acoplamiento no aceptable?** : Maximizando la cohesion y minimizando la fuerza de conexion entre clases esto es involucrando interfaces estables en la dependencias. 

Con esto no se busca eliminar el acoplamiento de una clase con otra, no hay problema en que una clase necesite de otras, especialmente de aquellas que usen servicios como estructura de datos, input u output, etc.
 
 ------
## Principios SOLID y otros </br>

Recomendaciones a nivel practico que permiten a los desarrolladores seguir las propiedades de diseño, debido a esto cada principio esta ligado a una propiedad de diseño.

### **S**ingle Responsability (Cohesión):
 Directamente ligada con la propiedad de cohesion y nos dice que una clase debe de tener una unica responsabilidad y un unico motivo para ser modificada.
### Ejemplo
 ````java
class Reporte {
    public String generar() { return "Reporte"; }
    public void imprimir() { System.out.println("Reporte"); } // mala responsabilidad
}

✖️ La clase tiene dos responsabilidades (generar un reporte e imprimir por pantalla).
````

````java
class GeneradorReporte {
    public String generar() { return "Reporte"; }
}

class ImpresoraReporte {
    public void imprimir(String reporte) { System.out.println(reporte); }
}

✔️ Delegando las responsabilidades en distintas clases obtenemos clases con responsabilidades unicas
````
 ----
### **O**pen-Closed (Extensión):
Una clase debe estar cerrada a modificacion pero abierta a extension, en otras palabras, tu clase debe de tener la capacidad de poder agregar cosas pero sin tener que modificar la logica base de esta.
### Ejemplo
````java
class Descuento {
    public double aplicar(double precio, String tipo) {
        if (tipo.equals("Navidad")) return precio * 0.9;
        else return precio;
    }
}

✖️ Si queremos agregar otro tipo de descuento tendremos que
   cambiar directamente la logica del metodo aplicar().
````
````java
interface EstrategiaDescuento {
    double aplicar(double precio);
}

class DescuentoNavidad implements EstrategiaDescuento {
    public double aplicar(double precio) { return precio * 0.9; }
}

✔️ Ahora para agregar otro tipo de descuento se debe
    agregar una clase al sistema en vez de modificar alguna. 
````
------
### **L**iskov substitution (Extensión):
Todos los métodos sobrescritos en una sub clase deben seguir la misma lógica o funcionalidad que el método original de la super clase.
Este principio nos permite separar y definir una buena jerarquia entre clases padres e hijas.

### Ejemplo
````java
class Ave {
    public void volar() {}
}

class Pinguino extends Ave {
    public void volar() { throw new UnsupportedOperationException(); } // un pingüino no vuela :c.
}

✖️ A pesar de que un pingüino es un tipo de ave, estos no vuelan,
   por lo tanto volar() dentro de Pingüino no respeta el contrato
   que tiene con la clase Ave.
````

````java
class Animal {}

class Ave extends Animal {
    public void volar() {}
}

class Pinguino extends Animal {} // No extiende de Ave

✔️ Al crear una clase más general hacemos a pingüino
   un tipo de Animal, de esta manera ya no tenemos
   problemas de implementacion u contrato 
````
-------
### **I**nterface segregation (Cohesión):
No se debe forzar a implementar metodos innecsarios, las interfaces deben de ser simples, pequeñas, cohesionadas y los contratos deben de ser estables y especificos para cada cliente. 
Digamos que distintos tipos de clientes usan solamente una parte de la implementacion de una clase o interfaz para esto es mejor la division de interfaces complejas hacia más especificas y pequeñas, de esta forma hacemos que un cliente concreto tenga que interactuar con una interfaz concreta 
### Ejemplo
````java
interface Multifuncional {
    void imprimir();
    void escanear();
}

class Impresora implements Multifuncional {
    public void imprimir() {}
    public void escanear() {} // No necesita esto
}

✖️ Todas las impresoras imprimen pero no siempre escanean, es por eso que en algunas
    implementaciones de Multifuncional el metodo imprimir() o escanear() será inutil.
````
````java
interface Impresora {
    void imprimir();
}

interface Escaner {
    void escanear();
}

class ImpresoraBasica implements Impresora {
    public void imprimir() {}
}

✔️ Se crea una interfaz para cada metodo y funcionalidad en especifico, ahora las
    clases de Impresoras las cuales solo puedan imprimir, imprimir y escanear o solo escanear
    tendran que solamente implementar las interfaces necesarias sin que alguna tenga
    metodos vacios o innecesarios. 
````
-------
### **D**epency inversion (Acoplamiento):
Este principio nos dice que prefiramos interfaces frente clases concretas ya que las interfaces son más estables, para lograr esto debemos de intercambiar las dependencias de clases concretas del cliente por interfaces o abstracciones, de esta manera mantenemos una dependencia estable entre la abstracción y el cliente.
### Ejemplo
````java
class MotorGasolina {
    public void encender() {}
}

class Auto {
    MotorGasolina motor = new MotorGasolina();
}

✖️ La clase Auto al usar MotorGasolina depende
   directamente de una clase concreta o implementación
   y no de una interfaz.
  (acoplamiento estructural no deseado)
````
````java
interface Motor {
    void encender();
}

class Auto {
    Motor motor;

    public Auto(Motor motor) {
        this.motor = motor;
    }
}

✔️  Se intercambio la dependencia concreta en Auto y ahora
    depende de una interfaz en caso de que se crearan o cambien
    distintas implementaciones de Motor no habran problemas en
    Auto ya que esta depende solo de los contratos de la interfaz
    (acoplamiento estructural deseado).
````
----
### Principle of Least Privilege 
El principio de menor privilegio o Demeter brinda un conjunto de reglas para evitar problemas de encapsulamiento.
Sostiene que la implementacion de un metodo en un clase debe solo invocar los invocar los siguientes otros métodos:

* De su propia clase  
* De objetos pasados como parámetros  
* De objetos creados por el propio método 
* De atributos de la clase del método
Otra forma de entender este principio es no llamar a métodos de los objetos devueltos por otros métodos.
El caso más común que debemos evitar son las cadenas de métodos, de la forma:
````java
a.getX().getY().getValue();
✖️ Estamos accediendo a objetos internos de A encadenando llamadas.
    Esto expone la estructura interna y rompe el encapsulamiento, haciendo que la
    clase que hace esta llamada conozca demasiado sobre la estructura de otras.
````
y sustituirlas por funciones que realicen dicha acción:
````java
a.getXYValue();
✔️ Creamos un metodo especifico en A el cual encapsula la logica en
    como se tiene que devolver el valor que queremos sin tener que
    depender o hacer llamadas directas del objeto Y.
````
-----
### Composition over Inheritance 
Una solucion basada en composicion sueler en la mayoria de los casos mejor una basada en herencia.
¿Por qué?
La herencia viola el encapsulamiento de las clases padre. La implementación de las subclases se vuelve tan acoplada a la implementación de la clase padre que cualquier cambio en estas últimas puede forzar modificaciones en las subclases.

Debido a esto existen soluciones basadas en composicion las cuales tienen como objetivo reemplazar las soluciones basadas en herencia como el patron decorador ya que hoy en dia algunos lenguajes no soportan herencia.

 
````java
class BaseDeDatos {
    public void conectar() {
        System.out.println("Conectando a la base de datos...");
    }
}

class Aplicacion extends BaseDeDatos {
    public void iniciar() {
        conectar();
        System.out.println("Aplicación iniciada.");
    }
}
class AplicacionSimple {
    public void iniciar() {
        System.out.println("Aplicación simple iniciada.");
    }
}
 
✖️ Aunque se necesite los atributos de la base de datos, una aplicacion
   no es una Base de datos, cambios u errores en la logica de la clase
   padre se propagarán directamente a todas las clases hijas.
   ¿Que sucedera si tenemos que añadir una clase interfaz grafica?
   ¿hacer que extienda de nuevo de aplicacion? ¿ o de Base de datos ?
   es inestable.
````
 
````java
class BaseDeDatos {
    public void conectar() {
        System.out.println("Conectando a la base de datos...");
    }
}

class Aplicacion {
    private BaseDeDatos db = new BaseDeDatos();

    public void iniciar() {
        db.conectar();
        System.out.println("Aplicación iniciada.");
    }
}
class AplicacionSimple {
    public void iniciar() {
        System.out.println("Aplicación simple iniciada.");
    }
}
✔️ Una aplicacion no necesita de ser una base de datos, pero puede necesitarla, es por eso que
    hacemos que simplemente se componga o no de esta sin depender de herencia de esta manera tambien
    nos aseguramos que agregar componentes a la clase Aplicacion no sea mediante una jerarquia de clases.
````

------
## Creational Patterns
<div align="center"> 
<img src="https://github.com/Reistoge/DesignPatterns/blob/main/src/CreationalPatterns/CreationalPatterns.png?raw=true" width="600px" height="300px" alt="#  ">   
</div>
Patrones que proponen soluciones flexibles para la creación de objetos 

## When to use a creational pattern ?
_In situations related to object creation or instantiation mechanisms, aiming to abstract the process so that code is flexible, reusable, and decoupled from the specific classes it needs to instantiate._

## Factory Method
> _Establece la relacion de un Creador-Producto donde cada producto tiene su creador concreto, de esta manera podemos delegar gracias a un metodo abstracto la creacion concreta de cada producto concreto creando un producto sin la necesidad de especificar tu tipo concreto._
 
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
✖️ Drawing app se preoucupa de crear y mostrar las figuras, debe solamente mostrar. (SRP)
✖️ El usuario debe interectuar con una clase concreta en lugar de una interfaz 
✖️ dificil de mantener al momento de agregar o modificar una figura implica
tener que modificar la logica de la clase Draw la cual involucra otras figuras tambien (OCP).
````
### Solución 

<div align="center"> 
<img src="https://github.com/Reistoge/DesignPatterns/blob/main/src/CreationalPatterns/FactoryMethod/FactoryMethodUML.png?raw=true" alt="#  ">   
</div>

[Code](https://github.com/Reistoge/DesignPatterns/tree/main/src/CreationalPatterns/FactoryMethod/Solution)</br>
### Ventajas de esta estructura 
✔️ Agregar o modificar una figura no involucra codigo externo el cual no tiene relacion con la clase en si.
✔️ Definimos contratos concretos y estables para cada creador y figura, mantenible y seguro.
✔️ Estamos ocultando la creacion de cada Figura ya que el cliente interactua con un Creador no un producto concreto
 
## Abstract Factory
   
   > _Provides an interface for creating families of related objects without specifying their concrete classes_.<br/>
   > _Ofrece una interfaz para crear familias de objetos relacionados y sin especificar sus clases concretas_.
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
✖️ Agregar una consola o control implica modificar el codigo base
✖️ La clase no tiene una responsabilidad unica
✖️ La clase depende de clases concretas y no de abstracciones o interfaces.
````
### Solucion 
<div align="center"> 
<img src="https://github.com/Reistoge/DesignPatterns/blob/main/src/CreationalPatterns/AbstractFactory/AbstractFactory.drawio.png?raw=true" width="800px" height="500px" alt="#  ">
</div>

[Code](https://github.com/Reistoge/DesignPatterns/tree/main/src/CreationalPatterns/AbstractFactory)</br>
### Ventajas de esta estructura
✔️ Cliente interactua solo con las interfaces o abstracciones estables.</br>
✔️ Facilita la agregacion y mantencion a la hora de implementar nuevos tipos de controles, consolas e incluso otro tipo de productos.

#### Concrete Factories : ````NintendoFactory````,````MicrosoftFactory````,````SonyFactory````
#### Concrete Products A: ````NintendoSwitch````,````XboxSeriesX````,````Playstation5````
#### Concrete Products B: ````ProController````,````XboxController````,````DualShock5````

## Builder
> _Nos permite simplificar el constructor de un objeto cuando es complejo permitiendonos abstraer sus distintas formas de construccion simplificando las diferentes implementaciones de construcción del objeto._
 
### Example
Imagine a drawing application that needs to create different colored shapes (Red triangles, Blue circles, Green rectangles). Initially, the shapes are created directly in the client code:

````java
public class Personaje {
    private String nombre;
    private String dialogo;
    private String tipo;
    private String descripcion;
    private float nivel;
    private float peso;
    private float experiencia;
    private float ataque;
    private float defensa;
    private float velocidad;

    Personaje(String nombre, String dialogo, String tipo, String descripcion, float nivel, float peso, float experiencia, float ataque, float defensa, float velocidad) {
        this.nombre = nombre;
        this.dialogo = dialogo;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.nivel = nivel;
        this.peso = peso;
        this.experiencia = experiencia;
        this.ataque = ataque;
        this.defensa = defensa;
        this.velocidad = velocidad;
    }

    @Override
    public String toString() {
        return "nombre: "  + this.nombre + "\n"+
                "dialogo: "  + this.dialogo+ "\n"+
                "tipo: "  + this.tipo+ "\n"+
                "descripcion: "  + this.descripcion+ "\n"+
                "nivel: "  + this.nivel + "\n"+
                "peso: "  + this.peso+ "\n"+
                "experiencia: "  + this.experiencia+ "\n"+
                "ataque: "  + this.ataque+ "\n"+
                "defensa: "  + this.defensa + "\n"+
                "velocidad: "  + this.velocidad;
    }

    // ..... setters y getters

 
}
✖️ El constructor es muy complejo y esta saturado de parametros
✖️ Se necesita una manera de que construir este objeto sea más simple
✖️ Si buscamos combinaciones de constructores con distintos parametros,
 dejarlos vacios no es una solucion escalable y crear uno por uno tampoco.
````
### Solución 

<div align="center"> 
<img src="https://github.com/Reistoge/DesignPatterns/blob/main/src/CreationalPatterns/Builder/BuilderUML.png?raw=true" alt="#  ">   
</div>

[Code](https://github.com/Reistoge/DesignPatterns/tree/main/src/CreationalPatterns/FactoryMethod/Solution)</br>
### Ventajas de esta estructura 
✔️ Se simplifico la construccion del objeto ya que ahora puede ser inicializado con la combinacion de parametros que el cliente desee
✔️ Agregar un atributo a la construccion de un objeto es mucho más escalable y estable ya que no tenemos que preocuparnos de nuevas combinaciones.

-------

## Structural Patterns
<div align="center"> 
<img src="https://github.com/Reistoge/DesignPatterns/blob/main/src/StructuralPatterns/StructuralPatterns.png?raw=true" width="391px" height="292px" alt="#  ">   
</div>
Patrones que proponen soluciones flexibles para la composición de clases y objetos

## When to use a Structural pattern ?
_En situaciones las cuales involucren la encapsulacion de composicion de objetos o tambien dinamismo y flexibilidad en la composicion de un objeto como que sea sencillo sustituir la composicion de un objeto por otro._ 

## Proxy
> _Busca sustituir a un objeto (sujeto) y controlar su acceso mediante una clase que implemente la misma interfaz que el sujeto._
 
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
✖️ Existe un metodo de alto costo no controlado
    el cual además no necesita ser llamado todas las veces
````
### Solución 
<div align="center"> 
<img src="https://github.com/Reistoge/DesignPatterns/blob/main/src/StructuralPatterns/Proxy/ProxyUML.png?raw=true" width="500px" height="300px" alt="#  ">   
</div>

[Code](https://github.com/Reistoge/DesignPatterns/tree/main/src/StructuralPatterns/Proxy/Solution)</br>
### Ventajas de esta estructura 
✔️ Estamos controlando los contratos de concretos AssetLoader sin tener 
que modificar su codigo base de esta manera podemos ejecutar sus metodos
bajo las condiciones de AssetLoaderProxy ya que estas dos implementan una misma interfaz.
       
## Decorator
> _Se usa principalmente cuando queremos agregar o añadir nuevas funcionalidades a uno o varios tipos de componentes de manera dinamica._

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
### Solución
En este caso, queremos que un componente y sus ingredientes tengan
un precio price() y un display() en el programa. Debemos establecer 
esto porque, al decir esto, podemos crear una única interfaz tanto 
para el componente (Componente) como para los ingredientes (Decorador). 
Ahora comenzamos a implementar la estructura del decorador en nuestra solución.

1. Crear la interfaz **IComponent** o **AbstractComponent**
2. Crear una clase abstracta **Decorator**
3. Crear todos los componentes concretos y que la clase Decorator implemente la interfaz IComponent
4. Dentro de la clase Decorator, agregar un campo de tipo IComponent llamado "component"
y delegar cada llamada de los métodos de implementación al componente
(ej: dentro de method1() -> component.method1())
5. Crear una clase ConcreteDecorator que extienda de Decorator
y que sobrescriba cada llamada a un método llamando primero al mismo método de la superclase.
-----
## Behavioral Patterns
<div align="center"> 
<img src="https://github.com/Reistoge/DesignPatterns/blob/main/src/BehavioralPatterns/BehavioralPatterns.png?raw=true" alt="#  ">   
</div>
Patrones que proponen soluciones flexibles para la interacción y división de responsabilidades entre clases y objetos

## When to use a Behavioral pattern ?
_En situaciones las cuales involucren distribuir o controlar el procesamiento y algoritmos entre objetos o tambien cuando se busque especificar flujos y procesamientos dinamicos de un sistema de objetos._ 

## Visitor
> Permite la agregacion o construccion de nuevas operaciones y funcionalidades (visitores) que deben realizarse sobre los elementos de un conjunto de objetos (elementos) sin la necesidad de modificar su clase.

### Ejemplo
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
✖️ No se esta ocultando correctamente la informacion de cada elemento y
   además siempre que tengamos que agregar una funcionalidad u operación
   tendremos que modificar el codigo base de Artwork el cual involucra
   todos los demas elementos innecesariamente
   
````
### Solución 
1. Crear una interfaz para los elementos que se le aplicara una logica (IElement) y el visitante que aplica la logica a los elementos (IVisitor)
2. Para la interfaz del visitante:
    1. Nuestra interfaz debe ser **capaz** de que en un solo metodo pueda 
       aceptar y aplicar una logica distinta sobre IElementos concretos es por eso que se debemos **añadir
       el mismo metodo accept()** pero soportado para **diferentes parametros** que seria 
       cada tipo concreto de elementos.
       ````java
       accept(C1 elemento1);
       accept(C2 elemento2);
       accept(C3 elemento3);
       ````
           
3. Para la interfaz de Elemento:
   1. añadir un metodo
   ````java
    visit(IVisitor v);
   ````
   3. dentro de cada elemento concreto es importante que dentro del cuerpo de la funcion este implementado de esta forma
   ````java
    v.visit(this)
   ````
      
   
<div align="center"> 
<img src="https://github.com/Reistoge/DesignPatterns/blob/main/src/BehavioralPatterns/Visitor/VisitorUML.png?raw=true"  alt="#  ">   
</div>

[Code](https://github.com/Reistoge/DesignPatterns/tree/main/src/BehavioralPatterns/Visitor/Solution)</br>
### Ventajas de esta estructura 
✔️ Gracias a la estructura de este patron cada tipo de elemento se redirigira automaticamente al visitor ejecutando su metodo de tipo correspondiente, de esta  manera cuando tengamos que añadir una funcionalidad para los elementos debemos simplemente crear una clase cual implemente la interfaz visitor e ir a añadiendo la nueva funcionalidad para cada elemento por separado.

### Detalle
😔 El patron visitor por otro lado tiene una gran desventaja y es cuando nosotros necesitemos agregar nuevos elementos a nuestra estructura ya que supondrá  modificar la interfaz visitor y a todas sus implementaciones (acoplamiento evolutivo).

## Observer
> Permite definir mecanismos suscripcion dinamicos para notificar eventos a multiples objetos los cuales observan o escuchan a un Sujeto    

### Ejemplo
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
✖️ Modificar o añadir una logica especifica a un observador implica cambiar la logica dentro
de donde se notifica a todos los demas, no se respeta SRP.
✖️ No hay una definicion de contratos o una definicion concreta para cada tipo de observador


   
````
### Solución 
<div align="center"> 
<img src="https://github.com/Reistoge/DesignPatterns/blob/main/src/BehavioralPatterns/Observer/ObserverUML.png?raw=true"  alt="#  ">   
</div>

[Code](https://github.com/Reistoge/DesignPatterns/tree/main/src/BehavioralPatterns/Observer/Solution)</br>
### Ventajas de esta estructura 
✔️ Podemos añadir observadores y sujetos sin la necesidad de modificar o alterar la logica base (Acoplamiento)</br>
✔️ Podemos añadir o modificar la logica especifica a cada observador en la manera que es actualizado y como notifica cada sujeto a sus observadores (encapsulamiento).</br>
✔️ Gracias a esta estructura es mucho más simple y mantenible hacer combinaciones entre sujetos y observadores ya que se comunican mediante una interfaz.(integridad conceptual)</br>

## Template Method
> Permite definir el esqueleto o plantilla de un algoritmo el cual además se compone de procesos abstractos los cuales apliquen una logica distinta.  

### Ejemplo
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
✖️ Cada vez que añadamos un proceso nuevo tendremos que volver a escribir el codigo plantilla (acoplamiento no aceptable)
✖️ Si tenemos muchos procesos y decidimos cambiar el codigo plantilla romperiamos con
la estructura de nuestro sistema, teniendo que ir a actualizar cada proceso concreto (acoplamiento evolutivo, OCP)


   
````
### Solución 
<div align="center"> 
<img src="https://github.com/Reistoge/DesignPatterns/blob/main/src/BehavioralPatterns/TemplateMethod/TemplateMethodUML.png?raw=true"  alt="#  ">   
</div>

[Code](https://github.com/Reistoge/DesignPatterns/tree/main/src/BehavioralPatterns/TemplateMethod/Solution)</br>
### Ventajas de esta estructura 
✔️ No tenemos que estar reescribiendo la formula cada vez que creamos un proceso nuevo.</br>
✔️ Ahora es más escalable debido a que si queremos cambiar la formula base tenemos que simplemente cambiar la dentro del metodo ````templateMethod()````.</br>
✔️ Cada proceso esta encapsulado y oculta su informacion tanto de atributos como de metodos de una manera la cual puedan modificarse sin tener que alterar la estructura general.</br>

## Strategy
> Nos permite definir una estrucutra el cual seleccionar en tiempo de ejecucion que tipo de algoritmo se ejecutara para un proceso concreto.   

### Ejemplo
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
✖️ La logica de cada algoritmo no esta encapsulada, debemos modificar
la estructura general siempre que queramos modificar cualquiera de los algoritmos
✖️ Cuando queramos asociar un tipo de algoritmo especifico a una
entidad o objeto esta estructura se ira volviendo cada vez más inestable.


   
````
### Solución 
<div align="center"> 
<img src="https://github.com/Reistoge/DesignPatterns/blob/main/src/BehavioralPatterns/TemplateMethod/TemplateMethodUML.png?raw=true"  alt="#  ">   
</div>

[Code](https://github.com/Reistoge/DesignPatterns/tree/main/src/BehavioralPatterns/TemplateMethod/Solution)</br>
### Ventajas de esta estructura 
✔️  Cada logica concreta esta encapsulada ocultando la informacion de sus metodos y atributos especificos lo que modificarla no altera la estructura general.</br>
✔️  Debido a que esta estructura maneja cada algoritmo concreto como una entidad, podemos asociar estos algoritmos a otros tipos de entidades de manera escalable.</br>


 
