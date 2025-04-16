package BehavioralPatterns.Visitor;

public interface IElement {
    void accept(IVisitor visitor);
}
