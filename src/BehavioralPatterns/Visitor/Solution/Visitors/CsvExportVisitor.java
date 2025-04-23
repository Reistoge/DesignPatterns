package BehavioralPatterns.Visitor.Solution.Visitors;

import BehavioralPatterns.Visitor.Solution.IVisitor;
import BehavioralPatterns.Visitor.Solution.Elements.Paint;
import BehavioralPatterns.Visitor.Solution.Elements.Photograph;
import BehavioralPatterns.Visitor.Solution.Elements.Sculpture;

public class CsvExportVisitor implements IVisitor {
    @Override
    public void accept(Paint element) {
        System.out.println("Csv Export Visitor: converting paint to csv");
    }

    @Override
    public void accept(Photograph element) {
        System.out.println("Csv Export Visitor: converting photograph to csv");
    }

    @Override
    public void accept(Sculpture element) {
        System.out.println("Csv Export Visitor: converting sculpture to csv");

    }
}
