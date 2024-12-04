package com.schneider.year2021.day4;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode
public class BingoBoard {

    @Getter
    private final ArrayList<ArrayList<Integer>> board;

    public BingoBoard(ArrayList<ArrayList<Integer>> board) {
        this.board = board;
    }

    public int sumOfRemainingNumbers(List<Integer> calledNumbers) {
        ArrayList<Integer> allValues = new ArrayList<>();
        board.stream().forEach(allValues::addAll);
        allValues.removeAll(calledNumbers);
        return allValues.stream().reduce(0, Integer::sum);
    }

    public boolean isWinner(List<Integer> calledNumbers) {
        ArrayList<ArrayList<Integer>> allLines = getAllLines();
        return allLines.stream().anyMatch(row -> checkLine(row, calledNumbers));
    }

    private ArrayList<ArrayList<Integer>> getAllLines() {
        ArrayList<ArrayList<Integer>> allLines = new ArrayList<>();
        allLines.addAll(this.board);
        allLines.addAll(getAllColumns());
        return allLines;
    }

    private ArrayList<ArrayList<Integer>> getAllColumns() {
        ArrayList<ArrayList<Integer>> allColumns = new ArrayList<>();
        for (int i = 0; i < this.board.size(); i++) {
            ArrayList<Integer> column = new ArrayList<>();
            for (int j = 0; j < this.board.size(); j++) {
                ArrayList<Integer> integers = (ArrayList<Integer>) this.board.get(j);
                Integer integer = integers.get(i);
                column.add(integer);
            }
            allColumns.add(column);
        }
        return allColumns;
    }

    private static boolean checkLine(ArrayList<Integer> line, List<Integer> calledNumbers) {
        return calledNumbers.containsAll(line);
    }
}
