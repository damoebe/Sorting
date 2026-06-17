package me.damoebe;

import java.util.ArrayList;
import java.util.List;

public class Sort {
    public static SortData selectionSort(Double[] array){
        long currentTime = System.nanoTime();
        List<Double> input = new ArrayList<>(List.of(array));
        List<Double> sorted = new ArrayList<>();
        for (int i = 0; i < array.length; i++){
            double lowest = Double.MAX_VALUE;
            for (double num : input){
                if (num < lowest) lowest = num;
            }
            sorted.add(lowest);
            input.remove(lowest);
        }
        return new SortData((System.nanoTime() - currentTime) / 1000000.0,
                List.of(List.of(sorted.toArray(new Double[array.length]))));
    }
    public static SortData insertionSort(Double[] array){
        long currentTime = System.nanoTime();
        List<Double> sorted = new ArrayList<>();
        List<Double> input = new ArrayList<>(List.of(array));
        sorted.add(array[0]);
        input.removeFirst();
        for (Double num : input) {
            boolean added = false;
            for (Double sortedNum : sorted) {
                if (num <= sortedNum) {
                    sorted.add(sorted.indexOf(sortedNum), num);
                    added = true;
                    break;
                }
            }
            if (!added){sorted.add(num);}
        }
        return new SortData((System.nanoTime() - currentTime) / 1000000.0,
                List.of(List.of(sorted.toArray(new Double[array.length]))));
    }
    public static SortData bubbleSort(Double[] array){
        long currentTime = System.nanoTime();
        List<Double> input = new ArrayList<>(List.of(array));
        int passes = 0;
        while (passes < input.size()-1){
            passes = 0;
            for (int i = 0; i < input.size()-1; i++){
                double element = input.get(i);
                if (element > input.get(i+1)){
                    input.set(i, input.get(i+1));
                    input.set(i+1, element);
                }else { passes++;}
            }
        }
        return new SortData((System.nanoTime() - currentTime) / 1000000.0,
                List.of(List.of(input.toArray(new Double[array.length]))));
    }
}
