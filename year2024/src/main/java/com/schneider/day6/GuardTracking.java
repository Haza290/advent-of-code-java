package com.schneider.day6;

import com.schneider.util.ReadFile;

import java.io.File;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class GuardTracking {

    public static void main(String[] args) {
        try {
            File testFile = new File(GuardTracking.class.getClassLoader().getResource("day6/input.txt").toURI());
            List<String> mapStringList = ReadFile.toStringList(testFile);
            System.out.println(new GuardTracking().getDistinctGuardPositionsCount(mapStringList));
            System.out.println(new GuardTracking().countLoopsCreatedByAddingBlocker(mapStringList));

        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }


    public int getDistinctGuardPositionsCount(List<String> mapStringList) {
        GuardTrackingMap map = new GuardTrackingMap(mapStringList);
        Guard guard = new Guard(mapStringList, map);
        guard.isLoop();
        return map.countVisited();
    }


    public int countLoopsCreatedByAddingBlocker(List<String> mapStringList) {
        List<List<String>> alternativeMaps = new ArrayList<>();
        for (int y = 0; y < mapStringList.size(); y++) {
            for (int x = 0; x < mapStringList.get(y).length(); x++) {
                char c = mapStringList.get(y).charAt(x);
                if (c != '#' && c != '^' && c != 'v' && c != '>' && c != '<') {
                    ArrayList<String> newMap = new ArrayList<>(mapStringList);
                    StringBuilder stringBuilder = new StringBuilder(newMap.get(y));
                    stringBuilder.setCharAt(x, '#');
                    newMap.set(y, stringBuilder.toString());
                    alternativeMaps.add(newMap);
                }
            }
        }

        return (int) alternativeMaps.stream()
                .filter(this::isLoop)
                .count();
    }

    private boolean isLoop(List<String> mapStringList) {
        GuardTrackingMap map = new GuardTrackingMap(mapStringList);
        Guard guard = new Guard(mapStringList, map);
        return guard.isLoop();
    }
}
