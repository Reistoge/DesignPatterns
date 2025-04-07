import Builder.Personaje;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Personaje personaje = new Personaje.Builder()
                .setNombre("Personaje")
                .setAtaque(1000)
                .build();

        System.out.println(personaje.toString());
    }
}