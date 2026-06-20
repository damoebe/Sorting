package me.damoebe;

import java.util.List;

public record SortData(double time, List<List<Double>> steps, String algoName) {
}
