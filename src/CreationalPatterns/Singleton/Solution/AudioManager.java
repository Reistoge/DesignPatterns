package CreationalPatterns.Singleton.Solution;

class AudioManager {

    public void playSound() {

        int volume = Singleton.getInstance().getVolume();
    }
}