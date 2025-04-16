package BehavioralPatterns.Visitor.Visitors;

import BehavioralPatterns.Visitor.IVisitor;
import BehavioralPatterns.Visitor.Elements.Paint;
import BehavioralPatterns.Visitor.Elements.Photograph;
import BehavioralPatterns.Visitor.Elements.Sculpture;

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
