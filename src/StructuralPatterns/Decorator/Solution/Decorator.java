package StructuralPatterns.Decorator.Solution;

public abstract class Decorator implements AbstractComponent {
    protected float cost;

    protected AbstractComponent component;
    public Decorator(AbstractComponent component) {
        this.component = component;
    }
    public void display(){
        component.display();
    }
    public float getCost(){
        return component.getCost();
    }

}
