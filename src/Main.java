import StructuralPatterns.Decorator.*;

import java.awt.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        AbstractComponent completoOrder = new ChileanCompletoComponent();
        completoOrder = new MayoDecorator(completoOrder);
        completoOrder = new PaltaDecorator(completoOrder);
        completoOrder = new SpecialSausage(completoOrder,"premium");
        completoOrder = new KetchupDecorator(completoOrder,true);
        completoOrder = new MayoDecorator(completoOrder);
        completoOrder = new PaltaDecorator(completoOrder);
        completoOrder.display();


        float totalPrice = completoOrder.getCost();
        System.out.println("total: "+totalPrice);

    }
}