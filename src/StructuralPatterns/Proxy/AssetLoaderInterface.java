package StructuralPatterns.Proxy;

public interface AssetLoaderInterface {
    String loadAsset(String name);
    void showAsset(String processedValues);
    void showAssetsNames();

}
