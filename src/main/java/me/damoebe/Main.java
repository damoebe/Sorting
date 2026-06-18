package me.damoebe;

import me.damoebe.simulation.WebSimulation;

import java.awt.*;
import java.util.Random;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Double[] array = new Double[]{11.0, 7.0, 10.0, 2.0, 1.5, 5.5, 10.0};
        //List<List<Double>> steps = Sort.selectionSort(getRandomArray(50)).steps();
        //System.out.println(steps);
        WebSimulation.start(Sort::bubbleSort, 10);
    }

    static void test(){

        Function<Double[], SortData> function = Sort::selectionSort;
        double average = 0;
        for (int i = 0; i < 10000; i++){
            double value = function.apply(getRandomArray(1000)).time();
            System.out.println(value);
            average += value;
        }
        average /= 10000;
        System.out.println(average);
    }

    public static Double[] getRandomArray(int size){
        Double[] doubles = new Double[size];
        Random random = new Random();
        for (int i = 0; i < size; i++){
            doubles[i] = random.nextDouble(50);
        }
        return doubles;
    }
}
