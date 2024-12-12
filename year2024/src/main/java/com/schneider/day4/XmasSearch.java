package com.schneider.day4;

import com.schneider.util.ReadFile;

import java.io.File;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class XmasSearch {

    public static void main(String[] args) {
        try {
            File testFile = new File(XmasSearch.class.getClassLoader().getResource("day4/input.txt").toURI());
            List<String> wordSearchBoardList = ReadFile.toStringList(testFile);
            System.out.println(count(wordSearchBoardList));

        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public static int count(List<String> wordSearchBoard) {
        List<Coordinate> board = convertBoard(wordSearchBoard);
        return (int) board.stream()
                .filter(coordinate -> coordinate.c == 'A')
                .filter(coordinate -> isXmas(coordinate, board))
                .count();
    }

    private static List<Coordinate> convertBoard(List<String> wordSearchBoard) {
        ArrayList<Coordinate> board = new ArrayList<>();
        for (int y = 0; y < wordSearchBoard.size(); y++) {
            for (int x = 0; x < wordSearchBoard.get(y).length(); x++) {
                board.add(new Coordinate(x, y, wordSearchBoard.get(y).charAt(x)));
            }
        }
        return board;
    }

    private static boolean isXmas(Coordinate coordinate, List<Coordinate> board) {
        Optional<Coordinate> topLeft =
                board.stream().filter(c -> c.xPos == coordinate.xPos - 1 && c.yPos == coordinate.yPos - 1).findAny();
        Optional<Coordinate> topRight =
                board.stream().filter(c -> c.xPos == coordinate.xPos + 1 && c.yPos == coordinate.yPos - 1).findAny();
        Optional<Coordinate> bottomLeft =
                board.stream().filter(c -> c.xPos == coordinate.xPos - 1 && c.yPos == coordinate.yPos + 1).findAny();
        Optional<Coordinate> bottomRight =
                board.stream().filter(c -> c.xPos == coordinate.xPos + 1 && c.yPos == coordinate.yPos + 1).findAny();

        if (topLeft.isEmpty() || topRight.isEmpty() || bottomLeft.isEmpty() || bottomRight.isEmpty()) {
            return false;
        }

        boolean diagonal1 = topLeft.get().c == 'M' && bottomRight.get().c == 'S' || topLeft.get().c == 'S' && bottomRight.get().c == 'M';
        boolean diagonal2 = topRight.get().c == 'M' && bottomLeft.get().c == 'S' || topRight.get().c == 'S' && bottomLeft.get().c == 'M';

        return diagonal1 && diagonal2;
    }

    private record Coordinate(int xPos, int yPos, char c) {
    }
}
