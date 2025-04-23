
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

### 1. Abstract Factory
   
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
## Solucion 
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
-------

## Structural Patterns
<div align="center"> 
<img src="https://github.com/Reistoge/DesignPatterns/blob/main/src/StructuralPatterns/StructuralPatterns.png?raw=true" width="391px" height="292px" alt="#  ">   
</div>
Patrones que proponen soluciones flexibles para la composición de clases y objetos

## When to use a Structural pattern ?
_En situaciones las cuales involucren la encapsulacion de composicion de objetos o tambien dinamismo y flexibilidad en la composicion de un objeto como que sea sencillo sustituir la composicion de un objeto por otro._ 

### Proxy
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
## Solución 
<div align="center"> 
<img src="https://github.com/Reistoge/DesignPatterns/blob/main/src/StructuralPatterns/Proxy/ProxyUML.png?raw=true" width="500px" height="300px" alt="#  ">   
</div>

[Code](https://github.com/Reistoge/DesignPatterns/tree/main/src/StructuralPatterns/Proxy/Solution)</br>
### Ventajas de esta estructura 
✔️ Estamos controlando los contratos de concretos AssetLoader sin tener 
que modificar su codigo base de esta manera podemos ejecutar sus metodos
bajo las condiciones de AssetLoaderProxy ya que estas dos implementan una misma interfaz.
       

-----
## Behavioral Patterns
<div align="center"> 
<img src="https://github.com/Reistoge/DesignPatterns/blob/main/src/BehavioralPatterns/BehavioralPatterns.png?raw=true" alt="#  ">   
</div>
Patrones que proponen soluciones flexibles para la interacción y división de responsabilidades entre clases y objetos

## When to use a Behavioral pattern ?
_En situaciones las cuales involucren distribuir o controlar el procesamiento y algoritmos entre objetos o tambien cuando se busque especificar flujos y procesamientos dinamicos de un sistema de objetos._ 

### Visitor
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
## Solución 
<div align="center"> 
<img src="https://github.com/Reistoge/DesignPatterns/blob/main/src/BehavioralPatterns/Visitor/VisitorUML.png?raw=true"  alt="#  ">   
</div>

[Code](https://github.com/Reistoge/DesignPatterns/tree/main/src/BehavioralPatterns/Visitor/Solution)</br>
### Ventajas de esta estructura 
✔️ Gracias a la estructura de este patron cada tipo de elemento se redirigira automaticamente al visitor ejecutando su metodo de tipo correspondiente, de esta  manera cuando tengamos que añadir una funcionalidad para los elementos debemos simplemente crear una clase cual implemente la interfaz visitor e ir a añadiendo la nueva funcionalidad para cada elemento por separado.

### Detalle
😔 El patron visitor por otro lado tiene una gran desventaja y es cuando nosotros necesitemos agregar nuevos elementos a nuestra estructura ya que supondrá  modificar la interfaz visitor y a todas sus implementaciones (acoplamiento evolutivo).
 

 
