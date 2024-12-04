package com.schneider.year2021.day9;

import com.schneider.year2021.day8.SevenSegmentSearch;
import com.schneider.util.ReadFile;

import java.io.*;
import java.net.*;
import java.util.*;

public class SmokeBasin {

    public static void main(String[] args) throws URISyntaxException {
        File testFile = new File(SevenSegmentSearch.class.getResource("/day9/input.txt").toURI());
        System.out.println(SmokeBasin.sumRiskLevels(testFile));
    }

    public static int sumRiskLevels(File file) {
        int[][] map = convertMap(ReadFile.toStringList(file));
        int rowSize = map[0].length;
        int columnSize = map.length;

        int riskLevel = 0;

        for (int x = 0; x < rowSize; x++) {
            for (int y = 0; y < columnSize; y++) {
                int value = map[y][x];
                if (    (x == 0 || value < map[y][x-1]) &&
                        (x == rowSize-1 || value < map[y][x+1]) &&
                        (y == 0 || value < map[y-1][x]) &&
                        (y == columnSize-1 || value < map[y+1][x])) {
                    riskLevel += value + 1;
                }
            }
        }
        return riskLevel;
    }


    private static int[][] convertMap(List<String> stringArray) {
        int rowSize = stringArray.get(0).length();
        int columnSize = stringArray.size();

        int[][] map = new int[rowSize][columnSize];
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < columnSize; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(stringArray.get(j).charAt(i)));
            }
        }
        return map;
    }
}
