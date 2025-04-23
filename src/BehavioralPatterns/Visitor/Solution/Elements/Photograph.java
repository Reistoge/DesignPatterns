package BehavioralPatterns.Visitor.Solution.Elements;

import BehavioralPatterns.Visitor.Solution.IElement;
import BehavioralPatterns.Visitor.Solution.IVisitor;

public class Photograph implements IElement {
    @Override
    public void accept(IVisitor visitor) {
        System.out.println("Photograph accepted visitor");
        visitor.accept(this);
        System.out.println("\n");
    }
}
