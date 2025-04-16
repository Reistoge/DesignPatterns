package BehavioralPatterns.Visitor.Elements;

import BehavioralPatterns.Visitor.IElement;
import BehavioralPatterns.Visitor.IVisitor;

public class Paint implements IElement {

    @Override
    public void accept(IVisitor visitor) {
        System.out.println("Paint accepted visitor");
        visitor.accept(this);
        System.out.println("\n");
    }
}
