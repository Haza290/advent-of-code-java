package day4

import com.schneider.year2021.day4.BingoBoard
import spock.lang.Specification

class BingoBoardTest extends Specification {

    
    private ArrayList<ArrayList<Integer>> testBoard = new ArrayList<>()

    def "Checks if winning boards has won"() {
        given: "A bingo board"
            BingoBoard winningBoard = new BingoBoard(this.testBoard)
            ArrayList<Integer> IntegerArray = Arrays.asList(7,4,9,5,11,17,23,2,0,14,21,24)
        when: "I give it a winning list of numbers"
            boolean isWinner = winningBoard.isWinner(IntegerArray)
        then: "I return that it is a winning board"
            isWinner
    }

    def "Checks if non winning boards has won"() {
        given: "A bingo board"
            BingoBoard winningBoard = new BingoBoard(this.testBoard)
            ArrayList<Integer> IntegerArray = Arrays.asList(7,4,9,5,11,17,23,2,0,14,21)
        when: "I give it a non winning list of numbers"
            boolean isWinner = winningBoard.isWinner(IntegerArray);
        then: "I return that it is not a winning board"
            !isWinner
    }

    def "Sum all remaining values after a board has won"() {
        given: "A winning bingo board and called numbers"
            BingoBoard winningBoard = new BingoBoard(this.testBoard)
            ArrayList<Integer> IntegerArray = Arrays.asList(7,4,9,5,11,17,23,2,0,14,21,24)
        when: "I calculate the sum of all remaining numbers"
            int actualSumOfRemainingNumbers = winningBoard.sumOfRemainingNumbers(IntegerArray)
        then: "I get the correct answer"
            actualSumOfRemainingNumbers == 188
    }

    private void setup() {
        ArrayList<Integer> row1 = new ArrayList<>()
        row1.add(14)
        row1.add(21)
        row1.add(17)
        row1.add(24)
        row1.add(4)
        this.testBoard.add(row1)

        ArrayList<Integer> row2 = new ArrayList<>()
        row2.add(10)
        row2.add(16)
        row2.add(15)
        row2.add(9)
        row2.add(19)
        this.testBoard.add(row2)

        ArrayList<Integer> row3 = new ArrayList<>()
        row3.add(18)
        row3.add(8)
        row3.add(23)
        row3.add(26)
        row3.add(20)
        this.testBoard.add(row3)

        ArrayList<Integer> row4 = new ArrayList<>()
        row4.add(22)
        row4.add(11)
        row4.add(13)
        row4.add(6)
        row4.add(5)
        this.testBoard.add(row4)

        ArrayList<Integer> row5 = new ArrayList<>()
        row5.add(2)
        row5.add(0)
        row5.add(12)
        row5.add(3)
        row5.add(7)
        this.testBoard.add(row5)
    }
}
