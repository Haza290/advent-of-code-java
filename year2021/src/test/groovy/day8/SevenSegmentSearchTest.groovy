package day8

import com.schneider.year2021.day8.SevenSegmentSearch
import spock.lang.Specification

class SevenSegmentSearchTest extends Specification {

    def "Count number of 1's, 4's, 7's and 8's from a signal set" () {
        given: "A set of signals"
            File testFile = new File(getClass().getResource('/day8/testInput.txt').toURI())
        SevenSegmentSearch sevenSegmentSearch = new SevenSegmentSearch(testFile)
        when: "I count the number of 1's, 4's, 7's and 8's in the signal set"
            int count = sevenSegmentSearch.count1478Outputs()
        then: "I get the correct answer"
            count == 26
    }

    def "Sum all output vales from patterns"() {
        given: "A set of signals"
            File testFile = new File(getClass().getResource('/day8/testInput.txt').toURI())
            SevenSegmentSearch sevenSegmentSearch = new SevenSegmentSearch(testFile)
        when: "I sum the output values of all the patterns"
            long count = sevenSegmentSearch.sumOutputs()
        then: "I get the correct answer"
            count == 61229
    }
}
