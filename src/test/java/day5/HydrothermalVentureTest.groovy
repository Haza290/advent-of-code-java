package day5

import spock.lang.Specification

class HydrothermalVentureTest extends Specification {

    def "Calculate the number of points hit by multiple axial lines"() {
        given: "I have a input file"
            File testFile = new File(getClass().getResource('/day5/testInput.txt').toURI())
        when: "I calculate the number of points hit by multiple lines"
            int count = HydrothermalVenture.pointsWithMultipleHitsCount(testFile, true)
        then: "I get the correct answer"
            count == 5
    }

    def "Calculate the number of points hit by multiple lines"() {
        given: "I have a input file"
        File testFile = new File(getClass().getResource('/day5/testInput.txt').toURI())
        when: "I calculate the number of points hit by multiple lines"
        int count = HydrothermalVenture.pointsWithMultipleHitsCount(testFile, false)
        then: "I get the correct answer"
        count == 12
    }
}
