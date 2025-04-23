package StructuralPatterns.Decorator.Solution;

public class PremiumSausageDecorator extends Decorator {
    String quality; // premium veggie
    public PremiumSausageDecorator(AbstractComponent component, String quality) {
        super(component);
        cost=1f;
        this.quality = quality;


    }

    @Override
    public float getCost() {
        // wrapper
        return super.getCost() + this.cost * getQualityCost();
    }
    public float getQualityCost(){
        float multiplier=1;
        switch(quality.toLowerCase()) {

            case "premium":
                multiplier = 2;
                break;
            case "veggie":
                multiplier = 3;
                break;
        }
         return this.cost * multiplier;
    }
    public void display(){
        // wrapper
        super.display();
        displaySausage();

    }
    public void displaySausage(){
        System.out.println("Sausage: " +getQualityCost()+", quality : "+quality);
    }




}
