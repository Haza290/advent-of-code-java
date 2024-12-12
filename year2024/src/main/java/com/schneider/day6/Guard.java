package com.schneider.day6;

import java.util.List;

public class Guard {
    int xPos;
    int yPos;
    Direction direction;
    GuardTrackingMap map;
    List<String> mapStringList;

    public Guard(List<String> mapStringList, GuardTrackingMap map) {
        this.map = map;
        this.mapStringList = mapStringList;
        for (int y = 0; y < mapStringList.size(); y++) {
            for (int x = 0; x < mapStringList.get(y).length(); x++) {
                switch (mapStringList.get(y).charAt(x)) {
                    case '^':
                        xPos = x;
                        yPos = y;
                        direction = Direction.UP;
                        break;
                    case 'v':
                        xPos = x;
                        yPos = y;
                        direction = Direction.DOWN;
                        break;
                    case '>':
                        xPos = x;
                        yPos = y;
                        direction = Direction.RIGHT;
                        break;
                    case '<':
                        xPos = x;
                        yPos = y;
                        direction = Direction.LEFT;
                        break;
                }
            }
        }
        map.getTile(xPos, yPos).setVisited(true);
        map.getTile(xPos, yPos).getVisitedDirections().add(direction);
    }

    public boolean isLoop() {
        while (true) {
            int newXPos = xPos;
            int newYPos = yPos;
            switch (direction) {
                case UP -> newYPos--;
                case DOWN -> newYPos++;
                case RIGHT -> newXPos++;
                case LEFT -> newXPos--;
            }
            GuardTrackingMap.Tile newTile = map.getTile(newXPos, newYPos);
            if (newTile == null) {
                return false;
            }
            if (newTile.getVisitedDirections().contains(direction)) {
                return true;
            }
            if (newTile.isBlocked()) {
                turn();
            } else {
                xPos = newXPos;
                yPos = newYPos;
                map.getTile(newXPos, newYPos).setVisited(true);
                map.getTile(newXPos, newYPos).getVisitedDirections().add(direction);
            }
        }
    }

    private void turn() {
        switch (direction) {
            case UP -> direction = Direction.RIGHT;
            case DOWN -> direction = Direction.LEFT;
            case RIGHT -> direction = Direction.DOWN;
            case LEFT -> direction = Direction.UP;
        }
    }
}
