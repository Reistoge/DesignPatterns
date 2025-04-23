package BehavioralPatterns.Strategy.Solution;

import java.util.ArrayList;

public class BubbleSort implements IStrategy {

    public BubbleSort(){
        System.out.println("Bubble Sort");
    }
    @Override
    public ArrayList<Integer> integerSorting(ArrayList<Integer> objects) {
        ArrayList<Integer> numbers = new ArrayList<>(objects);
        for (int i = 0; i < numbers.size() - 1; i++) {
            for (int j = i + 1; j < numbers.size(); j++) {
                if (numbers.get(i) > numbers.get(j)) {
                    int temp = numbers.get(i);
                    numbers.set(i, numbers.get(j));
                    numbers.set(j, temp);

                }
            }
        }
        return numbers;
    }

    @Override
    public ArrayList<String> stringSorting(ArrayList<String> objects) {
        ArrayList<String> words = new ArrayList<>(objects);
        for (int i = 0; i < words.size() - 1; i++) {
            for (int j = i + 1; j < words.size(); j++) {
                if(words.get(i).indexOf(0) > words.get(j).indexOf(0)){
                    String temp = words.get(i);
                    words.set(i, words.get(j));
                    words.set(j, temp);

                }
            }
        }
        return words;
    }
}
