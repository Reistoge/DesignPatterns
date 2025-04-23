package CreationalPatterns.FactoryMethod.Solution.Creators;

import CreationalPatterns.FactoryMethod.Solution.Products.Product;
import CreationalPatterns.FactoryMethod.Solution.Products.RedProduct;

public class RedCreator extends Creator {

    public RedCreator(){
        product = new RedProduct("default");
    }
    @Override
    public Product create(String name) {
        if(product==null){
            product = new RedProduct(name);
        }
        return product;
    }

    @Override
    public void destroy(Product product) {
        product = null;

    }
}
