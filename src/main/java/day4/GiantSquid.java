package day4;

import java.io.File;
import java.net.URISyntaxException;

public class GiantSquid {

    public static int calculateFirstWinningBoardScore(File file) {
        BingoFileReader bingoFileReader = new BingoFileReader(file);

        int winningRound = 0;
        BingoBoard winningBoard = null;
        outerLoop:
        for (int i = 4; i < bingoFileReader.getCalledNumbers().size(); i++) {
            for (BingoBoard bingoBoard : bingoFileReader.getBingoBoards()) {
                if(bingoBoard.isWinner(bingoFileReader.getCalledNumbers().subList(0,i))) {
                    winningRound = i;
                    winningBoard = bingoBoard;
                    break outerLoop;
                }
            }
        }

        int wingingBoardValue = winningBoard.sumOfRemainingNumbers(bingoFileReader.getCalledNumbers().subList(0,winningRound));
        int winningValue = bingoFileReader.getCalledNumbers().get(winningRound - 1);

        return wingingBoardValue * winningValue;
    }

    public static int calculateLastWinningBoardScore(File file) {
        BingoFileReader bingoFileReader = new BingoFileReader(file);

        int lastWinningRound = 0;
        BingoBoard lastWinningBoard = null;
        int i = bingoFileReader.getCalledNumbers().size();
        outerLoop:
        while (true) {
            for (BingoBoard bingoBoard : bingoFileReader.getBingoBoards()) {
                if (!bingoBoard.isWinner(bingoFileReader.getCalledNumbers().subList(0, i))) {
                    lastWinningRound = i;
                    lastWinningBoard = bingoBoard;
                    break outerLoop;
                }
            }
            i--;
        }

        int wingingBoardValue = lastWinningBoard.sumOfRemainingNumbers(bingoFileReader.getCalledNumbers().subList(0,lastWinningRound + 1));
        int winningValue = bingoFileReader.getCalledNumbers().get(lastWinningRound);

        return wingingBoardValue * winningValue;
    }

    public static void main(String[] args) throws URISyntaxException {
        File testFile = new File(GiantSquid.class.getResource("/day4/input.txt").toURI());
        System.out.println(GiantSquid.calculateFirstWinningBoardScore(testFile));
        System.out.println(GiantSquid.calculateLastWinningBoardScore(testFile));
    }

}
