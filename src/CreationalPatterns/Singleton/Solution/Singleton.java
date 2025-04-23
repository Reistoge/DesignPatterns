package CreationalPatterns.Singleton.Solution;

public class Singleton {
    // provide a unique instance of a class and a global
    // access point to other classes of the instance.
    private int volume;
    private boolean fullscreen;
    private int difficulty;

    private static Singleton instance;
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();

        }
        return instance;
    }
    // Getters and setters
    public void setVolume(int volume) { this.volume = volume; }
    public int getVolume() { return volume; }
    public void setFullscreen(boolean fullscreen) { this.fullscreen = fullscreen; }
    public boolean isFullscreen() { return fullscreen; }
    public void setDifficulty(int difficulty) { this.difficulty = difficulty; }
    public int getDifficulty() { return difficulty; }
}
