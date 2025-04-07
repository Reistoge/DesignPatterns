package CreationalPatterns.FactoryMethod.Creators;

import CreationalPatterns.FactoryMethod.Products.BlueProduct;
import CreationalPatterns.FactoryMethod.Products.Product;

public class BlueCreator extends Creator {
    public BlueCreator() {
        product = new BlueProduct("default"); {};
    }
    @Override
    public Product create(String name) {
        if(product ==null){
            product = new BlueProduct(name);
        }
        return product;
    }

    @Override
    public void destroy(Product product) {
        product =null;
    }
}
