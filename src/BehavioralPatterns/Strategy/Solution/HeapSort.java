package BehavioralPatterns.Strategy.Solution;

import java.util.ArrayList;

public class HeapSort implements IStrategy{
    public HeapSort(){
        System.out.println("Heap Sort");
    }
    @Override
    public ArrayList<Integer> integerSorting(ArrayList<Integer> objects) {
        ArrayList<Integer> numbers = new ArrayList<>(objects);
        int n = numbers.size();

        // Build heap
        for (int i = n / 2 - 1; i >= 0; i--)
            heapifyNumbers(numbers, n, i);

        // Extract elements from heap one by one
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            int temp = numbers.get(0);
            numbers.set(0, numbers.get(i));
            numbers.set(i, temp);

            heapifyNumbers(numbers, i, 0);
        }
        return numbers;
    }

    private void heapifyNumbers(ArrayList<Integer> numbers, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && numbers.get(left) > numbers.get(largest)) {
            largest = left;
        }

        if (right < n && numbers.get(right) > numbers.get(largest)) {
            largest = right;
        }

        if (largest != i) {
            int temp = numbers.get(i);
            numbers.set(i, numbers.get(largest));
            numbers.set(largest, temp);
            heapifyNumbers(numbers, n, largest);
        }
    }
    public ArrayList<String> stringSorting(ArrayList<String> objects) {
        ArrayList<String> words = new ArrayList<>(objects);
        int n = words.size();

        // Build heap
        for (int i = n / 2 - 1; i >= 0; i--)
            heapifyString(words, n, i);

        // Extract elements from heap one by one
        for (int i = n - 1; i > 0; i--) {
            String temp = words.get(0);
            words.set(0, words.get(i));
            words.set(i, temp);

            heapifyString(words, i, 0);
        }
        return words;
    }

    private void heapifyString(ArrayList<String> words, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && words.get(left).compareTo(words.get(largest)) > 0)
            largest = left;

        if (right < n && words.get(right).compareTo(words.get(largest)) > 0)
            largest = right;

        if (largest != i) {
            String temp = words.get(i);
            words.set(i, words.get(largest));
            words.set(largest, temp);
            heapifyString(words, n, largest);
        }
    }
}
