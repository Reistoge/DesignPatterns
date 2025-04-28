package StructuralPatterns.Proxy.Solution;

public interface IAssetLoader {
    String loadAsset(String name);
    void showAsset(String processedValues);
    void showAssetsNames();

}
