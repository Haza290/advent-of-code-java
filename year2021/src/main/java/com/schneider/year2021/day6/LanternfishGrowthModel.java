package com.schneider.year2021.day6;

import com.schneider.year2021.day5.HydrothermalVenture;
import com.schneider.util.ReadFile;

import java.io.File;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.Collections.frequency;

public class LanternfishGrowthModel {

    private static long[] grow(long[] lanternfish) {
        long[] newLanternfish = new long[9];
        IntStream.rangeClosed(1,8).forEach(i -> newLanternfish[i-1] = lanternfish[i]);
        newLanternfish[8] = lanternfish[0];
        newLanternfish[6] = lanternfish[0] + newLanternfish[6];
        return newLanternfish;
    }

    public static long calculateNumberOfLanternfish(List<Integer> startingFish, int days) {
        long[] newLanternfish = new long[9];
        for (int i = 0; i < 9; i++) {
            newLanternfish[i] = frequency(startingFish, i);
        }
        while (days > 0) {
            newLanternfish = grow(newLanternfish);
            days --;
        }
        return Arrays.stream(newLanternfish).sum();
    }

    public static void main(String[] args) throws URISyntaxException {
        File testFile = new File(HydrothermalVenture.class.getResource("/day6/input.txt").toURI());
        List<Integer> startingFish = Arrays.stream(ReadFile.toStringList(testFile).get(0).split(",")).map(Integer::parseInt).toList();
        System.out.println(LanternfishGrowthModel.calculateNumberOfLanternfish(startingFish, 80));
        System.out.println(LanternfishGrowthModel.calculateNumberOfLanternfish(startingFish, 256));
    }
}
