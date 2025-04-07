package CreationalPatterns.Prototype;

public class LavaLevelPreset implements LevelPrototype {
    int numberOfEnemies=3;
    int numberOfCoins=50;
    float LavaQuantity = 12.34f;
    public LevelPrototype cloneLevel() {
        LavaLevelPreset cloned= new LavaLevelPreset();
        cloned.numberOfEnemies =this. numberOfEnemies;
        cloned.numberOfCoins =this.numberOfCoins;
        cloned.LavaQuantity = this.LavaQuantity;
        return cloned;
    }
}
