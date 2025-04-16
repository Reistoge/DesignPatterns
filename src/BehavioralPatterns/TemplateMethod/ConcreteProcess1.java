package BehavioralPatterns.TemplateMethod;

public class ConcreteProcess1 extends AbstractProcess{

    float a;
    float b;
    float c;
    ConcreteProcess1(float a, float b, float c) {
        this.a = a;
        this.b = b;
        this.c = c;

    }
    @Override
    protected float calculate1() {
        return a*b;
    }

    @Override
    protected float calculate2() {
        return c+a;
    }

    @Override
    protected float calculate3() {

        return (float) Math.pow(a, b);


    }
}
