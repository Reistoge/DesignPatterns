package CreationalPatterns.FactoryMethod.Solution.Products;

public abstract class Product {
    String name;
    String shape;

    public abstract void setStyle();
    public abstract void functionality();
    public String getName() {return name;}

    public String getShape() {return shape;}



}
