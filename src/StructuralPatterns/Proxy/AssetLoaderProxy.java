package StructuralPatterns.Proxy;

import java.util.ArrayList;

public class AssetLoaderProxy implements AssetLoaderInterface {
    // Proxy pattern provides the same interface for the "proxied" and the proxy
    final float MAX_CALC_CAPACITY=10000f;
    ArrayList<String> assetsOnCache;
    ArrayList<String> assetsData;
    AssetLoaderInterface assetLoader;
    public AssetLoaderProxy(AssetLoaderInterface assetLoader) {
        assetsOnCache = new ArrayList<>();
        assetsData = new ArrayList<>();
        this.assetLoader = assetLoader;
    }
    @Override
    public String loadAsset(String name) {

        if(assetsOnCache.contains(name)){
            // if the asset was already loaded, return
            // the data of that asset,with this we save
            // data and processing.
            System.out.println("using cached asset");
            return assetsData.get(assetsOnCache.indexOf(name));
        }else{
            // if the asset is not loaded we loaded calling
            // the original component and then we added to the cache.
            System.out.println("add to cache");
            String loaded = assetLoader.loadAsset(name);
            if(assetsOnCache.size()<=10){
                assetsOnCache.add(name);
                assetsData.add(loaded);

            }
            else{
                System.out.println("cache over, removing first to make space");
                assetsOnCache.removeFirst();
                assetsOnCache.add(name);
                assetsData.removeFirst();
                assetsData.add(loaded);
            }
            return loaded;


        }

    }


    @Override
    public void showAsset(String processedValues) {
        if(processedValues.length()<MAX_CALC_CAPACITY){
            assetLoader.showAsset(processedValues);
        }
        else{
            printLoadError();
        }
    }

    @Override
    public void showAssetsNames() {
        assetLoader.showAssetsNames();
    }

    void printLoadError(){
        System.out.println(assetLoader.loadAsset("asset size not permitted"));
    }



}
