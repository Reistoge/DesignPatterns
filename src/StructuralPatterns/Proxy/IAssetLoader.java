package StructuralPatterns.Proxy;

public interface IAssetLoader {
    String loadAsset(String name);
    void showAsset(String processedValues);
    void showAssetsNames();

}
