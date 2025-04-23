package StructuralPatterns.Decorator.Solution;

public class PaltaDecorator extends Decorator {

    public PaltaDecorator(AbstractComponent component) {
        super(component);
        cost=.5f;
    }

    @Override
    public float getCost() {
        //wrapper
        return super.getCost() + getPaltaCost();
    }

    public float getPaltaCost(){

        return this.cost;
    }

    public void display(){
        //wrapper
        super.display();
        displayPalta();
    }
    public void displayPalta(){
        System.out.println("Palta: "+getPaltaCost());
    }
}
