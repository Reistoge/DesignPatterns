package StructuralPatterns.Decorator.InitialCode;

public class Completo {
    private boolean hasMayo;
    private boolean hasKetchup;
    private boolean hasPalta;
    private String sausageType;

    public float calculatePrice() {
        float price = 2.0f; // base price

        if (hasMayo) price += 0.2f;
        if (hasKetchup) price += 0.1f;
        if (hasPalta) price += 0.5f;
        if (sausageType.equals("premium")) price += 2.0f;
        if (sausageType.equals("veggie")) price += 3.0f;

        return price;
    }

    // Multiple setters for each ingredient
    public void addMayo() { this.hasMayo = true; }
    public void addKetchup() { this.hasKetchup = true; }
    public void addPalta() { this.hasPalta = true; }
    public void setSausageType(String type) { this.sausageType = type; }
}