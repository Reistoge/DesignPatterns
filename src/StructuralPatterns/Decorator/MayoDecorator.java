package StructuralPatterns.Decorator;

public class MayoDecorator extends Decorator {


    public MayoDecorator(AbstractComponent component) {
        super(component);
        cost=.2f;
    }

    @Override
    public float getCost() {
        //wrapper
        return super.getCost() + cost;
    }


    public float getMayoCost(){
        return this.cost;
    }
    public void display(){
        //wrapper
        super.display();
        displayMayo();
    }
    public void displayMayo(){
        System.out.println("Mayo: "+cost);
    }
}
