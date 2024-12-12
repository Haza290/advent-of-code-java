package com.schneider.day6;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.*;

public class GuardTrackingMap {
    ArrayList<ArrayList<Tile>> map = new ArrayList<>();

    public GuardTrackingMap(List<String> mapStringList) {
        for (int y = 0; y < mapStringList.size(); y++) {
            ArrayList<Tile> rowOfTiles = new ArrayList<>();
            for (int x = 0; x < mapStringList.get(y).length(); x++) {
                rowOfTiles.add(new Tile(mapStringList.get(y).charAt(x) == '#'));
            }
            map.add(rowOfTiles);
        }
    }

    public Tile getTile(int xPos, int yPos) {
        if (yPos >= map.size() || yPos < 0 || xPos >= map.get(0).size() || xPos < 0) {
            return null;
        }
        return map.get(yPos).get(xPos);
    }

    public int countVisited() {
        return (int) map.stream().flatMap(Collection::stream).filter(Tile::isVisited).count();
    }

    @RequiredArgsConstructor
    @Getter
    @Setter
    public class Tile {
        private final boolean blocked;
        private boolean visited;
        private Set<Direction> visitedDirections = new HashSet<>();
    }

}
