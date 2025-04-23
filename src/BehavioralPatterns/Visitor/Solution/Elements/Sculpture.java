package BehavioralPatterns.Visitor.Solution.Elements;

import BehavioralPatterns.Visitor.Solution.IElement;
import BehavioralPatterns.Visitor.Solution.IVisitor;

public class Sculpture implements IElement {
    @Override
    public void accept(IVisitor visitor) {
            System.out.println("Sculpture accepted visitor");
            visitor.accept(this);
            System.out.println("\n");
    }
}
