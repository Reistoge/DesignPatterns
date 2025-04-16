package BehavioralPatterns.Visitor.Visitors;

import BehavioralPatterns.Visitor.IVisitor;
import BehavioralPatterns.Visitor.Elements.Paint;
import BehavioralPatterns.Visitor.Elements.Photograph;
import BehavioralPatterns.Visitor.Elements.Sculpture;

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
