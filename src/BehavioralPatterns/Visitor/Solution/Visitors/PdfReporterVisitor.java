package BehavioralPatterns.Visitor.Solution.Visitors;

import BehavioralPatterns.Visitor.Solution.IVisitor;
import BehavioralPatterns.Visitor.Solution.Elements.Paint;
import BehavioralPatterns.Visitor.Solution.Elements.Photograph;
import BehavioralPatterns.Visitor.Solution.Elements.Sculpture;

public class PdfReporterVisitor implements IVisitor {

    @Override
    public void accept(Paint visitor) {
        System.out.println("Pdf exporter Visitor: pdf report for paint");

    }

    @Override
    public void accept(Photograph visitor) {
        System.out.println("Pdf exporter Visitor: pdf report for Photograph");
    }

    @Override
    public void accept(Sculpture visitor) {
        System.out.println("Pdf exporter Visitor: pdf report for sculpture");

    }
}
