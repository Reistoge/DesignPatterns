package StructuralPatterns.Decorator;

public class KetchupDecorator extends Decorator {
    boolean light;
    public KetchupDecorator(AbstractComponent component,boolean light) {
        super(component);

        cost=.1f;
        if(light) cost=.3f;

    }

    @Override
    public float getCost() {
        return getKetchupCost() + super.getCost();
    }

    public float getKetchupCost(){
        return this.cost;
    }
    public void display() {
        super.display();
        displayKetchup();

    }
    public void displayKetchup(){
        System.out.println("Ketchup cost: "+getKetchupCost()+", light : "+light);
    }
}
