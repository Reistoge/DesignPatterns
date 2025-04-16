package BehavioralPatterns.TemplateMethod;

public abstract class AbstractProcess {
    float cost;
    float result;

    public void templateMethod(){
        //here we define the skeleton of an algorithm in the superclass
        result = (calculate1() * calculate2()) + calculate3();

    }

    // functions that are implemented by concrete classes and used only by concrete classes
    protected abstract float calculate1();
    protected abstract float calculate2();
    protected abstract float calculate3();



}
