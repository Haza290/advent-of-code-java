package com.schneider.util;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class ReadFile {

    public static List<String> toStringList(File file) {
        ArrayList<String> lines = new ArrayList<>();
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public static List<Integer> toIntegerList(File file) {
        return toStringList(file).stream().map(Integer::parseInt).toList();
    }

    public static List<List<Integer>> fromVerticalListstoIntegerList(File file) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<List<Integer>> lists = Arrays.asList(list1, list2);

        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String line;
            while ((line = br.readLine()) != null) {
                LinkedList<String> splitLine = new LinkedList<>(Arrays.asList(line.split(" ")));
                splitLine.removeIf(String::isEmpty);
                list1.add(Integer.parseInt(splitLine.get(0)));
                list2.add(Integer.parseInt(splitLine.get(1)));
            }
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lists;
    }

    public static List<List<Integer>> toListOfIntegerList(File file) {
        List<List<Integer>> lists = new ArrayList<>();
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String line;
            while ((line = br.readLine()) != null) {
                List<Integer> list = Arrays.stream(line.split(" "))
                        .filter(s -> !s.isEmpty())
                        .map(Integer::parseInt)
                        .toList();
                lists.add(list);
            }
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lists;
    }
}
