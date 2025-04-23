package BehavioralPatterns.Visitor.Solution;

import BehavioralPatterns.Visitor.Solution.Elements.Paint;
import BehavioralPatterns.Visitor.Solution.Elements.Photograph;
import BehavioralPatterns.Visitor.Solution.Elements.Sculpture;

public interface IVisitor {
    // Visitor interface that defines the visit methods for different elements
    // we separate operations from the objects they operate on to add
    // new behaviors without modifying existing classes.
    void accept(Paint visitor);
    void accept(Photograph visitor);
    void accept(Sculpture visitor);

}
