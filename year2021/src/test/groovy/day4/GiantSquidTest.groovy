package day4

import com.schneider.year2021.day4.GiantSquid
import spock.lang.Specification

class GiantSquidTest extends Specification {

    def "Calculate first winning board score" () {
        given: "I have a input file"
            File testFile = new File(getClass().getResource('/day4/testInput.txt').toURI())
        when: "I calculate the first winning board score"
            int score = GiantSquid.calculateFirstWinningBoardScore(testFile)
        then: "I get the correct score"
            score == 4512
    }

    def "Calculate last winning board score" () {
        given: "I have a input file"
            File testFile = new File(getClass().getResource('/day4/testInput.txt').toURI())
        when: "I calculate the last winning board score"
            int score = GiantSquid.calculateLastWinningBoardScore(testFile)
        then: "I get the correct score"
            score == 1924
    }

}
