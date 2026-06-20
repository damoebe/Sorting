package me.damoebe;

import java.util.ArrayList;
import java.util.List;

public class Sort {
    public static SortData selectionSort(Double[] array){
        List<List<Double>> steps = new ArrayList<>();
        long currentTime = System.nanoTime();
        List<Double> input = new ArrayList<>(List.of(array));
        steps.add(new ArrayList<>(input));
        List<Double> sorted = new ArrayList<>();
        for (int i = 0; i < array.length; i++){
            double lowest = Double.MAX_VALUE;
            for (double num : input){
                if (num < lowest) lowest = num;
            }
            sorted.add(lowest);
            input.remove(lowest);
            List<Double> step = new ArrayList<>(sorted);
            step.addAll(input);
            steps.add(step);
        }
        steps.add(new ArrayList<>(sorted));
        return new SortData((System.nanoTime() - currentTime) / 1000000.0,
                steps, "Selection Sort");
    }
    public static SortData insertionSort(Double[] array){
        List<List<Double>> steps = new ArrayList<>();
        long currentTime = System.nanoTime();
        List<Double> sorted = new ArrayList<>();
        List<Double> input = new ArrayList<>(List.of(array));
        List<Double> displayInput = new ArrayList<>(List.of(array));
        steps.add(new ArrayList<>(input));
        sorted.add(array[0]);
        input.removeFirst();
        for (Double num : input) {
            boolean added = false;
            for (Double sortedNum : sorted) {
                if (num <= sortedNum) {
                    sorted.add(sorted.indexOf(sortedNum), num);
                    displayInput.remove(num);
                    added = true;
                    break;
                }
            }
            if (!added){sorted.add(num); displayInput.remove(num);}
            List<Double> step = new ArrayList<>(sorted);
            step.addAll(displayInput);
            steps.add(step);
        }
        steps.add(sorted);
        return new SortData((System.nanoTime() - currentTime) / 1000000.0,
                steps, "Insertion Sort");
    }
    public static SortData bubbleSort(Double[] array){
        List<List<Double>> steps = new ArrayList<>();
        long currentTime = System.nanoTime();
        List<Double> input = new ArrayList<>(List.of(array));
        steps.add(new ArrayList<>(input));
        int passes = 0;
        while (passes < input.size()-1){
            passes = 0;
            for (int i = 0; i < input.size()-1; i++){
                double element = input.get(i);
                if (element > input.get(i+1)){
                    input.set(i, input.get(i+1));
                    input.set(i+1, element);
                }else { passes++;}
                steps.add(new ArrayList<>(input));
            }
        }
        steps.add(new ArrayList<>(input));
        return new SortData((System.nanoTime() - currentTime) / 1000000.0,
                steps, "Bubble Sort");
    }
}
