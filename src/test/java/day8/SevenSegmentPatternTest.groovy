package day8

import spock.lang.Specification

class SevenSegmentPatternTest extends Specification {

    def "Count 1's, 4's, 7's and 8's from a signal" () {
        given: "A signal pattern"
            def pattern = new SevenSegmentPattern("be cfbegad cbdgef fgaecd cgeb fdcge agebfd fecdb fabcd edb | fdgacbe cefdb cefbgd gcbe")
        when: "I count the number of 1's, 4's, 7's and 8's"
            int count = pattern.count147and8()
        then: "I get the correct answer"
            count == 2
    }
}
