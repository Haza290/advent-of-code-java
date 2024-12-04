package com.schneider.day1;

import com.schneider.util.ReadFile;

import java.io.File;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.List;

public class LocationListComparison {

    public static void main(String[] args) {
        try {
            File testFile = new File(LocationListComparison.class.getClassLoader().getResource("day1/input.txt").toURI());
            List<List<Integer>> lists = ReadFile.fromVerticalListstoIntegerList(testFile);
            System.out.println("Differences: " + compare(lists.get(0), lists.get(1)));
            System.out.println("Sum of id's times frequency: " + sumOfIdsTimesFrequency(lists.get(0), lists.get(1)));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public static int compare(List<Integer> list1, List<Integer> list2) {
        Collections.sort(list1);
        Collections.sort(list2);

        int difference = 0;
        for (int i = 0; i < list1.size(); i++) {
            difference += Math.abs(list1.get(i) - list2.get(i));
        }
        return difference;
    }

    static int sumOfIdsTimesFrequency(List<Integer> list1, List<Integer> list2) {
        return list1.stream()
                .map(i -> i * Collections.frequency(list2, i))
                .mapToInt(Integer::intValue)
                .sum();
    }
}
