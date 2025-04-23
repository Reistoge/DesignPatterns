package BehavioralPatterns.Visitor.Solution.Visitors;

import BehavioralPatterns.Visitor.Solution.IVisitor;
import BehavioralPatterns.Visitor.Solution.Elements.Paint;
import BehavioralPatterns.Visitor.Solution.Elements.Photograph;
import BehavioralPatterns.Visitor.Solution.Elements.Sculpture;

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
