package BehavioralPatterns.Strategy.Solution;
import java.util.ArrayList;
public interface IStrategy {

    // Defines a family of interchangeable algorithms and allows dynamic switching
    // here we define the methods that every concrete strategy must implement, do or use.
    ArrayList<Integer> integerSorting(ArrayList<Integer> objects);
    ArrayList<String> stringSorting(ArrayList<String> objects);

}
