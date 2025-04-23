package BehavioralPatterns.Visitor.Solution;

public interface IElement {
    void accept(IVisitor visitor);
}
