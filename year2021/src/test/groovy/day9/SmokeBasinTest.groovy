package day9

import com.schneider.year2021.day9.SmokeBasin
import spock.lang.Specification

class SmokeBasinTest extends Specification {

    def "Sum risk levels og a given map file"() {
        given: "A map file"
            File testFile = new File(getClass().getResource('/day9/testInput.txt').toURI())
        when: "We calculate the sum the risk levels"
            int answer = SmokeBasin.sumRiskLevels(testFile)
        then: "We get the right answer"
            answer == 15
    }
}
