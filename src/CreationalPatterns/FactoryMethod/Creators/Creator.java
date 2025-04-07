package CreationalPatterns.FactoryMethod.Creators;

import CreationalPatterns.FactoryMethod.Products.Product;

// Factory method are subclasses of different types of objects
// that connect between each other
public abstract class Creator {

    // there is only a concrete Creator and a concrete Product
    // so we make both classes abstracts
    // every subclass of a Creator uses a subclass of a Product.

    Product product;
    public abstract Product create(String name); // implemented by type of creator that uses a specific type of product
    public abstract void destroy(Product product);
}
