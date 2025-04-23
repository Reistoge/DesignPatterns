package StructuralPatterns.Proxy;

import java.util.ArrayList;
import java.util.Random;

public class AssetLoader implements IAssetLoader {

    // this class just initialize and loads assets.
    ArrayList<String> assets;
    public AssetLoader(int assetCount) {
        assets = new ArrayList<String>(assetCount);
        for(int i =0; i<assetCount; i++) {
            assets.add(getRandomString(3,10));
        }
    }
    @Override
    public String loadAsset(String name) {
        if(!assets.contains(name)){
            assets.add(name);
            System.out.println("added new Asset: " + name);
        }
        String processedValues = bigDemandProcessingFunction(name);
        return processedValues;
    }
    private String bigDemandProcessingFunction(String name){
        return name.toUpperCase()+".PROCESSED.VALUES.TRUE";
    }
    public void showAsset(String processedValues) {
         System.out.println("The processed values is: " + processedValues);
    }
    public void showAssetsNames(){
        for (String name : assets) {
            System.out.println("- "+name);
        }
    }

    private String getRandomString(int min, int max) {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        Random random = new Random();
        int targetStringLength = random.nextInt(min,max);
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for(int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        return buffer.toString();
    }
}
