package BehavioralPatterns.Visitor.Elements;

import BehavioralPatterns.Visitor.IElement;
import BehavioralPatterns.Visitor.IVisitor;

public class Photograph implements IElement {
    @Override
    public void accept(IVisitor visitor) {
        System.out.println("Photograph accepted visitor");
        visitor.accept(this);
        System.out.println("\n");
    }
}
