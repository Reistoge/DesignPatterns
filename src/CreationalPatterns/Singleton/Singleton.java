package Singleton;

public class Singleton {
    // provide a unique instance of a class and a global
    // access point to other classes of the instance.
    private static Singleton instance;
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();

        }
        return instance;
    }
}
