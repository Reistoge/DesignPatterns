package CreationalPatterns.Singleton.Solution;

class DisplayManager {

    public void updateDisplay() {

         boolean fullscreen = Singleton.getInstance().isFullscreen();
    }
}