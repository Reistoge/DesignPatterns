package BehavioralPatterns.TemplateMethod;

public class ConcreteProcess2 extends AbstractProcess {
    float d;
    float e;

    ConcreteProcess2(float d, float e) {
        this.d = d;
        this.e = e;

    }
    @Override
    protected float calculate1() {
        return (d+e)*(d+e);
    }

    @Override
    protected float calculate2() {
        return (float) Math.exp(e);
    }

    @Override
    protected float calculate3() {
        return (2*d)/e;
    }
}
