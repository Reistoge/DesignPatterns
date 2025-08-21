
[Español](README_ES.md) | [English](README.md)
# Patrones y Principios de Software 🦔

## Resumen
Este repositorio fue creado con fines de aprendizaje y educativos. También está destinado a recopilar los 23 patrones de diseño GOF

## Índice
 * [Principios de Diseño](#principios-de-diseño)
 * [Propiedades de Diseño](#propiedades-de-diseño)
    * [Integridad Conceptual](#integridad-conceptual)
    * [Ocultamiento de Información](#ocultamiento-de-información)
    * [Cohesión](#cohesión)
    * [Acoplamiento](#acoplamiento)
 * [Principios SOLID y Otros](#principios-solid-y-otros)
    * [Responsabilidad Única](#responsabilidad-única-cohesión)
    * [Abierto-Cerrado](#abierto-cerrado-extensión)
    * [Sustitución de Liskov](#sustitución-de-liskov-extensión)
    * [Segregación de Interfaces](#segregación-de-interfaces-cohesión)
    * [Inversión de Dependencias](#inversión-de-dependencias-acoplamiento)
    * [Principio de Menor Privilegio](#principio-de-menor-privilegio)
    * [Composición sobre Herencia](#composición-sobre-herencia)
 * [Patrones Creacionales](#patrones-creacionales)
    * [Singleton](#singleton)
    * [Factory Method](#factory-method)
    * [Abstract Factory](#abstract-factory)
    * [Builder](#builder)
 
 * [Patrones Estructurales](#patrones-estructurales) 
    * [Proxy](#proxy)
    * [Decorator](#decorator)
    * [Adapter](#adapter)
    * [Facade](#facade)
 * [Patrones de Comportamiento](#patrones-de-comportamiento)
    * [Observer](#observer)
    * [Strategy](#strategy)
    * [Template Method](#template-method)
    * [Visitor](#visitor)
------

## Principios de Diseño

Los principios de diseño representan directrices o recomendaciones genéricas para garantizar que un diseño cumple con determinadas ````propiedades```` que nos permiten entender y desarrollar sistemas de mayor calidad.
 
## Propiedades de Diseño
### Integridad Conceptual
````Definición````: _Un sistema no puede ser una acumulación de funcionalidades sin coherencia ni cohesión entre ellas._ </br></br>
La integridad conceptual define estándares, convenciones y brinda consistencia al diseño de componentes y al desarrollo de un sistema, por lo tanto es de gran utilidad cuando buscamos facilitar el uso y la comprensión de un sistema por parte de sus usuarios.</br>

Para seguir este principio se debe considerar:
  *  Definir una convención de código (ej; camelCase, snake_case)
  *  Definir el diseño estándar para los componentes (ej: estructuras de datos que se usarán)
  *  Definir principios de diseño a seguir a lo largo del desarrollo.</br>

Casos en los cuales un sistema no sigue este principio:
 * Se usan distintas versiones de un Framework
 * Se resuelve un mismo tipo de problema usando otro tipo de estructuras de datos
 * Existen distintas convenciones de código
 

### Ocultamiento de Información
````Definición````: _Las clases deben ocultar detalles de implementación que estén sujetos a cambios._ </br></br>
Encapsular u ocultar toda la información tampoco es una solución, debemos también hacer públicos algunos detalles como los métodos para que nuestra clase sea útil y pueda comunicarse. Los métodos públicos de una clase definen su interfaz y constituyen su parte ````visible```` para el resto de clases y código externo, es por esto que debemos elaborar `````interfaces estables`````, esto se logra definiendo correctamente qué métodos serán tanto públicos como privados dentro de nuestra clase.</br>

Gracias a este principio podemos:
 * Implementar sistemas en desarrollo paralelo mucho más rápido y fácil de entender entre desarrolladores.
 * Hace que un sistema sea más flexible ante cambios eliminando el riesgo de que un componente afecte a todo el sistema
 * Facilita la comprensión en un sistema gracias a las interfaces.

 
 ### Cohesión
 ````Definición````: _Una clase debe tener una única responsabilidad e implementar un único interés para que de esta forma tenga un solo motivo para ser modificada._  </br></br>
Una clase que siga este principio es considerada una clase ````cohesiva```` </br>
Este principio nos permite:
* Implementar, comprender y mantener clases más fácilmente
* Facilita la asignación de responsabilidad única a las clases. 
* Facilita la reutilización y el testing de clases en el sistema.  
 
 ### Acoplamiento
 ````Definición````: Mide la fuerza de conexión o dependencia entre clases   
 Tipos de acoplamiento:
  * Aceptable: Cuando una clase A solo usa métodos públicos o la interfaz de B
  * No aceptable: Cuando cambios en una clase A impactan fácilmente a una clase B
  * Evolutivo: Ocurre cuando los cambios en una clase B tienden a propagarse a una A o alguna otra clase de manera inesperada (tiende a ser no aceptable)
  * Estructural: Cuando una clase A tiene una referencia explícita en su código a una clase B (puede ser aceptable o no)

**¿Cómo evitar un acoplamiento no aceptable?**: Maximizando la cohesión y minimizando la fuerza de conexión entre clases, esto involucra interfaces estables en las dependencias. 

Con esto no se busca eliminar el acoplamiento de una clase con otra, no hay problema en que una clase necesite de otras, especialmente de aquellas que usen servicios como estructura de datos, input u output, etc.
 
 ------
## Principios SOLID y Otros

</br>
Recomendaciones a nivel práctico que permiten a los desarrolladores seguir las propiedades de diseño, debido a esto cada principio está ligado a una propiedad de diseño.

### **S**ingle Responsibility (Cohesión):
 Directamente ligada con la propiedad de cohesión y nos dice que una clase debe tener una única responsabilidad y un único motivo para ser modificada.
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

✔️ Delegando las responsabilidades en distintas clases obtenemos clases con responsabilidades únicas
````
 ----
### **O**pen-Closed (Extensión):
Una clase debe estar cerrada a modificación pero abierta a extensión, en otras palabras, tu clase debe tener la capacidad de poder agregar cosas pero sin tener que modificar la lógica base de esta.
### Ejemplo
````java
class Descuento {
    public double aplicar(double precio, String tipo) {
        if (tipo.equals("Navidad")) return precio * 0.9;
        else return precio;
    }
}

✖️ Si queremos agregar otro tipo de descuento tendremos que
   cambiar directamente la lógica del método aplicar().
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
### **L**iskov Substitution (Extensión):
Todos los métodos sobrescritos en una subclase deben seguir la misma lógica o funcionalidad que el método original de la superclase.
Este principio nos permite separar y definir una buena jerarquía entre clases padres e hijas.

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
   problemas de implementación o contrato 
````
-------
### **I**nterface Segregation (Cohesión):
No se debe forzar a implementar métodos innecesarios, las interfaces deben ser simples, pequeñas, cohesionadas y los contratos deben ser estables y específicos para cada cliente. 
Digamos que distintos tipos de clientes usan solamente una parte de la implementación de una clase o interfaz, para esto es mejor la división de interfaces complejas hacia más específicas y pequeñas, de esta forma hacemos que un cliente concreto tenga que interactuar con una interfaz concreta 
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
    implementaciones de Multifuncional el método imprimir() o escanear() será inútil.
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

✔️ Se crea una interfaz para cada método y funcionalidad específica, ahora las
    clases de Impresoras las cuales solo puedan imprimir, imprimir y escanear o solo escanear
    tendrán que solamente implementar las interfaces necesarias sin que alguna tenga
    métodos vacíos o innecesarios. 
````
-------
### **D**ependency Inversion (Acoplamiento):
Este principio nos dice que prefiramos interfaces frente a clases concretas ya que las interfaces son más estables. Para lograr esto debemos intercambiar las dependencias de clases concretas del cliente por interfaces o abstracciones, de esta manera mantenemos una dependencia estable entre la abstracción y el cliente.
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

✔️ Se intercambió la dependencia concreta en Auto y ahora
    depende de una interfaz, en caso de que se crearan o cambien
    distintas implementaciones de Motor no habrá problemas en
    Auto ya que esta depende solo de los contratos de la interfaz
    (acoplamiento estructural deseado).
````
----
### Principio de Menor Privilegio 
El principio de menor privilegio o Demeter brinda un conjunto de reglas para evitar problemas de encapsulamiento.
Sostiene que la implementación de un método en una clase debe solo invocar los siguientes otros métodos:

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
✔️ Creamos un método específico en A el cual encapsula la lógica en
    cómo se tiene que devolver el valor que queremos sin tener que
    depender o hacer llamadas directas del objeto Y.
````
-----
### Composición sobre Herencia 
Una solución basada en composición suele ser en la mayoría de los casos mejor que una basada en herencia.
¿Por qué?
La herencia viola el encapsulamiento de las clases padre. La implementación de las subclases se vuelve tan acoplada a la implementación de la clase padre que cualquier cambio en estas últimas puede forzar modificaciones en las subclases.

Debido a esto existen soluciones basadas en composición las cuales tienen como objetivo reemplazar las soluciones basadas en herencia como el patrón decorador ya que hoy en día algunos lenguajes no soportan herencia.

 
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
 
✖️ Aunque se necesiten los atributos de la base de datos, una aplicación
   no es una Base de datos, cambios u errores en la lógica de la clase
   padre se propagarán directamente a todas las clases hijas.
   ¿Qué sucederá si tenemos que añadir una clase interfaz gráfica?
   ¿hacer que extienda de nuevo de aplicación? ¿o de Base de datos?
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
✔️ Una aplicación no necesita ser una base de datos, pero puede necesitarla, es por eso que
    hacemos que simplemente se componga o no de esta sin depender de herencia de esta manera también
    nos aseguramos que agregar componentes a la clase Aplicación no sea mediante una jerarquía de clases.
````

------
## Patrones Creacionales
<div align="center"> 
<img src="https://github.com/Reistoge/DesignPatterns/blob/main/src/CreationalPatterns/CreationalPatterns.png?raw=true" width="600px" height="300px" alt="#  ">   
</div>
Patrones que proponen soluciones flexibles para la creación de objetos 

## ¿Cuándo usar un patrón creacional?
_En situaciones relacionadas con mecanismos de creación o instanciación de objetos, con el objetivo de abstraer el proceso para que el código sea flexible, reutilizable y desacoplado de las clases específicas que necesita instanciar._

## Singleton
> _Este patrón nos asegura que exista una instancia única de una clase y además que sea accesible desde cualquier parte de nuestro sistema._

### Ejemplo
Consideremos un contexto de administrador de configuraciones de juego
donde necesitamos mantener configuraciones consistentes
a través de todo el juego


````java
public class ConfiguracionesJuego {
    private int volumen;
    private boolean pantallaCompleta;
    private int dificultad;

    public ConfiguracionesJuego() {
        // Configuraciones por defecto
        volumen = 50;
        pantallaCompleta = false;
        dificultad = 1;
    }

    // Getters y setters
    public void setVolumen(int volumen) { this.volumen = volumen; }
    public int getVolumen() { return volumen; }
    public void setPantallaCompleta(boolean pantallaCompleta) { this.pantallaCompleta = pantallaCompleta; }
    public boolean isPantallaCompleta() { return pantallaCompleta; }
    public void setDificultad(int dificultad) { this.dificultad = dificultad; }
    public int getDificultad() { return dificultad; }
}

// Uso en diferentes clases
class ManagerAudio {
    private ConfiguracionesJuego configuraciones = new ConfiguracionesJuego();
    public void reproducirSonido() {
        // Usa su propia instancia de configuraciones
        int volumen = configuraciones.getVolumen();
    }
}

class ManagerPantalla {
    private ConfiguracionesJuego configuraciones = new ConfiguracionesJuego();
    public void actualizarPantalla() {
        // Usa una instancia diferente de configuraciones
        boolean pantallaCompleta = configuraciones.isPantallaCompleta();
    }
}
✖️ Múltiples clases crean sus propias instancias de configuracionesJuego esto puede llevar a inconsistencias de datos.
✖️ No es necesario tener que volver a inicializar los datos cada vez que se necesiten por alguna otra clase.

 
````
### Solución 

<div align="center"> 
<img src="https://github.com/Reistoge/DesignPatterns/blob/main/src/CreationalPatterns/Singleton/SingletonUML.png?raw=true" alt="#  ">   
</div>

[Código](https://github.com/Reistoge/DesignPatterns/tree/main/src/CreationalPatterns/Singleton/Solution)</br>
### Ventajas de esta estructura 
✔️ Los datos se inicializan una sola vez o cuando sea necesario.</br>
✔️ Hay una mejor consistencia de datos ya que existe una única fuente de donde consultarlos y acceder a ellos.
 

## Factory Method
> _Establece la relación de un Creador-Producto donde cada producto tiene su creador concreto, de esta manera podemos delegar gracias a un método abstracto la creación concreta de cada producto concreto creando un producto sin la necesidad de especificar su tipo concreto._
 
### Ejemplo
Imagina una aplicación de dibujo que necesita crear diferentes formas de colores (triángulos rojos, círculos azules, rectángulos verdes). Inicialmente, las formas se crean directamente en el código del cliente:

````java
public class Forma {
    private String nombre;
    private String forma;
    private String color;

    public Forma(String nombre, String forma, String color) {
        this.nombre = nombre;
        this.forma = forma;
        this.color = color;
    }

    public void dibujar() {
        System.out.println("Dibujando " + color + " " + forma + ": " + nombre);
    }
}

public class AppDibujo {
    public static void main(String[] args) {
        // El código del cliente crea formas directamente
        Forma trianguloRojo = new Forma("Rojo1", "Triángulo", "Rojo");
        Forma circuloAzul = new Forma("Azul1", "Círculo", "Azul");
        Forma rectanguloVerde = new Forma("Verde1", "Rectángulo", "Verde");
        
        // Lógica de creación compleja dispersa en el código del cliente
        if(necesitaFormaRoja()) {
            trianguloRojo.dibujar();
        } else if(necesitaFormaAzul()) {
            circuloAzul.dibujar();
        } else {
            rectanguloVerde.dibujar();
        }
    }
}
✖️ La app de dibujo se preocupa de crear y mostrar las figuras, debe solamente mostrar. (SRP)
✖️ El usuario debe interactuar con una clase concreta en lugar de una interfaz 
✖️ difícil de mantener al momento de agregar o modificar una figura implica
tener que modificar la lógica de la clase Dibujo la cual involucra otras figuras también (OCP).
````
### Solución 

<div align="center"> 
<img src="https://github.com/Reistoge/DesignPatterns/blob/main/src/CreationalPatterns/FactoryMethod/FactoryMethodUML.png?raw=true" alt="#  ">   
</div>

[Código](https://github.com/Reistoge/DesignPatterns/tree/main/src/CreationalPatterns/FactoryMethod/Solution)</br>
### Ventajas de esta estructura 
✔️ Agregar o modificar una figura no involucra código externo el cual no tiene relación con la clase en sí.</br>
✔️ Definimos contratos concretos y estables para cada creador y figura, mantenible y seguro.</br>
✔️ Estamos ocultando la creación de cada Forma ya que el cliente interactúa con un Creador no un producto concreto</br>
 
## Abstract Factory
   
   > _Proporciona una interfaz para crear familias de objetos relacionados sin especificar sus clases concretas_.<br/>
   > _Ofrece una interfaz para crear familias de objetos relacionados sin especificar sus clases concretas_.
  <div align="center"  > <img src="https://github.com/Reistoge/DesignPatterns/blob/main/src/CreationalPatterns/AbstractFactory/dpcs_af-432075449.png?raw=true"   alt="#  ">  </div>

### Ejemplo:
Una tienda de videojuegos necesita un sistema para gestionar su inventario de consolas de juegos y controles.
Inicialmente, tenían una estructura simple y estrechamente acoplada
````java
public class TiendaVideojuegos {
    public Consola crearConsola(String marca) {
        if (marca.equals("Sony")) {
            return new PlayStation5();
        } else if (marca.equals("Microsoft")) {
            return new XboxSeriesX();
        } else if (marca.equals("Nintendo")) {
            return new NintendoSwitch();
        }
        throw new IllegalArgumentException("Marca desconocida");
    }

    public Control crearControl(String marca) {
        if (marca.equals("Sony")) {
            return new DualShock5();
        } else if (marca.equals("Microsoft")) {
            return new ControlXbox();
        } else if (marca.equals("Nintendo")) {
            return new ControlPro();
        }
        throw new IllegalArgumentException("Marca desconocida");
    }
}
✖️ Agregar una consola o control implica modificar el código base
✖️ La clase no tiene una responsabilidad única
✖️ La clase depende de clases concretas y no de abstracciones o interfaces.
````
### Solución 
<div align="center"> 
<img src="https://github.com/Reistoge/DesignPatterns/blob/main/src/CreationalPatterns/AbstractFactory/AbstractFactory.drawio.png?raw=true" width="800px" height="500px" alt="#  ">
</div>

[Código](https://github.com/Reistoge/DesignPatterns/tree/main/src/CreationalPatterns/AbstractFactory)</br>
### Ventajas de esta estructura
✔️ Cliente interactúa solo con las interfaces o abstracciones estables.</br>
✔️ Facilita la agregación y mantención a la hora de implementar nuevos tipos de controles, consolas e incluso otro tipo de productos.

#### Fábricas Concretas : ````FabricaNintendo````,````FabricaMicrosoft````,````FabricaSony````
#### Productos Concretos A: ````NintendoSwitch````,````XboxSeriesX````,````Playstation5````
#### Productos Concretos B: ````ControlPro````,````ControlXbox````,````DualShock5````

## Builder
> _Nos permite simplificar el constructor de un objeto cuando es complejo permitiéndonos abstraer sus distintas formas de construcción simplificando las diferentes implementaciones de construcción del objeto._
 
### Ejemplo
Imagina una aplicación de dibujo que necesita crear diferentes formas de colores (triángulos rojos, círculos azules, rectángulos verdes). Inicialmente, las formas se crean directamente en el código del cliente:

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
✖️ El constructor es muy complejo y está saturado de parámetros
✖️ Se necesita una manera de que construir este objeto sea más simple
✖️ Si buscamos combinaciones de constructores con distintos parámetros,
 dejarlos vacíos no es una solución escalable y crear uno por uno tampoco.
````
### Solución 

<div align="center"> 
<img src="https://github.com/Reistoge/DesignPatterns/blob/main/src/CreationalPatterns/Builder/BuilderUML.png?raw=true" alt="#  ">   
</div>

[Código](https://github.com/Reistoge/DesignPatterns/tree/main/src/CreationalPatterns/FactoryMethod/Solution)</br>
### Ventajas de esta estructura 
✔️ Se simplificó la construcción del objeto ya que ahora puede ser inicializado con la combinación de parámetros que el cliente desee.</br>
✔️ Agregar un atributo a la construcción de un objeto es mucho más escalable y estable ya que no tenemos que preocuparnos de nuevas combinaciones.

-------

## Patrones Estructurales
<div align="center"> 
<img src="https://github.com/Reistoge/DesignPatterns/blob/main/src/StructuralPatterns/StructuralPatterns.png?raw=true" width="391px" height="292px" alt="#  ">   
</div>
Patrones que proponen soluciones flexibles para la composición de clases y objetos

## ¿Cuándo usar un patrón Estructural?
_En situaciones las cuales involucren la encapsulación de composición de objetos o también dinamismo y flexibilidad en la composición de un objeto como que sea sencillo sustituir la composición de un objeto por otro._ 

## Proxy
> _Busca sustituir a un objeto (sujeto) y controlar su acceso mediante una clase que implemente la misma interfaz que el sujeto._
 
### Ejemplo
Necesitas mostrar una vista previa de un recurso (tal vez una miniatura o un nombre),
pero solo cargar la imagen real cuando el usuario quiera usarla porque
estos recursos son grandes y están almacenados remotamente (en almacenamiento en la nube o en disco),
y cargarlos todos a la vez es demasiado costoso en memoria y tiempo.

````java
public class CargadorRecursoSimple {
    private List<String> recursos = new ArrayList<>();

    public String cargarRecurso(String nombre) {
        // Siempre realiza procesamiento costoso
        String recursoProcesado = procesarRecurso(nombre);
        recursos.add(recursoProcesado);
        return recursoProcesado;
    }

    public void mostrarRecurso(String nombre) {
        // Siempre carga y procesa el recurso
        String recurso = cargarRecurso(nombre);
        System.out.println("Mostrando recurso: " + recurso);
    }

    private String procesarRecurso(String nombre) {
        // Simula procesamiento costoso
        return nombre.toUpperCase() + ".PROCESADO";
    }
}
✖️ Existe un método de alto costo no controlado
    el cual además no necesita ser llamado todas las veces
````
### Solución 
<div align="center"> 
<img src="https://github.com/Reistoge/DesignPatterns/blob/main/src/StructuralPatterns/Proxy/ProxyUML.png?raw=true" width="500px" height="300px" alt="#  ">   
</div>

[Código](https://github.com/Reistoge/DesignPatterns/tree/main/src/StructuralPatterns/Proxy/Solution)</br>
### Ventajas de esta estructura 
✔️ Estamos controlando los contratos de CargadorRecurso concreto sin tener 
que modificar su código base de esta manera podemos ejecutar sus métodos
bajo las condiciones de CargadorRecursoProxy ya que estas dos implementan una misma interfaz.
       
## Decorator
> _Se usa principalmente cuando queremos agregar o añadir nuevas funcionalidades a uno o varios tipos de componentes de manera dinámica._

### Ejemplo
Un pequeño carrito de comida vende Completos Chilenos (hot dogs)
y necesita calcular precios para diferentes combinaciones.
Inicialmente, lo manejan con una sola clase.

````java
public class CompletoChileno {
    private boolean tienePalta;
    private boolean tieneMayo;
    private boolean tieneKetchup;
    private boolean esKetchupLight;
    private String tipoVienesa; // normal, premium, veggie

    public CompletoChileno() {
        this.tipoVienesa = "normal";
    }

    public float calcularPrecio() {
        float precioBase = 2.0f; // precio base del completo

        // Agregar precios de ingredientes
        if (tienePalta) {
            precioBase += 0.5f;
        }
        if (tieneMayo) {
            precioBase += 0.2f;
        }
        if (tieneKetchup) {
            precioBase += esKetchupLight ? 0.3f : 0.1f;
        }

        // Calcular precio de vienesa
        switch (tipoVienesa.toLowerCase()) {
            case "premium":
                precioBase += 2.0f;
                break;
            case "veggie":
                precioBase += 3.0f;
                break;
        }

        return precioBase;
    }

    public void mostrarCompleto() {
        System.out.println("Completo Chileno con:");
        System.out.println("- Tipo de vienesa: " + tipoVienesa);
        if (tienePalta) System.out.println("- Palta");
        if (tieneMayo) System.out.println("- Mayo");
        if (tieneKetchup) System.out.println("- Ketchup" + (esKetchupLight ? " (light)" : ""));
        System.out.println("Precio total: " + calcularPrecio());
    }

    // Setters
    public void agregarPalta() { this.tienePalta = true; }
    public void agregarMayo() { this.tieneMayo = true; }
    public void agregarKetchup(boolean light) {
        this.tieneKetchup = true;
        this.esKetchupLight = light;
    }
    public void setTipoVienesa(String tipo) { this.tipoVienesa = tipo; }
}
````
### Solución
<div align="center"> 
<img src="https://github.com/Reistoge/DesignPatterns/blob/main/src/StructuralPatterns/Decorator/DecoratorUML.png?raw=true"  alt="#  ">   
</div>

[Código](https://github.com/Reistoge/DesignPatterns/tree/main/src/StructuralPatterns/Decorator/Solution)</br>
En este caso, queremos que un componente y sus ingredientes tengan
un precio() y un mostrar() en el programa. Debemos establecer 
esto porque, al decir esto, podemos crear una única interfaz tanto 
para el componente (Componente) como para los ingredientes (Decorador). 
Ahora comenzamos a implementar la estructura del decorador en nuestra solución.

1. Crear la interfaz **IComponente** o **ComponenteAbstracto**
2. Crear una clase abstracta **Decorador**
3. Crear todos los componentes concretos y que la clase Decorador implemente la interfaz IComponente
4. Dentro de la clase Decorador, agregar un campo de tipo IComponente llamado "componente"
y delegar cada llamada de los métodos de implementación al componente
(ej: dentro de metodo1() -> componente.metodo1())
5. Crear una clase DecoradorConcreto que extienda de Decorador
y que sobrescriba cada llamada a un método llamando primero al mismo método de la superclase.

## Adapter
> _Nos provee de una interfaz intermediaria para que una clase la cual sea incompatible pueda integrarse a nuestra estructura sin modificar el código original_.  
 
### Ejemplo
Tu aplicación fue inicialmente construida para trabajar con ServicioClimaA,
pero ahora necesitas integrar ServicioClimaB, que usa
una interfaz totalmente diferente. Tu objetivo es hacer
que ambos trabajen sin cambiar el código original del cliente
que espera ServicioClimaA.
````java
public class OpenWeatherA implements ServicioClimaA{
    @Override
    public String getTemperaturaEnCelsius(String ciudad) {
        return "25ºc en " + ciudad;
    }
}
public interface ServicioClimaA {
    String getTemperaturaEnCelsius(String ciudad);
}
// Nueva librería de terceros que necesitas integrar (no puedes modificar esta clase)
public class ServicioClimaB {
    public double getTempFahrenheit(String ubicacion) {
        // Simula una API externa que solo devuelve Fahrenheit
        return 77.0;
    }
}

````
### Solución 

<div align="center"> 
<img src="https://github.com/Reistoge/DesignPatterns/blob/main/src/StructuralPatterns/Adapter/AdapterUML.png?raw=true" alt="#  ">   
</div>

[Código](https://github.com/Reistoge/DesignPatterns/tree/main/src/StructuralPatterns/Adapter/Solution)</br>
### Ventajas de esta estructura 
✔️ Mediante Inversión de dependencias y segregación de interfaces 
logramos compatibilizar funcionalidades a nuestro sistema creando
una interfaz sin alterar el código original.</br>

-----
## Facade
> _Nos provee de una clase o interfaz la cual busca simplificar el uso de múltiples subsistemas de manera específica o compleja en una sola interfaz la cual sea más simple trabajar con este conjunto_.  
 
### Ejemplo
Estás construyendo un sistema reproductor de medios, para reproducir una canción tienes que manualmente
decodificar, almacenar en buffer esto crea un acoplamiento estrecho entre la lógica de aplicación de alto nivel
y los subsistemas de bajo nivel.

 
````java
public class BufferAudio {
    public void cargarBuffer(String rutaArchivo) {
        System.out.println("Cargando buffer del archivo de audio: " + rutaArchivo);
    }
}
public class DecodificadorAudio {
    public void decodificar(String rutaArchivo) {
        System.out.println("Decodificando archivo de audio: " + rutaArchivo);
    }
}
public class DriverAudio {
    public void reproducirSonido() {
        System.out.println("Reproduciendo sonido a través del driver de audio");
    }
}
public class ReproductorMedia {

    public void encenderReproductorMedia() {
        String cancion = "cancion.mp3";

        DecodificadorAudio decodificador = new DecodificadorAudio();
        decodificador.decodificar(cancion);

        BufferAudio buffer = new BufferAudio();
        buffer.cargarBuffer(cancion);

        DriverAudio driver = new DriverAudio();
        driver.reproducirSonido();
    }
}
✖️ Para un método estamos invocando directamente muchos subsistemas como si de una plantilla o inicialización se tratase, a medida que nuestro código vaya creciendo esto cada vez será más complejo de entender.
✖️ No es necesario tener que inicializar de nuevo los componentes cada vez que se llame este método ya que no es parte de la construcción de este.
✖️ Si la inicialización de un subsistema es muy compleja el código será muy difícil de entender y nuestra clase tendrá más razones para ser modificada. 
````
### Solución 
En lugar de usar N subsistemas o interfaces concretos en el mismo código de cliente, se crea una clase "Fachada" que proporciona una interfaz simplificada a los subsistemas. De esta manera, se reduce la complejidad del código de cliente, de modo que el cliente solo llama a los métodos de la fachada, y esta se encarga de llamar a los subsistemas.

<div align="center"> 
<img src="https://github.com/Reistoge/DesignPatterns/blob/main/src/StructuralPatterns/Facade/FacadeUML.png?raw=true" alt="#  ">   
</div>

[Código](https://github.com/Reistoge/DesignPatterns/tree/main/src/StructuralPatterns/Facade/Solution)</br>
### Ventajas de esta estructura 
✔️ Mediante composición y agregación los componentes se inicializan solo cuando sea realmente necesario.</br>
✔️ Reducimos la complejidad del método encenderReproductorMedia() encapsulando y ocultando la inicialización específica de cada componente.</br>

-----
## Patrones de Comportamiento
<div align="center"> 
<img src="https://github.com/Reistoge/DesignPatterns/blob/main/src/BehavioralPatterns/BehavioralPatterns.png?raw=true" alt="#  ">   
</div>
Patrones que proponen soluciones flexibles para la interacción y división de responsabilidades entre clases y objetos

## ¿Cuándo usar un patrón de Comportamiento?
_En situaciones las cuales involucren distribuir o controlar el procesamiento y algoritmos entre objetos o también cuando se busque especificar flujos y procesamientos dinámicos de un sistema de objetos._ 

## Visitor
> Permite la agregación o construcción de nuevas operaciones y funcionalidades (visitores) que deben realizarse sobre los elementos de un conjunto de objetos (elementos) sin la necesidad de modificar su clase.

### Ejemplo
Un museo necesita gestionar diferentes tipos de obras de arte 
(Pintura, Escultura, Fotografía) y realizar varias 
operaciones sobre ellas como generar reportes,
calcular valores de seguro, y exportar datos.
````java
public class ObraArte {
    private String nombre;
    private double valor;

    public void generarReportePdf() {
        if (this instanceof Pintura) {
            System.out.println("Generando PDF para pintura");
        } else if (this instanceof Escultura) {
            System.out.println("Generando PDF para escultura");
        } else if (this instanceof Fotografia) {
            System.out.println("Generando PDF para fotografía");
        }
    }

    public void calcularSeguro() {
        if (this instanceof Pintura) {
            System.out.println("Calculando seguro para pintura");
        } else if (this instanceof Escultura) {
            System.out.println("Calculando seguro para escultura");
        } else if (this instanceof Fotografia) {
            System.out.println("Calculando seguro para fotografía");
        }
    }

    public void exportarACsv() {
        if (this instanceof Pintura) {
            System.out.println("Exportando pintura a CSV");
        } else if (this instanceof Escultura) {
            System.out.println("Exportando escultura a CSV");
        } else if (this instanceof Fotografia) {
            System.out.println("Exportando fotografía a CSV");
        }
    }
}
✖️ No se está ocultando correctamente la información de cada elemento y
   además siempre que tengamos que agregar una funcionalidad u operación
   tendremos que modificar el código base de ObraArte el cual involucra
   todos los demás elementos innecesariamente
   
````
### Solución 
1. Crear una interfaz para los elementos que se le aplicará una lógica (IElemento) y el visitante que aplica la lógica a los elementos (IVisitante)
2. Para la interfaz del visitante:
    1. Nuestra interfaz debe ser **capaz** de que en un solo método pueda 
       aceptar y aplicar una lógica distinta sobre IElementos concretos es por eso que debemos **añadir
       el mismo método aceptar()** pero soportado para **diferentes parámetros** que sería 
       cada tipo concreto de elementos.
       ````java
       aceptar(C1 elemento1);
       aceptar(C2 elemento2);
       aceptar(C3 elemento3);
       ````
           
3. Para la interfaz de Elemento:
   1. añadir un método
   ````java
    visitar(IVisitante v);
   ````
   3. dentro de cada elemento concreto es importante que dentro del cuerpo de la función esté implementado de esta forma
   ````java
    v.visitar(this)
   ````
      
   
<div align="center"> 
<img src="https://github.com/Reistoge/DesignPatterns/blob/main/src/BehavioralPatterns/Visitor/VisitorUML.png?raw=true"  alt="#  ">   
</div>

[Código](https://github.com/Reistoge/DesignPatterns/tree/main/src/BehavioralPatterns/Visitor/Solution)</br>
### Ventajas de esta estructura 
✔️ Gracias a la estructura de este patrón cada tipo de elemento se redirigirá automáticamente al visitante ejecutando su método de tipo correspondiente, de esta manera cuando tengamos que añadir una funcionalidad para los elementos debemos simplemente crear una clase que implemente la interfaz visitante e ir añadiendo la nueva funcionalidad para cada elemento por separado.

### Detalle
😔 El patrón visitor por otro lado tiene una gran desventaja y es cuando nosotros necesitemos agregar nuevos elementos a nuestra estructura ya que supondrá modificar la interfaz visitor y a todas sus implementaciones (acoplamiento evolutivo).

## Observer
> Permite definir mecanismos de suscripción dinámicos para notificar eventos a múltiples objetos los cuales observan o escuchan a un Sujeto    

### Ejemplo
Una aplicación multimedia necesita actualizar y notificar diferentes tipos
de usuarios (Windows, Android, iPhone) sobre nuevas versiones de la app y mensajes.
Inicialmente, las actualizaciones se manejan a través de llamadas directas a métodos.

````java
public class AppMultimedia {
    private ArrayList<String> usuariosWindows = new ArrayList<>();
    private ArrayList<String> usuariosAndroid = new ArrayList<>();
    private ArrayList<String> usuariosIphone = new ArrayList<>();
    private String versionActual;

    public void agregarUsuario(String nombre, String plataforma) {
        switch(plataforma.toLowerCase()) {
            case "windows":
                usuariosWindows.add(nombre);
                break;
            case "android":
                usuariosAndroid.add(nombre);
                break;
            case "iphone":
                usuariosIphone.add(nombre);
                break;
        }
    }

    public void actualizarVersionApp(String nuevaVersion) {
        versionActual = nuevaVersion;

        // Llamadas directas de actualización para cada plataforma
        for(String usuario : usuariosWindows) {
            System.out.println("Actualizando usuario Windows " + usuario + " a versión " + nuevaVersion);
        }
        for(String usuario : usuariosAndroid) {
            System.out.println("Actualizando usuario Android " + usuario + " a versión " + nuevaVersion);
        }
        for(String usuario : usuariosIphone) {
            System.out.println("Actualizando usuario iPhone " + usuario + " a versión " + nuevaVersion);
        }
    }

    public void enviarMensaje(String mensaje) {
        // Envío directo de mensajes para cada plataforma
        for(String usuario : usuariosWindows) {
            System.out.println("Enviando a usuario Windows " + usuario + ": " + mensaje);
        }
        for(String usuario : usuariosAndroid) {
            System.out.println("Enviando a usuario Android " + usuario + ": " + mensaje);
        }
        for(String usuario : usuariosIphone) {
            System.out.println("Enviando a usuario iPhone " + usuario + ": " + mensaje);
        }
    }
}
✖️ Modificar o añadir una lógica específica a un observador implica cambiar la lógica dentro
de donde se notifica a todos los demás, no se respeta SRP.
✖️ No hay una definición de contratos o una definición concreta para cada tipo de observador


   
````
### Solución 
<div align="center"> 
<img src="https://github.com/Reistoge/DesignPatterns/blob/main/src/BehavioralPatterns/Observer/ObserverUML.png?raw=true"  alt="#  ">   
</div>

[Código](https://github.com/Reistoge/DesignPatterns/tree/main/src/BehavioralPatterns/Observer/Solution)</br>
### Ventajas de esta estructura 
✔️ Podemos añadir observadores y sujetos sin la necesidad de modificar o alterar la lógica base (Acoplamiento)</br>
✔️ Podemos añadir o modificar la lógica específica a cada observador en la manera que es actualizado y cómo notifica cada sujeto a sus observadores (encapsulamiento).</br>
✔️ Gracias a esta estructura es mucho más simple y mantenible hacer combinaciones entre sujetos y observadores ya que se comunican mediante una interfaz.(integridad conceptual)</br>

## Template Method
> Permite definir el esqueleto o plantilla de un algoritmo el cual además se compone de procesos abstractos los cuales aplican una lógica distinta.  

### Ejemplo
Un sistema de cálculo científico necesita procesar diferentes
fórmulas matemáticas. Cada fórmula sigue un patrón similar de cálculo de tres pasos
pero con diferentes operaciones matemáticas.

````java
public class CalculoCientifico {
    private float a;
    private float b;
    private float c;
    private float d;
    private float e;

    public float procesarFormula1() {
        // Cálculo de tres pasos duplicado
        float paso1 = a * b;
        float paso2 = c + a;
        float paso3 = (float) Math.pow(a, b);
        return (paso1 * paso2) + paso3;
    }

    public float procesarFormula2() {
        // Misma estructura de tres pasos, diferente matemática
        float paso1 = (d + e) * (d + e);
        float paso2 = (float) Math.exp(e);
        float paso3 = (2 * d) / e;
        return (paso1 * paso2) + paso3;
    }
}
✖️ Cada vez que añadamos un proceso nuevo tendremos que volver a escribir el código plantilla (acoplamiento no aceptable)
✖️ Si tenemos muchos procesos y decidimos cambiar el código plantilla romperíamos con
la estructura de nuestro sistema, teniendo que ir a actualizar cada proceso concreto (acoplamiento evolutivo, OCP)


   
````
### Solución 
<div align="center"> 
<img src="https://github.com/Reistoge/DesignPatterns/blob/main/src/BehavioralPatterns/TemplateMethod/TemplateMethodUML.png?raw=true"  alt="#  ">   
</div>

[Código](https://github.com/Reistoge/DesignPatterns/tree/main/src/BehavioralPatterns/TemplateMethod/Solution)</br>
### Ventajas de esta estructura 
✔️ No tenemos que estar reescribiendo la fórmula cada vez que creamos un proceso nuevo.</br>
✔️ Ahora es más escalable debido a que si queremos cambiar la fórmula base tenemos que simplemente cambiarla dentro del método ````metodoPlantilla()````.</br>
✔️ Cada proceso está encapsulado y oculta su información tanto de atributos como de métodos de una manera la cual puedan modificarse sin tener que alterar la estructura general.</br>

## Strategy
> Nos permite definir una estructura la cual seleccionar en tiempo de ejecución qué tipo de algoritmo se ejecutará para un proceso concreto.   

### Ejemplo
Una aplicación de ordenamiento necesita manejar diferentes tipos
de ordenamiento para enteros y cadenas.

````java
public class AppOrdenamiento {
    private String tipoOrdenamiento;

    public ArrayList<Integer> ordenarEnteros(ArrayList<Integer> numeros, String tipoOrden) {
        this.tipoOrdenamiento = tipoOrden;
        ArrayList<Integer> resultado = new ArrayList<>(numeros);

        // Lógica condicional compleja para diferentes tipos de ordenamiento
        if (tipoOrden.equals("burbuja")) {
            // ... implementación de ordenamiento burbuja
        } else if (tipoOrden.equals("heap")) {
            // Duplicar lógica de heap sort aquí
            // ... implementación de heap sort
        }
        return resultado;
    }

    public ArrayList<String> ordenarCadenas(ArrayList<String> palabras, String tipoOrden) {
        this.tipoOrdenamiento = tipoOrden;
        ArrayList<String> resultado = new ArrayList<>(palabras);

        // Misma lógica de ordenamiento duplicada para cadenas
        if (tipoOrden.equals("burbuja")) {
            // Duplicar ordenamiento burbuja para cadenas
        } else if (tipoOrden.equals("heap")) {
            // Duplicar heap sort para cadenas
        }
        return resultado;
    }
}
✖️ La lógica de cada algoritmo no está encapsulada, debemos modificar
la estructura general siempre que queramos modificar cualquiera de los algoritmos.
✖️ Cuando queramos asociar un tipo de algoritmo específico a una
entidad o objeto esta estructura se irá volviendo cada vez más inestable.


   
````
### Solución 
<div align="center"> 
<img src="https://github.com/Reistoge/DesignPatterns/blob/main/src/BehavioralPatterns/Strategy/StrategyUMLExample.png?raw=true"  alt="#  ">   
</div>

[Código](https://github.com/Reistoge/DesignPatterns/tree/main/src/BehavioralPatterns/Strategy/Solution)</br>
### Ventajas de esta estructura 
✔️ Cada lógica concreta está encapsulada ocultando la información de sus métodos y atributos específicos lo que modificarla no altera la estructura general.</br>
✔️ Debido a que esta estructura maneja cada algoritmo concreto como una entidad, podemos asociar estos algoritmos a otros tipos de entidades de manera escalable.</br>
