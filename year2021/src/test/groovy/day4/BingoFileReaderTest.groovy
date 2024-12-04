package day4

import com.schneider.year2021.day4.BingoBoard
import com.schneider.year2021.day4.BingoFileReader
import spock.lang.Specification

class BingoFileReaderTest extends Specification {

    def "A bingo board input file can be read in"() {
        given: "I have a input file"
            File testFile = new File(getClass().getResource('/day4/testInput.txt').toURI())
        when: "I read the input file"
        BingoFileReader bingoFileReader = new BingoFileReader(testFile);
        then: "I read the input file correctly"
            ArrayList<BingoBoard> actualBingoBoards = bingoFileReader.getBingoBoards()
            ArrayList<BingoBoard> expectedBingoBoards = allExpectedBingoBoards()
            actualBingoBoards.equals(expectedBingoBoards)
            bingoFileReader.getCalledNumbers().equals(Arrays.asList(7,4,9,5,11,17,23,2,0,14,21,24,10,16,13,6,15,25,12,22,18,20,8,19,3,26,1))
    }

    private ArrayList<BingoBoard> allExpectedBingoBoards() {
        ArrayList<BingoBoard> boards = new ArrayList<>()
        boards.add(createBoard1())
        boards.add(createBoard2())
        boards.add(createBoard3())
        return boards
    }

    private BingoBoard createBoard1() {
        ArrayList<ArrayList<Integer>> boardArray = new ArrayList<ArrayList>()
        ArrayList<Integer> row1 = new ArrayList<>()
        row1.add(22)
        row1.add(13)
        row1.add(17)
        row1.add(11)
        row1.add(0)
        boardArray.add(row1)

        ArrayList<Integer> row2 = new ArrayList<>()
        row2.add(8)
        row2.add(2)
        row2.add(23)
        row2.add(4)
        row2.add(24)
        boardArray.add(row2)

        ArrayList<Integer> row3 = new ArrayList<>()
        row3.add(21)
        row3.add(9)
        row3.add(14)
        row3.add(16)
        row3.add(7)
        boardArray.add(row3)

        ArrayList<Integer> row4 = new ArrayList<>()
        row4.add(6)
        row4.add(10)
        row4.add(3)
        row4.add(18)
        row4.add(5)
        boardArray.add(row4)

        ArrayList<Integer> row5 = new ArrayList<>()
        row5.add(1)
        row5.add(12)
        row5.add(20)
        row5.add(15)
        row5.add(19)
        boardArray.add(row5)
        return new BingoBoard(boardArray)
    }

    private BingoBoard createBoard2() {
        ArrayList<ArrayList<Integer>> boardArray = new ArrayList<ArrayList>()
        ArrayList<Integer> row1 = new ArrayList<>()
        row1.add(3)
        row1.add(15)
        row1.add(0)
        row1.add(2)
        row1.add(22)
        boardArray.add(row1)

        ArrayList<Integer> row2 = new ArrayList<>()
        row2.add(9)
        row2.add(18)
        row2.add(13)
        row2.add(17)
        row2.add(5)
        boardArray.add(row2)

        ArrayList<Integer> row3 = new ArrayList<>()
        row3.add(19)
        row3.add(8)
        row3.add(7)
        row3.add(25)
        row3.add(23)
        boardArray.add(row3)

        ArrayList<Integer> row4 = new ArrayList<>()
        row4.add(20)
        row4.add(11)
        row4.add(10)
        row4.add(24)
        row4.add(4)
        boardArray.add(row4)

        ArrayList<Integer> row5 = new ArrayList<>()
        row5.add(14)
        row5.add(21)
        row5.add(16)
        row5.add(12)
        row5.add(6)
        boardArray.add(row5)
        return new BingoBoard(boardArray)
    }

    private BingoBoard createBoard3() {
        ArrayList<ArrayList<Integer>> boardArray = new ArrayList<ArrayList>()
        ArrayList<Integer> row1 = new ArrayList<>()
        row1.add(14)
        row1.add(21)
        row1.add(17)
        row1.add(24)
        row1.add(4)
        boardArray.add(row1)

        ArrayList<Integer> row2 = new ArrayList<>()
        row2.add(10)
        row2.add(16)
        row2.add(15)
        row2.add(9)
        row2.add(19)
        boardArray.add(row2)

        ArrayList<Integer> row3 = new ArrayList<>()
        row3.add(18)
        row3.add(8)
        row3.add(23)
        row3.add(26)
        row3.add(20)
        boardArray.add(row3)

        ArrayList<Integer> row4 = new ArrayList<>()
        row4.add(22)
        row4.add(11)
        row4.add(13)
        row4.add(6)
        row4.add(5)
        boardArray.add(row4)

        ArrayList<Integer> row5 = new ArrayList<>()
        row5.add(2)
        row5.add(0)
        row5.add(12)
        row5.add(3)
        row5.add(7)
        boardArray.add(row5)
        return new BingoBoard(boardArray)
    }
}
