package CreationalPatterns.FactoryMethod.Creators;

import CreationalPatterns.FactoryMethod.Products.GreenProduct;
import CreationalPatterns.FactoryMethod.Products.Product;

public class GreenCreator extends Creator {
    public GreenCreator() {
        product = new GreenProduct("default");
    }
    @Override
    public Product create(String name) {
        if(product==null){
            product = new GreenProduct(name);
        }
        return product;
    }

    @Override
    public void destroy(Product product) {
        product = null;
    }
}
