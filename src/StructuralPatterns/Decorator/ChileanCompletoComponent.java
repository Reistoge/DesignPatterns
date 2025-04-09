package StructuralPatterns.Decorator;

public class ChileanCompletoComponent implements AbstractComponent {
    @Override
    public void display() {
        System.out.println("~Chilean Completo~");

    }
    @Override
    public float getCost() {
        return 2f;
    }
}
