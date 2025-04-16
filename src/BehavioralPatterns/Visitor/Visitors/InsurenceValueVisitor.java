package BehavioralPatterns.Visitor.Visitors;

import BehavioralPatterns.Visitor.IVisitor;
import BehavioralPatterns.Visitor.Elements.Paint;
import BehavioralPatterns.Visitor.Elements.Photograph;
import BehavioralPatterns.Visitor.Elements.Sculpture;

public class InsurenceValueVisitor implements IVisitor {
    @Override
    public void accept(Paint visitor) {
        System.out.println("Insurence visitor: calculating insurence value for Paint");
    }

    @Override
    public void accept(Photograph visitor) {
        System.out.println("Insurence visitor: calculating insurence value for Photograph");

    }

    @Override
    public void accept(Sculpture visitor) {
        System.out.println("Insurence visitor: calculating insurence value for Sculpture");

    }
}
