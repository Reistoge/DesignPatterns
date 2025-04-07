package CreationalPatterns.Prototype;

public class WaterLevelPreset implements LevelPrototype {
    int numberOfEnemies=3;
    int numberOfCoins=50;
    float wavesIntensity = 2f;
    float waterOpacity = .2f;
    public LevelPrototype cloneLevel() {
        WaterLevelPreset cloned = new WaterLevelPreset();
        cloned.numberOfEnemies = this.numberOfEnemies;
        cloned.numberOfCoins = this.numberOfCoins;
        cloned.wavesIntensity = this.wavesIntensity;
        cloned.waterOpacity = this.waterOpacity;
        return cloned;

    }
}
