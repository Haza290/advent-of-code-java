package com.schneider.year2021.day5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Line {

    private final int x1, y1, x2, y2;

    public Line(String lineString) {
        List<Integer> splitString = Arrays.stream(lineString.split("->|,"))
                .map(s -> s.replaceAll("\\s+", ""))
                .map(Integer::parseInt)
                .toList();
        this.x1 = splitString.get(0);
        this.y1 = splitString.get(1);
        this.x2 = splitString.get(2);
        this.y2 = splitString.get(3);
    }

    public boolean isAxial() {
        return this.x1 == this.x2 || this.y1 == this.y2;
    }

    public ArrayList<Coordinate> getCoordinates() {
        int xIncrement = 0;
        int yIncrement = 0;
        if (this.x1 < this.x2) {
            xIncrement = 1;
        } else if (this.x1 > this.x2) {
            xIncrement = -1;
        }
        if (this.y1 < this.y2) {
            yIncrement = 1;
        } else if (this.y1 > this.y2) {
            yIncrement = -1;
        }
        ArrayList<Coordinate> coordinates = new ArrayList<>();
        int difference = Math.max(Math.abs(this.x1 - this.x2), Math.abs(this.y1 - this.y2)) + 1;
        int xOffset = 0;
        int yOffset = 0;
        while (difference > Math.abs(xOffset) && difference > Math.abs(yOffset)) {
            coordinates.add(new Coordinate(this.x1 + xOffset, this.y1 + yOffset));
            xOffset += xIncrement;
            yOffset += yIncrement;
        }
        return coordinates;
    }
}
