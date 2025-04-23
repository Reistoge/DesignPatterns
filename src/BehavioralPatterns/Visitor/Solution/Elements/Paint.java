package BehavioralPatterns.Visitor.Solution.Elements;

import BehavioralPatterns.Visitor.Solution.IElement;
import BehavioralPatterns.Visitor.Solution.IVisitor;

public class Paint implements IElement {

    @Override
    public void accept(IVisitor visitor) {
        System.out.println("Paint accepted visitor");
        visitor.accept(this);
        System.out.println("\n");
    }
}
