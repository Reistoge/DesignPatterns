package CreationalPatterns.FactoryMethod.Solution.Creators;

import CreationalPatterns.FactoryMethod.Solution.Products.GreenProduct;
import CreationalPatterns.FactoryMethod.Solution.Products.Product;

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
