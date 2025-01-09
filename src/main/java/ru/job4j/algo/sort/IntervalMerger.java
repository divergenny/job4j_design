package ru.job4j.algo.sort;

import java.util.ArrayList;
import java.util.Arrays;

public class IntervalMerger {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }
        Arrays.sort(intervals, (arr1, arr2) -> Integer.compare(arr1[0], arr2[0]));
        ArrayList<int[]> outputArray = new ArrayList<>();
        int[] currentInterval = intervals[0];
        outputArray.add(currentInterval);
        for (int[] interval : intervals) {
            int currentBegin = currentInterval[0];
            int currentEnd = currentInterval[1];
            int nextBegin = interval[0];
            int nextEnd = interval[1];
            if (currentEnd >= nextBegin) {
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            } else {
                currentInterval = interval;
                outputArray.add(currentInterval);
            }
        }
        return outputArray.toArray(new int[outputArray.size()][]);
    }
}
