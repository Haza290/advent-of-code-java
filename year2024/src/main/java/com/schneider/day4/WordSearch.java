package com.schneider.day4;

import com.schneider.util.ReadFile;
import lombok.RequiredArgsConstructor;

import java.io.File;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Pattern;

public class WordSearch {

    public static void main(String[] args) {
        try {
            File testFile = new File(WordSearch.class.getClassLoader().getResource("day4/input.txt").toURI());
            List<String> wordSearchBoardList = ReadFile.toStringList(testFile);
            System.out.println(count(wordSearchBoardList, "XMAS"));

        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public static int count(List<String> wordSearchBoardList, String word) {
        WordSearchBoard board = new WordSearchBoard(wordSearchBoardList);
        return board.getWordCount(word);
    }


    @RequiredArgsConstructor
    private static class WordSearchBoard {
        private final List<String> wordSearchBoardList;


        public int getWordCount(String word) {
            Pattern pattern = Pattern.compile(new StringBuilder(word).reverse().toString());
            Pattern backwardsPattern = Pattern.compile(word);
            int matches = 0;
            for (String line : getFlattenedWordSearchBoardList()) {
                matches += (int) pattern.matcher(line).results().count();
                matches += (int) backwardsPattern.matcher(line).results().count();
            }

            return matches;

        }

        private List<String> getFlattenedWordSearchBoardList() {
            List<String> flattenedWordSearchBoardList = new ArrayList<>(wordSearchBoardList);
            flattenedWordSearchBoardList.addAll(getVerticalWordSearchList());
            flattenedWordSearchBoardList.addAll(getDiagonalWordSearchList());

            return flattenedWordSearchBoardList;
        }

        private Collection<String> getVerticalWordSearchList() {
            List<String> verticalWordSearchList = new ArrayList<>();
            for (int x = 0; x < wordSearchBoardList.get(0).length(); x++) {
                StringBuilder verticalWord = new StringBuilder();
                for (String s : wordSearchBoardList) {
                    verticalWord.append(s.charAt(x));
                }
                verticalWordSearchList.add(verticalWord.toString());
            }
            return verticalWordSearchList;
        }

        private Collection<String> getDiagonalWordSearchList() {
            List<String> diagonalWordSearchList = new ArrayList<>();
            // diagonals starting from the top of the board
            for (int x = 0; x < wordSearchBoardList.get(0).length(); x++) {
                diagonalWordSearchList.add(getDiagonalLine(x, 0, true));
                diagonalWordSearchList.add(getDiagonalLine(x, 0, false));
            }
            // diagonals starting from the edge of the board
            for (int y = 1; y < wordSearchBoardList.size(); y++) {
                diagonalWordSearchList.add(getDiagonalLine(0, y, true));
                diagonalWordSearchList.add(getDiagonalLine(wordSearchBoardList.get(y).length() - 1, y, false));
            }
            return diagonalWordSearchList;
        }

        private String getDiagonalLine(int xPos, int yPos, boolean downRight) {
            StringBuilder line = new StringBuilder();
            while (yPos < wordSearchBoardList.size() && xPos < wordSearchBoardList.get(yPos).length() && xPos >= 0) {
                line.append(wordSearchBoardList.get(yPos).charAt(xPos));
                if (downRight) {
                    xPos++;
                } else {
                    xPos--;
                }
                yPos++;
            }
            return line.toString();
        }
    }
}
